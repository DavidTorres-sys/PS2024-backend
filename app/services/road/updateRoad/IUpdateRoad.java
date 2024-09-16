package services.road.updateRoad;

import java.util.Optional;

import persistence.dto.RoadDTO;
import persistence.entities.Road;

/**
 * Service interface for updating an existing {@link Road} entity.
 * This interface defines the contract for updating roads within the system.
 *
 */
public interface IUpdateRoad {

    /**
     * Updates an existing {@link Road} entity identified by its unique ID.
     *
     * @param id the unique identifier of the road to update
     * @param roadDTO the new road data to be applied
     * @return an {@link Optional} containing the updated road, or empty if the road was not found
     */
    Optional<Road> update(Integer id, RoadDTO roadDTO);
}
