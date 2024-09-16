package persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import persistence.dto.RoadDTO;
import persistence.entities.Road;

/**
 * Mapper interface for converting between {@link Road} entity and {@link RoadDTO} Data Transfer Object.
 */
@Mapper
public interface IRoadMapper {

    /**
     * Singleton instance of the {@link IRoadMapper} for easy access.
     */
    IRoadMapper INSTANCE = Mappers.getMapper(IRoadMapper.class);

    /**
     * Converts a {@link Road} entity to a {@link RoadDTO}.
     *
     * @param road the {@link Road} entity to convert
     * @return the corresponding {@link RoadDTO}
     */
    @Mapping(source = "segment.id", target = "segmentId")
    RoadDTO roadToRoadDTO(Road road);

    /**
     * Converts a {@link RoadDTO} to a {@link Road} entity.
     *
     * @param roadDTO the {@link RoadDTO} to convert
     * @return the corresponding {@link Road} entity
     */
    @Mapping(source = "segmentId", target = "segment.id")
    Road roadDTOToRoad(RoadDTO roadDTO);

}
