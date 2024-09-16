package services.segment.deleteSegment;

/**
 * Interface defining the contract for deleting segments in the system.
 * Implementations of this interface handle the business logic required to
 * delete segments from the repository.
 */
public interface IDeleteSegment {

    /**
     * Deletes a segment from the repository.
     *
     * @param id the ID of the segment to be deleted.
     * @throws RuntimeException if the segment does not exist or if any other error occurs during the deletion process.
     */
    void delete(Integer id);

}
