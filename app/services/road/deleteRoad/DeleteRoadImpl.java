package services.road.deleteRoad;

import javax.inject.Inject;

import jakarta.transaction.Transactional;
import persistence.entities.Road;
import repositories.road.IRoadRepository;

/**
 * Implementation of the {@link IDeleteRoad} interface for deleting roads.
 *
 * This service is responsible for deleting a {@link Road} entity from the repository.
 * It utilizes the {@link IRoadRepository} to perform the deletion operation.
 */
public class DeleteRoadImpl implements IDeleteRoad {

    private final IRoadRepository roadRepository;

    /**
     * Constructs a new {@link DeleteRoadImpl} with the provided road repository.
     *
     * @param roadRepository the repository used to delete the road
     */
    @Inject
    public DeleteRoadImpl(IRoadRepository roadRepository) {
        this.roadRepository = roadRepository;
    }

    /**
     * Deletes a road from the repository.
     *
     * @param id the ID of the road to be deleted.
     * @throws RuntimeException if the road does not exist or if any other error occurs during the deletion process.
     */
    @Override
    public void delete(Integer id) {
        try {
            roadRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting road: " + e.getMessage());
        }
    }
}
