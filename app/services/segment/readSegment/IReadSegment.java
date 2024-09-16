package services.segment.readSegment;

import java.util.List;
import java.util.Optional;

import persistence.dto.SegmentDTO;

/**
 * Interface for segment reading operations.
 *
 * This interface defines methods for retrieving {@link SegmentDTO} entities from the repository.
 * It provides functionality to fetch all segments or a specific segment by its ID.
 */
public interface IReadSegment {

    /**
     * Retrieves all {@link SegmentDTO} entities from the repository.
     *
     * @return a list of all {@link SegmentDTO} entities
     */
    List<SegmentDTO> getAll();

    /**
     * Retrieves a {@link SegmentDTO} entity by its ID.
     *
     * This method looks up the segment with the specified ID and returns it wrapped in an {@link Optional}.
     *
     * @param id the ID of the segment to be retrieved
     * @return an {@link Optional} containing the {@link SegmentDTO} if found, or empty if not found
     */
    Optional<SegmentDTO> get(Integer id);

}
