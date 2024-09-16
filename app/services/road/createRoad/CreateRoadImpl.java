package services.road.createRoad;

import persistence.dto.RoadDTO;
import persistence.entities.Road;
import persistence.mapper.IRoadMapper;
import repositories.road.IRoadRepository;

import javax.inject.Inject;

public class CreateRoadImpl implements ICreateRoad {

    private final IRoadRepository roadRepository;
    private final IRoadMapper roadMapper;

    @Inject
    public CreateRoadImpl(IRoadRepository roadRepository, IRoadMapper roadMapper) {
        this.roadRepository = roadRepository;
        this.roadMapper = roadMapper;
    }
    /**
     * Creates a new road and saves it to the repository.
     *
     * @param roadDTO the Road object to be created and persisted. The object
     *             should contain all necessary information, including an ID
     *             that is unique and not already present in the repository.
     * @throws RuntimeException if a road with the same ID already exists or
     *                          if any other error occurs during the creation process.
     */
    @Override
    public void create(RoadDTO roadDTO) {
        try {
            Road road = roadMapper.roadDTOToRoad(roadDTO);
            roadRepository.create(road);
        } catch (Exception e) {
            throw new RuntimeException("Error creating road: " + e.getMessage());
        }
    }
}
