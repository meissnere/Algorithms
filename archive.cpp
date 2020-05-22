// std::cout << "Computing Loss; Current library version is:" << std::endl;
    // std::cout << PS_Base::BuildString() << std::endl;
    // // EMPIRE can provide a large amount of logging as it computes through the
    // // P_LoggingFacility class. I will keep the defaul level of 0:
    // P_LoggingFacility::setOutputLevel(0);
    // // Next step is to set the bounds of this job based on the request:
    // PS_SectorBounds bounds(100, 100, 1000.0, 3000.0, 100.0, 1100.0, PS_MSL);
    // PS_SectorSamples samples(1, 201, 101);
    // PS_Point startPoint(0, 0, 5, PS_AGL);
    // // Create a job for this sector, setting FREESPACE as the
    // // propagation model to use, and 1GHz as the frequency.
    // // The FREESPACE model, only a line-of-sight path between
    // // transmitter and receiver is used to cpmute the transmission
    // // loss.
    // PS_ModelIdentifier var("EMPIRE", "FREESPACE");
    // PS_SectorJob job(&var, 1000.0, startPoint, bounds, samples);
    // // Create a pointer for the extracted data.
    // PS_UniformSector *us = NULL;
    // P_MessageCollection msgs = job.Calculate(&us);
    // us->Print(std::cout);
    // msgs.PrintMessages(std::cout);
    // msgs.isEmpty();
    // // if (NULL != us)
    // // {
    // //     // Write loss data to a hdf file.
    // //     PS_HDF5Save("example1", &us);
    // //     // Clean up resources.
    // //     delete us;
    // //     us = NULL;
    // // }
    // std::cout << "Completed job computation" << std::endl
    //           << std::endl
    //           << std::endl
    //           << std::endl;
    // delete us;

    // prints that the default antenna will be used
    // for start and end antenna
    // job execution time
    // job completion time
    // total wall clock time
    //

    // std::cout << "transmission loss" << std::endl
    //           << std::endl;
    // std::cout << PS Base::BuildString() << std::endl
    //           << std::endl;
    // P_LoggingFacility::setOutputLevel(0);
    // PS_SectorBounds bounds(100, 100, 1000, 3000, 100, 1000, PS_AGL);
    // PS_SectorSamples samples(1, 100, 100);
    // PS_Point startpoint(0, 0, 1, PS_AGL);
    // AS_Keyhole endAntenna(40, 0, 2, 2);
    // // Initialize and start TIREM radial
    // PS_SectorJob jobs(PS ModelIdentifier("JSC", "TIREM"), 5000.0, startpoint, bounds, samples);
    // jobs.EndAntenna(&endAntenna);
    // // PS UniformSector calculates propagation loss
    // PS_UniformSector *us = NULL;
    // // Calculate the transmission loss. This can take a long time.
    // P_MessageCollection msgs = jobs.Calculate(&us);
    // // Display messages.
    // msgs.Print(std::cout);
    // if (NULL != us)
    // {
    //     // Publish the propagation loss.
    //     us−>Publish(std::cout);
    //     // Now change the orientation of the end antenna.
    //     AS_Orientation newOrientation(100, 200, 40);
    //     us−>ReorientEndAntenna(newOrientation);
    //     // Get a new set of data. This takes very little time.
    //     us−>Publish(std::cout);
    //     // Clean up resources.
    //     delete us;
    //     us = NULL;
    // }
    // std::cout << std::endl
    //           << "transmission loss end" << std::endl;
    // // return 0;

    // std::cout << "mult prop loss" << std::endl
    //           << std::endl;
    // std::cout << PS_Base::BuildString() << std::endl
    //           << std::endl;
    // P_LoggingFacility::setOutputLevel(0);
    // PS_SectorBounds bounds(100, 100, 1000.0, 3000.0, 100.0, 1000.0, PS_MSL);
    // PS_SectorSamples samples(1, 201, 91);
    // PS_Point startPoint(55, 20, 5, PS AGL);
    // float r[5] = {0, 1250, 1750, 2250, 3000};
    // float e[5] = {1, 1, 300, 1, 1};
    // // Create Terrain
    // PS_TerrainRadial tr(startPoint, 100, 5, r, e, false);
    // // Create isotropic antenna
    // AS_Isotropic omni;
    // omni.SetGain(4.23);
    // // Create a job for this sector, setting TIREM as the
    // // propgation model to use, and 20 MHz as the frequency.
    // PS_SectorJob job(PS ModelIdentifier("JSC", "TIRE"), 20.0, startPoint, bounds, samples);
    // // Add environments to the job.
    // job.Terrain(&tr).StartAntenna(&omni);
    // // Create a pointer for the extracted data.
    // PS_UniformSector *us = NULL;
    // P_MessageCollection msgs = job.Calculate(&us);
    // msgs.Publish(std::cout);
    // // Create Foliage
    // PS_FoliageSLCR slcr(PS_Point(54, 19), PS_Point(56, 21));
    // // Add Foliage to job.
    // job.Foliage(&slcr);
    // msgs = job.Calculate(&us);
    // msgs.Publish(std::cout);
    // if (NULL != us)
    // {
    //     // Do something with the data here!
    // }
    // PS_IonosphereSimple is;
    // is.SetSunspotNumber(100).SetXrayFlux(0);
    // // Add Ionosphere and change model
    // job.Ionosphere(&is).Model(PS Model::VTRPE);
    // msgs = job.Calculate(&us);
    // msgs.Publish(std::cout);
    // if (NULL != us)
    // {
    //     // Do something with the data here!
    //     delete us;
    // }
    // std::cout << std::endl
    //           << "mult end" << std::endl;
    // // return 0;