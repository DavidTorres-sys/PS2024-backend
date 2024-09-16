package services;

import com.google.inject.AbstractModule;

import services.curb.createCurb.CreateCurbImpl;
import services.curb.createCurb.ICreateCurb;
import services.curb.deleteCurb.IDeleteCurb;
import services.curb.deleteCurb.DeleteCurbImpl;
import services.curb.readCurb.IReadCurb;
import services.curb.readCurb.ReadCurbImpl;
import services.curb.updateCurb.IUpdateCurb;
import services.curb.updateCurb.UpdateCurbImpl;
import services.road.createRoad.CreateRoadImpl;
import services.road.createRoad.ICreateRoad;
import services.road.deleteRoad.DeleteRoadImpl;
import services.road.deleteRoad.IDeleteRoad;
import services.road.readRoad.IReadRoad;
import services.road.readRoad.ReadRoadImpl;
import services.road.updateRoad.IUpdateRoad;
import services.road.updateRoad.UpdateRoadImpl;
import services.segment.createSegment.CreateSegmentImpl;
import services.segment.createSegment.ICreateSegment;
import services.segment.deleteSegment.DeleteSegmentImpl;
import services.segment.deleteSegment.IDeleteSegment;
import services.segment.readSegment.IReadSegment;
import services.segment.readSegment.ReadSegmentImpl;
import services.segment.updateSegment.IUpdateSegment;
import services.segment.updateSegment.UpdateSegmentImpl;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        // Segment
        bind(IReadSegment.class).to(ReadSegmentImpl.class);
        bind(ICreateSegment.class).to(CreateSegmentImpl.class);
        bind(IUpdateSegment.class).to(UpdateSegmentImpl.class);
        bind(IDeleteSegment.class).to(DeleteSegmentImpl.class);
        // Curb
        bind(ICreateCurb.class).to(CreateCurbImpl.class);
        bind(IReadCurb.class).to(ReadCurbImpl.class);
        bind(IUpdateCurb.class).to(UpdateCurbImpl.class);
        bind(IDeleteCurb.class).to(DeleteCurbImpl.class);
        // Road
        bind(IReadRoad.class).to(ReadRoadImpl.class);
        bind(ICreateRoad.class).to(CreateRoadImpl.class);
        bind(IUpdateRoad.class).to(UpdateRoadImpl.class);
        bind(IDeleteRoad.class).to(DeleteRoadImpl.class);
    }
}
