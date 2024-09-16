package services.curb.deleteCurb;

/**
 * Interface defining the contract for deleting curbs in the system.
 * Implementations of this interface handle the business logic required to
 * delete curbs from the repository.
 */
public interface IDeleteCurb {

    /**
     * Deletes a curb from the repository.
     *
     * @param id the ID of the curb to be deleted.
     * @throws RuntimeException if the curb does not exist or if any other error occurs during the deletion process.
     */
    void delete(Integer id);
}
