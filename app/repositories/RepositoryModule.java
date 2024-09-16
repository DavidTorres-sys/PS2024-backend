package repositories;

import com.google.inject.AbstractModule;

import repositories.curb.CurbRepositoryImpl;
import repositories.curb.ICurbRepository;
import repositories.road.IRoadRepository;
import repositories.road.RoadRepositoryImpl;
import repositories.segment.ISegmentRepository;
import repositories.segment.SegmentRepositoryImpl;

/**
 * Guice module for binding repository interfaces to their concrete implementations.
 * This module is used to configure dependency injection for repository classes in the application.
 */
public class RepositoryModule extends AbstractModule {

    /**
     * Configures the bindings for repository interfaces to their respective implementations.
     * This method is automatically called during application startup when Guice is initialized.
     */
    @Override
    protected void configure() {
        bind(ISegmentRepository.class).to(SegmentRepositoryImpl.class);
        bind(IRoadRepository.class).to(RoadRepositoryImpl.class);
        bind(ICurbRepository.class).to(CurbRepositoryImpl.class);
    }
}
