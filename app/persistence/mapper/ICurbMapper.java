package persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import persistence.dto.CurbDTO;
import persistence.entities.Curb;

/**
 * Mapper interface for converting between {@link Curb} entity and {@link CurbDTO} Data Transfer Object.
 */
@Mapper
public interface ICurbMapper {

    /**
     * Singleton instance of the {@link ICurbMapper} for easy access.
     */
    ICurbMapper INSTANCE = Mappers.getMapper(ICurbMapper.class);

    /**
     * Converts a {@link Curb} entity to a {@link CurbDTO}.
     *
     * @param curb the {@link Curb} entity to convert
     * @return the corresponding {@link CurbDTO}
     */
    @Mapping(source = "segment.id", target = "segmentId")
    CurbDTO curbToCurbDTO(Curb curb);

    /**
     * Converts a {@link CurbDTO} to a {@link Curb} entity.
     *
     * @param curbDTO the {@link CurbDTO} to convert
     * @return the corresponding {@link Curb} entity
     */
    @Mapping(source = "segmentId", target = "segment.id")
    Curb curbDTOToCurb(CurbDTO curbDTO);

}
