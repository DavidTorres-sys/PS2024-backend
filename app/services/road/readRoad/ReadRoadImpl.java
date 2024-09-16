package services.road.readRoad;

import persistence.dto.RoadDTO;
import persistence.dto.SegmentDTO;
import persistence.entities.Road;
import persistence.mapper.IRoadMapper;
import repositories.road.IRoadRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReadRoadImpl implements IReadRoad {

    private final IRoadRepository roadRepository;
    private final IRoadMapper roadMapper;

    @Inject
    public ReadRoadImpl(IRoadRepository roadRepository, IRoadMapper roadMapper) {
        this.roadRepository = roadRepository;
        this.roadMapper = roadMapper;
    }

    /**
     * Retrieves all {@link Road} entities from the repository.
     *
     * @return a list of all {@link Road} entities
     */
    @Override
    public List<RoadDTO> getAll() {
        try {
            List<Road> roads = roadRepository.getAll();
            List<RoadDTO> roadsDTOs = new ArrayList<>();

            for(Road road : roads) {
                RoadDTO roadDTO = roadMapper.roadToRoadDTO(road);
                roadsDTOs.add(roadDTO);
            }
            if (roads.isEmpty()) {
                return Collections.emptyList();
            }
            return roadsDTOs;
        } catch (Exception e) {
            throw new RuntimeException("Error getting all roads: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves a {@link Road} entity by its ID.
     *
     * This method looks up the road with the specified ID and returns it wrapped in an {@link Optional}.
     *
     * @param id the ID of the road to be retrieved
     * @return an {@link Optional} containing the {@link Road} if found, or empty if not found
     */
    @Override
    public Optional<RoadDTO> get(Integer id) {
        try {
            Optional<Road> road = roadRepository.get(id);
            return road.map(roadMapper::roadToRoadDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error getting road with ID " + id + ": " + e.getMessage(), e);
        }
    }
}
