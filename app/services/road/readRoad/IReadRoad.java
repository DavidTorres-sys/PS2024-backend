package services.road.readRoad;

import java.util.List;
import java.util.Optional;

import persistence.dto.RoadDTO;
import persistence.entities.Road;

/**
 * Interface for road reading operations.
 *
 * This interface defines methods for retrieving {@link Road} entities from the repository.
 * It provides functionality to fetch all roads or a specific road by its ID.
 */
public interface IReadRoad {

    /**
     * Retrieves all {@link Road} entities from the repository.
     *
     * @return a list of all {@link Road} entities
     */
    List<RoadDTO> getAll();

    /**
     * Retrieves a {@link Road} entity by its ID.
     *
     * This method looks up the road with the specified ID and returns it wrapped in an {@link Optional}.
     *
     * @param id the ID of the road to be retrieved
     * @return an {@link Optional} containing the {@link Road} if found, or empty if not found
     */
    Optional<RoadDTO> get(Integer id);
}
