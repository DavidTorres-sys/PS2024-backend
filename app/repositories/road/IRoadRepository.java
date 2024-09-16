package repositories.road;

import java.util.List;
import java.util.Optional;

import persistence.dto.RoadDTO;
import persistence.entities.Road;

/**
 * Interface for managing persistence and retrieval operations related to the {@link Road} entity.
 * This repository follows an asynchronous pattern using CompletionStage for non-blocking operations.
 */
public interface IRoadRepository {

    /**
     * Retrieves all {@link Road} entities.
     *
     * @return a list of all roads in the system
     */
    List<Road> getAll();

    /**
     * Persists a new {@link Road} entity in the system.
     *
     * @param road the road entity to be created
     */
    void create(Road road);

    /**
     * Retrieves a {@link Road} entity by its unique ID.
     *
     * @param id the unique identifier of the road to retrieve
     * @return an {@link Optional} containing the found road, or empty if no road was found
     */
    Optional<Road> get(Integer id);

    /**
     * Updates an existing {@link Road} entity by its ID.
     *
     * @param id the unique identifier of the road to update
     * @param roadDTO the new road data to replace the existing one
     * @return an {@link Optional} containing the updated road, or empty if no road was found with the provided ID
     */
    Optional<Road> update(Integer id, RoadDTO roadDTO);

    /**
     * Deletes a {@link Road} entity by its unique ID.
     *
     * @param id the unique identifier of the road to delete
     */
    void delete(Integer id);

}
