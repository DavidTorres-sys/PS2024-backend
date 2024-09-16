package services.curb.deleteCurb;

import javax.inject.Inject;

import persistence.entities.Curb;
import repositories.curb.ICurbRepository;

/**
 * Implementation of the {@link IDeleteCurb} interface for deleting curbs.
 *
 * This service is responsible for deleting a {@link Curb} entity from the repository.
 * It utilizes the {@link ICurbRepository} to perform the deletion operation.
 */
public class DeleteCurbImpl implements IDeleteCurb {

    private final ICurbRepository curbRepository;

    @Inject
    public DeleteCurbImpl(ICurbRepository curbRepository) {
        this.curbRepository = curbRepository;
    }

    /**
     * Deletes a curb from the repository.
     *
     * @param id the ID of the curb to be deleted.
     * @throws RuntimeException if the curb does not exist or if any other error occurs during the deletion process.
     */
    @Override
    public void delete(Integer id) {
        try {
            curbRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting curb: " + e.getMessage());
        }
    }
}
