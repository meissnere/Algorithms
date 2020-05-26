#include "include/async_job.h"
#include "include/job_handler.h"
#include <iostream>
#include <napi.h>
#include <string>
#include <sstream>
#include "PS_ModelSpecs.h"
#include "PS_ModelIdentifier.h"
#include <P_LoggingFacility.h>
#include <PS_SectorJob.h>
#include <P_MessageCollection.h>
#include <PS_Point.h>
#include <PS_SectorSamples.h>
#include <PS_SectorBounds.h>
#include <auxlib/PS_HDF5.h>
#include <PS_TerrainRadial.h>
#include <PS_FoliageSLCR.h>
#include <PS_IonosphereSimple.h>
// #include <AS_Isotropic.h>
#include <P_LoggingFacility.h>
// #include <ant/AS_Keyhole.h>
#include <P_Array.h>
#include <P_String.h>
#include <P_Utils.h>

// a flag checked by the jobhandler::CalcelJob() so that another process
// could set this flag to 1 to have the job cancelled.
bool SimpleJobHandlerCancelFlag = 0;

using namespace std;

struct GeoCoordinate_t
{
private:
    long double latitude;
    long double longitude;

public:
    // setter for geoCoord
    void setGeoCoordinate(long double lat, long double lon)
    {
        if (lon > 180)
        {
            lon = 180;
        }
        else if (lon < -180)
        {
            lon = -180;
        }
        if (lat > 90)
        {
            lat = 90;
        }
        else if (lat < -90)
        {
            lat = -90;
        }
        this->latitude = lat;
        this->longitude = lon;
    }
    long double getLat()
    {
        return latitude;
    }
    long double getLong()
    {
        return longitude;
    }
    string geoToString()
    {
        string latLong = "(" + to_string(latitude) + ", " + to_string(longitude) + ")";
        return latLong;
    }
} GeoCoordinate;

// C++ program to calculate Distance
// Between Two Points on Earth
#include <bits/stdc++.h>

// Utility function for
// converting degrees to radians
long double toRadians(const long double degree)
{
    // cmath library in C++
    // defines the constant
    // M_PI as the value of
    // pi accurate to 1e-30
    long double one_deg = (M_PI) / 180;
    return (one_deg * degree);
}

long double distance(long double lat1, long double long1,
                     long double lat2, long double long2)
{
    // Convert the latitudes
    // and longitudes
    // from degree to radians.
    lat1 = toRadians(lat1);
    long1 = toRadians(long1);
    lat2 = toRadians(lat2);
    long2 = toRadians(long2);

    // Haversine Formula
    long double dlong = long2 - long1;
    long double dlat = lat2 - lat1;

    long double ans = pow(sin(dlat / 2), 2) +
                      cos(lat1) * cos(lat2) *
                          pow(sin(dlong / 2), 2);

    ans = 2 * asin(sqrt(ans));

    // Radius of Earth in
    // Kilometers, R = 6371
    // Use R = 3956 for miles
    long double R = 6371;

    // Calculate the result
    ans = ans * R;

    return ans;
}

class RequestObj
{
private:
    // private attributes for request object
    // emitter location, height, etc...
    long double emitterLat;
    long double emitterLong;
    long double emitterHeight;
    float emitterGain;
    // receiver location, height, etc...
    long double receiverLong;
    long double receiverLat;
    float receiverHeight;
    float receiverGain;
    // propogation model specified
    string propModel;
    // more params required by EMPIRE library
    long double propDistance;
    float emitterFreq;

public:
    // setters for request attributes:
    void setEmitterLoc(long double emitLat, long double emitLon)
    {
        GeoCoordinate.setGeoCoordinate(emitLat, emitLon);
        emitterLat = GeoCoordinate.getLat();
        emitterLong = GeoCoordinate.getLong();
        cout << "Emitter is: " << GeoCoordinate.geoToString() << endl;
    }
    void setReceiverLoc(long double recvLat, long double recvLon)
    {
        GeoCoordinate.setGeoCoordinate(recvLat, recvLon);
        receiverLat = GeoCoordinate.getLat();
        receiverLong = GeoCoordinate.getLong();
        cout << "Receiver is: " << GeoCoordinate.geoToString() << endl;
    }
    void setDistance(long double lat1, long double long1, long double lat2, long double long2) {
        propDistance = distance(lat1, long1, lat2, long2);
    }
    void setEmitterHeight(long double emitHght)
    {
        emitterHeight = emitHght;
    }
    void setEmitterFreq(float freq)
    {
        emitterFreq = freq;
    }
    // getter for some request attribute values
    long double getEmitLong()
    {
        return emitterLong;
    }
    long double getEmitLat()
    {
        return emitterLat;
    }
    long double getRecvLong()
    {
        return receiverLong;
    }
    long double getRecvLat()
    {
        return receiverLat;
    }
    long double getDist()
    {
        return propDistance;
    }
    long double getEmitHght()
    {
        return emitterHeight;
    }
    long double getEmitFreq()
    {
        return emitterFreq;
    }
};

class LossResponse
{
private:
    // private attributes for response object
    map<int, vector<long double>> bearingMap;

public:
    // setter to create a map entry:
    void propPut(int bearingKey, vector<long double> rangeToPropLoss)
    {
        bearingMap[bearingKey] = rangeToPropLoss;
    }
    // getter to display map values (0 -> 360)
    map<int, vector<long double>> get_map() {
        return bearingMap;
    }
    void print_map()
    {
        for (auto const &pair : this->bearingMap)
        {
            ostringstream oss;
            copy(pair.second.begin(), pair.second.end(), ostream_iterator<long double>(oss, ","));
            std::cout << "{" << pair.first << ": " << oss.str() << "}\n";
        }
    }
};

using namespace Napi;
AsyncJob::AsyncJob(Napi::Env env, const char *resource_name, const Napi::Object &resource)
    : AsyncWorker(env, resource_name, resource), _deferred(Napi::Promise::Deferred::New(env))
{
}
AsyncJob::~AsyncJob() {}

// develop some result objet
void AsyncJob::Execute()
{
    // node convert.js 33.21716125904217 -114.341657597711 33.307225 -114.346013
    // distance 4.156462697931047 bearing 83.30885924116922
    RequestObj newJob;
    newJob.setEmitterLoc(33.21716125904217, -114.341657597711);
    newJob.setReceiverLoc(33.307225, -114.346013);
    newJob.setEmitterHeight(387.18548395801474);
    newJob.setEmitterFreq(68000000);
    newJob.setDistance(newJob.getEmitLat(), newJob.getEmitLong(), newJob.getRecvLat(), newJob.getRecvLong());

    cout << newJob.getDist()
         << " Kilometers"
         << endl
         << endl;

    /*
    Once all the required environmental and antenna data is available
    to EMPIRE through the request, a propogation loss calculation can
    be done using this data.

    We specify terrain and antenna classes based on the definitions given
    by the call back handler. We also have a call back handler. The start
    location and region over which to calculate are provided via the request.
    Once this input is collected, the parameters are validated, and then the 
    propogation loss is finally calculated. The results are then processed.
    */

    std::cout << "Sector Calculation" << std::endl;
    std::cout << PS_Base::BuildString() << std::endl
              << std::endl;
    P_LoggingFacility::setOutputLevel(0);

    /*
    // The following prints out the EMPIRE linked libraries and their dependencies.
    int i;
    // Next, we use some PLIB general utility classes to print build and
    // dependency strings.
    P_Array<P_String> strings;
    P_GetLibraryBuildStrings(strings);
    cout << "Build strings for all linked libraries providing "
         << "this information:" << endl;
    for (i = 0; i < strings.entries(); i++)
    {
        cout << "\t" << strings[i] << endl;
    }
    strings.clear();
    P_GetLibraryDependencies(strings);
    cout << "Dependencies for all linked libraries providing this"
         << "information:" << endl;
    for (i = 0; i < strings.entries(); i++)
    {
        cout << "\t" << strings[i] << endl;
    }
    */

    // Next, let's build our sector. The location and bounds are set by the request
    // enum PS_AltitudeType { PS_MSL, PS_AGL };
    // MSL = mean sea level; AGL = above ground level
    // bounds(startBearing, endBearing, minRange, maxRange, minHeight, maxHeight)
    double reqRange = newJob.getDist() * 1000;
    PS_SectorBounds bounds(0, 360, 0, reqRange, 2.0, 2.0, PS_MSL);
    // samples(bearingCount, rangeCount, heightCount)
    PS_SectorSamples samples(11, 4, 1); // for a long job
    // startPoint(lat, long, elevation)
    PS_Point startPoint(newJob.getEmitLat(), newJob.getEmitLong(), newJob.getEmitHght(), PS_AGL);
    /*
    // Print out the component sector information if desired.
    bounds.Print(cout << endl
                      << endl);
    samples.Print(cout << endl
                       << endl);
    startPoint.Print(cout << endl
                          << endl);
    */

    // The job we create uses the EMPIRE FREESPACE propogation model.
    // Frequency set is specified by the request parameters.
    PS_ModelIdentifier var("EMPIRE", "FREESPACE");
    // conversion to MHz
    float emitFreq = newJob.getEmitFreq() / 1000000;
    PS_SectorJob job(&var, emitFreq, startPoint, bounds, samples);
    // Callbacks are set up next
    SimpleJobHandler handler;
    handler.Interval(1); // every 1 second, we get a status report
    job.JobHandler(&handler);
    // Validate the job parameters against the chosen model of FREESPACE.
    // We set this up to display any warnings that are issued. The parameter
    // validation is performed when a job is calculated anyway. Unless there
    // is a fatal error, a job is always calculated.
    P_MessageCollection msgs = job.ValidateModelParams();
    /*
    // If you'd like to print out the validation messages:
    cout << endl
         << "Messages produced by parameter"
         << " validation:" << endl;
    msgs.PrintMessages(cout, "\t");
    cout << endl;
    */

    // Create a pointer for the extracted data.
    PS_UniformSector *us = NULL;
    int rc = 0;
    // from P_Message library:
    // enum Ranking { None, Informational, Corrected, Warning, Fatal };
    if (msgs.HighestRank() < P_Message::Fatal)
    {
        cout << "Calculating. . ." << endl;
        msgs = job.Calculate(&us);
        cout << "Job finished!" << endl
             << endl;
        /*
        cout << "The messages for the job are:" << endl;
        // If you'd like to print out the detailed report of the job that just completed:
        msgs.PrintMessages(cout, "\t");
        cout << endl;
        */

        // Even if there were fatal errors, there may be some
        // data available. Take a look at it if it exists.
        if (NULL != us)
        {
            // Take a look at the calculated data. The data would
            // normally be saved to a file, plotted to the screen,
            // etc...
            // Ordered hash map to map each range bearing (integer from [0,360]) to the
            // prop loss value (long double). O(log N) insert time due to ordering
            LossResponse propResponse;
            /*
            // If you'd like the EMPIRE standard for viewing prop loss:
            cout << "PROP LOSS VALUE @ (0,0,0): " << us->getPropLoss(0, 0, 0) << endl;
            cout << us->Print(cout) << endl;
            cout << us->Publish(cout) << endl;
            */
            int i = 0;
            int rangeIdx;
            int rangeBearing = 0;
            while (i < 11)
            {
                rangeIdx = 0;
                vector<long double> rangeToProp;
                while (rangeIdx < 4)
                {
                    rangeToProp.push_back(rangeIdx);
                    rangeToProp.push_back(us->getPropLoss(i, rangeIdx, 0));
                    rangeIdx++;
                }
                propResponse.propPut(rangeBearing, rangeToProp);
                rangeBearing = rangeBearing + 36;
                i++;
            }
            propResponse.print_map();
        }
        else
        {
            cout << "No data was returned." << endl;
            rc = 1;
        }
    }
    else
    {
        cout << "There was a fatal error in validating "
             << "the PS_SectorJob" << endl;
        rc = 1;
    }
    if (us != NULL)
    {
        delete us;
        us = NULL;
    }
    cout << "SectorCalc program finished." << endl;
    cout << "rc value is: " << rc << endl;
}

void AsyncJob::OnOK()
{
    std::cout << "Asnynchronous process completed; we call resolve method on the promise" << std::endl;
    _deferred.Resolve(Napi::Value(Napi::String::New(Env(), "Napi Success")));
}

void AsyncJob::OnError(const Napi::Error & /* e */)
{
    _deferred.Reject(Env().Undefined());
}

// parameters that calc prop loss based on bounds passed
Napi::Value AsyncJob::CaclulatePropLoss(const Napi::CallbackInfo &info)
{
    Napi::Object resource = info[0].As<Napi::Object>();
    AsyncJob *asJob = new AsyncJob(info.Env(), "Resource", resource);
    asJob->Queue();
    return asJob->_deferred.Promise();
}