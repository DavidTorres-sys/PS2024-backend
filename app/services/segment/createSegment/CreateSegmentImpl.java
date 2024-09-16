package services.segment.createSegment;

import javax.inject.Inject;

import persistence.dto.SegmentDTO;
import persistence.entities.Curb;
import persistence.entities.Road;
import persistence.entities.Segment;
import persistence.mapper.ISegmentMapper;
import repositories.segment.ISegmentRepository;

/**
 * Implementation of the {@link ICreateSegment} interface for creating segments.
 *
 * This service is responsible for creating a new {@link Segment} entity in the repository.
 * It ensures that all associated {@link Curb} and {@link Road} entities are correctly linked
 * to the segment before persisting it to the database.
 */
public class CreateSegmentImpl implements ICreateSegment {

    private final ISegmentRepository segmentRepository;
    private final ISegmentMapper segmentMapper;

    /**
     * Constructs a new {@link CreateSegmentImpl} with the provided segment repository.
     *
     * @param segmentRepository the repository used to persist the segment
     * @param segmentMapper     the mapper used to map the segment to a DTO
     *
     */
    @Inject
    public CreateSegmentImpl(ISegmentRepository segmentRepository, ISegmentMapper segmentMapper) {
        this.segmentRepository = segmentRepository;
        this.segmentMapper = segmentMapper;
    }

    /**
     * Creates a new {@link Segment} and its associated {@link Curb} and {@link Road} entities.
     *
     * This method sets the segment reference on each associated curb and road before
     * calling the repository to persist the segment. If any error occurs during this
     * process, it wraps the exception in a {@link RuntimeException} with an error message.
     *
     * @param segmentDTO the {@link SegmentDTO} containing the segment data.
     * @throws RuntimeException if an error occurs while creating the segment
     */
    @Override
    public void create(SegmentDTO segmentDTO) {
        try {
            Segment segment = segmentMapper.segmentDTOToSegment(segmentDTO);
            segment.getCurb().forEach(curb -> curb.setSegment(segment));
            segment.getRoad().forEach(road -> road.setSegment(segment));
            segmentRepository.create(segment);
        } catch (Exception e) {
            throw new RuntimeException("Error creating segment: " + e.getMessage());
        }
    }
}
