package persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import persistence.dto.SegmentDTO;
import persistence.entities.Segment;

/**
 * Mapper interface for converting between {@link Segment} entity and {@link SegmentDTO} Data Transfer Object.
 */
@Mapper(uses = {ICurbMapper.class, IRoadMapper.class})
public interface ISegmentMapper {

    /**
     * Singleton instance of the {@link ISegmentMapper} for easy access.
     */
    ISegmentMapper INSTANCE = Mappers.getMapper(ISegmentMapper.class);

    /**
     * Converts a {@link Segment} entity to a {@link SegmentDTO}.
     *
     * @param segment the {@link Segment} entity to convert
     * @return the corresponding {@link SegmentDTO}
     */
    @Mapping(source = "road", target = "roads")
    @Mapping(source = "curb", target = "curbs")
    SegmentDTO segmentToSegmentDTO(Segment segment);

    /**
     * Converts a {@link SegmentDTO} to a {@link Segment} entity.
     *
     * @param segmentDTO the {@link SegmentDTO} to convert
     * @return the corresponding {@link Segment} entity
     */
    @Mapping(source = "roads", target = "road")
    @Mapping(source = "curbs", target = "curb")
    Segment segmentDTOToSegment(SegmentDTO segmentDTO);


}
