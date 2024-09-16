package services.segment.readSegment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import persistence.dto.SegmentDTO;
import persistence.entities.Segment;
import persistence.mapper.ISegmentMapper;
import repositories.segment.ISegmentRepository;

/**
 * Implementation of the {@link IReadSegment} interface for reading segment data.
 *
 * This class provides methods to retrieve {@link Segment} entities from the repository.
 * It handles the logic for fetching all segments or a specific segment by its ID.
 */
public class ReadSegmentImpl implements IReadSegment {

    private final ISegmentRepository segmentRepository;
    private final ISegmentMapper segmentMapper;

    /**
     * Constructs a new {@link ReadSegmentImpl} with the provided segment repository.
     *
     * @param segmentRepository the repository used to fetch segment data
     * @param segmentMapper     the mapper used to map the segment to a DTO
     */
    @Inject
    public ReadSegmentImpl(ISegmentRepository segmentRepository, ISegmentMapper segmentMapper) {
        this.segmentRepository = segmentRepository;
        this.segmentMapper = segmentMapper;
    }

    /**
     * Retrieves all {@link SegmentDTO} entities from the repository.
     *
     * This method calls the repository's {@link ISegmentRepository#getAll()} method to
     * fetch all segments. If no segments are found, it returns an empty list.
     *
     * @return a list of all {@link Segment} entities, or an empty list if no segments are found
     * @throws RuntimeException if an error occurs while fetching the segments
     */
    @Override
    public List<SegmentDTO> getAll() {
        try {
            List<Segment> segments = segmentRepository.getAll();
            List<SegmentDTO> segmentDTOs = new ArrayList<>();
            for (Segment segment : segments) {
                SegmentDTO segmentDTO = segmentMapper.segmentToSegmentDTO(segment);
                segmentDTOs.add(segmentDTO);
            }
            if (segments.isEmpty()) {
                return Collections.emptyList();
            }
            return segmentDTOs;
        } catch (Exception e) {
            throw new RuntimeException("Error getting all segments: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves a {@link SegmentDTO} entity by its ID.
     *
     * This method calls the repository's {@link ISegmentRepository#get(Integer)} method to
     * fetch the segment with the specified ID. If the segment is not found, it returns an empty {@link Optional}.
     *
     * @param id the ID of the segment to be retrieved
     * @return an {@link Optional} containing the {@link Segment} if found, or empty if not found
     * @throws RuntimeException if an error occurs while fetching the segment
     */
    @Override
    public Optional<SegmentDTO> get(Integer id) {
        try {
            Optional<Segment> segment = segmentRepository.get(id);
            return segment.map(segmentMapper::segmentToSegmentDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error getting segment by id: " + e.getMessage(), e);
        }
    }
}
