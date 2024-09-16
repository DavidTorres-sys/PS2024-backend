package services.road.deleteRoad;

/**
 * Interface defining the contract for deleting roads in the system.
 * Implementations of this interface handle the business logic required to
 * delete roads from the repository.
 */
public interface IDeleteRoad {

    /**
     * Deletes a road from the repository.
     *
     * @param id the ID of the road to be deleted.
     * @throws RuntimeException if the road does not exist or if any other error occurs during the deletion process.
     */
    void delete(Integer id);
}
