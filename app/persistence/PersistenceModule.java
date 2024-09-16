package persistence;

import com.google.inject.AbstractModule;
import persistence.mapper.ICurbMapper;
import persistence.mapper.IRoadMapper;
import persistence.mapper.ISegmentMapper;

/**
 * Module for the persistence layer.
 */
public class PersistenceModule extends AbstractModule {

    /**
     * Configures the module.
     */
    @Override
    protected void configure() {
        bind(ISegmentMapper.class).toInstance(ISegmentMapper.INSTANCE);
        bind(ICurbMapper.class).toInstance(ICurbMapper.INSTANCE);
        bind(IRoadMapper.class).toInstance(IRoadMapper.INSTANCE);
    }
}
