package services.segment.updateSegment;

import javax.inject.Inject;
import java.util.Optional;

import persistence.entities.Segment;
import repositories.segment.ISegmentRepository;

public class UpdateSegmentImpl implements IUpdateSegment {

    private final ISegmentRepository segmentRepository;

    @Inject
    public UpdateSegmentImpl(ISegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    /**
     * Updates the segment with the specified ID.
     *
     * @param id      the ID of the segment to update
     * @param segment the updated segment data
     * @return an optional containing the updated segment if it was found and updated, empty otherwise
     */
    @Override
    public Optional<Segment> update(Integer id, Segment segment) {
        try {
            return segmentRepository.update(id, segment);
        } catch (Exception e) {
            throw new RuntimeException("Error updating the segment: " + e.getMessage());
        }
    }
}
