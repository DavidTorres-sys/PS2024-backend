package services.segment.createSegment;

import persistence.dto.SegmentDTO;

/**
 * Interface defining the contract for creating segments in the system.
 * Implementations of this interface handle the business logic required to
 * create and persist new segments to the database.
 */
public interface ICreateSegment {

    /**
     * Creates a new segment and saves it to the repository.
     *
     * @param segmentDTO the Segment object to be created and persisted. The object
     *                should contain all necessary information, including an ID
     *                that is unique and not already present in the repository.
     * @throws RuntimeException if a segment with the same ID already exists or
     *                          if any other error occurs during the creation process.
     */
    void create(SegmentDTO segmentDTO);

}
