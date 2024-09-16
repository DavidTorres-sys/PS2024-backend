package services.segment.deleteSegment;

import javax.inject.Inject;

import persistence.entities.Segment;
import repositories.segment.ISegmentRepository;

/**
 * Implementation of the {@link IDeleteSegment} interface for deleting segments.
 *
 * This service is responsible for deleting a {@link Segment} entity from the repository.
 * It utilizes the {@link ISegmentRepository} to perform the deletion operation.
 */
public class DeleteSegmentImpl implements IDeleteSegment {

    private final ISegmentRepository segmentRepository;

    /**
     * Constructs a new {@link DeleteSegmentImpl} with the provided segment repository.
     *
     * @param segmentRepository the repository used to delete the segment
     */
    @Inject
    public DeleteSegmentImpl(ISegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    /**
     * Deletes a segment from the repository.
     *
     * @param id the ID of the segment to be deleted.
     * @throws RuntimeException if the segment does not exist or if any other error occurs during the deletion process.
     */
    @Override
    public void delete(Integer id) {
        try {
            segmentRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting segment: " + e.getMessage());
        }
    }
}
