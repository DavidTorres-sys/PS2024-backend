package services.segment.updateSegment;

import java.util.Optional;

import persistence.entities.Segment;

/**
 * Interface for updating an existing segment.
 *
 * This interface defines the contract for a service that updates an existing {@link Segment} entity
 * in the system. Implementations of this interface should provide the logic to update the segment
 * and its associated entities (such as roads and curbs).
 */
public interface IUpdateSegment {

    /**
     * Updates an existing segment with new data.
     *
     * This method updates the segment identified by the given ID with the data provided in the
     * {@link Segment}. It returns an {@link Optional} containing the updated {@link Segment}
     * if the update was successful, or an empty {@link Optional} if the segment with the specified
     * ID was not found.
     *
     * @param id          the ID of the segment to be updated
     * @param segmentDTO  the {@link Segment} containing the new data for the segment
     * @return an {@link Optional} containing the updated {@link Segment} if the update was successful,
     *         or an empty {@link Optional} if the segment was not found
     */
    Optional<Segment> update(Integer id, Segment segmentDTO);
}
