/*
Developing a job handler for PS_SectorJob
For this handler, a new class is derived from PS_SectorJobHandler.
Provided are new implementations for the members where callbacks to user code are desired.
The handler is then registered on a per-job basis with EMPIRE using PS_SectorJob::JobHandler().
Each job object can maintain its own handler.

In this handler, callbacks are provided for obtaining status reports, job cancellation, and,
most importantly, obtaining propogation loss results on a radial-by-radial basis. All other
PS_JobHandler members are left to their default behavior, which is to do nothing.
*/
#ifndef SIMPLEJOB_HANDLER_H
#define SIMPLEJOB_HANDLER_H

#include <PS_SectorJobHandler.h>
#include <PS_JobStatus.h>
#include <PS_UniformRadial.h>
using namespace std;
// Somehow, a hook or another process could set this flag to
// ’true’ to have the job cancelled.
extern bool SimpleJobHandlerCancelFlag;
// Create a class derived from PS SectorJobHandler to implement
// callbacks for events.
class SimpleJobHandler : public PS_SectorJobHandler
{
public:
    SimpleJobHandler(void)
    {
        this->SetType(PS_TYPE_USER + 2);
        return;
    }
    ~SimpleJobHandler(void) { return; }
    PS_JobHandler& StatusReport(const PS_JobStatus &status)
    {
        /*
        // If you'd like to print a job status report:
        cout << "SimpleJobHandler::StatusReport( ) - "
             << "calculation status report as follows:" << endl;
        status.Print(cout, "\t");
        */
        return *this;
    }
    bool CancelJob(void)
    {
        if (SimpleJobHandlerCancelFlag)
        {
            cout << "SimpleJobHandler::CancelJob( ) - "
                 << "indicating to cancel job." << endl;
            return true;
        }
        else
        {
            return false;
        }
    }
    // Default behavior except for the NewRadial member
    SimpleJobHandler &NewRadial(long rIdx,
                                const PS_UniformRadial &ur)
    {
        /*
        // If you'd lke to print job details for each radial calculation:
        cout << "SimpleJobHandler::NewRadial( ) - "
             << "called for rIdx = " << rIdx << endl;
        ur.Print(cout, "\t");
        */
        return *this;
    }
};
#endif