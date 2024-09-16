package services.road.createRoad;

import persistence.dto.RoadDTO;

/**
 * Interface defining the contract for creating roads in the system.
 * Implementations of this interface handle the business logic required to
 * create and persist new roads to the database.
 */
public interface ICreateRoad {

    /**
     * Creates a new road and saves it to the repository.
     *
     * @param road the Road object to be created and persisted. The object
     *             should contain all necessary information, including an ID
     *             that is unique and not already present in the repository.
     * @throws RuntimeException if a road with the same ID already exists or
     *                          if any other error occurs during the creation process.
     */
    void create(RoadDTO road);
}
