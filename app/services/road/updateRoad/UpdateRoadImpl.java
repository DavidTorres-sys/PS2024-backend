package services.road.updateRoad;

import javax.inject.Inject;
import java.util.Optional;

import persistence.dto.RoadDTO;
import persistence.entities.Road;
import repositories.road.IRoadRepository;

public class UpdateRoadImpl implements IUpdateRoad {

    private final IRoadRepository roadRepository;

    @Inject
    public UpdateRoadImpl(IRoadRepository roadRepository) {
        this.roadRepository = roadRepository;
    }

    /**
     * Updates the road with the specified ID.
     *
     * @param id   the ID of the road to update
     * @param road the updated road data
     * @return an optional containing the updated road if it was found and updated, empty otherwise
     */
    @Override
    public Optional<Road> update(Integer id, RoadDTO roadDTO) {
        try {
            return roadRepository.update(id, roadDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error updating the road: " + e.getMessage());
        }
    }
}
