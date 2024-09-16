package repositories.road;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import persistence.dto.RoadDTO;
import persistence.entities.Segment;
import play.db.jpa.JPAApi;

import persistence.entities.Road;

/**
 * Implementation of the {@link IRoadRepository} interface for managing {@link Road} entities.
 * This class uses JPA (Java Persistence API) for database operations and is managed via dependency injection.
 */
public class RoadRepositoryImpl implements IRoadRepository {

    private final JPAApi jpaApi;
    private static final Logger logger = LoggerFactory.getLogger(RoadRepositoryImpl.class);


    /**
     * Constructor for injecting the {@link JPAApi} dependency.
     *
     * @param jpaApi the JPA API used for handling transactions and entity management
     */
    @Inject
    public RoadRepositoryImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    /**
     * Retrieves all {@link Road} entities from the database.
     *
     * @return a list of all roads
     */
    @Override
    public List<Road> getAll() {
        return jpaApi.withTransaction(entityManager -> {
            return entityManager.createQuery("FROM Road", Road.class).getResultList();
        });
    }

    /**
     * Persists a new {@link Road} entity in the database.
     *
     * @param road the road entity to be created
     */
    @Override
    public void create(Road road) {
        jpaApi.withTransaction(entityManager -> {
            entityManager.persist(road);
        });
    }

    /**
     * Retrieves a {@link Road} entity by its ID.
     *
     * @param id the unique identifier of the road
     * @return an {@link Optional} containing the road, or empty if not found
     */
    @Override
    public Optional<Road> get(Integer id) {
        return jpaApi.withTransaction(entityManager -> {
            Road road = entityManager.find(Road.class, id);
            return Optional.ofNullable(road);
        });
    }

    /**
     * Updates an existing {@link Road} entity in the database.
     *
     * @param id the unique identifier of the road to update
     * @param roadDTO the new road data to be updated
     * @return an {@link Optional} containing the updated road, or empty if not found
     */
    @Override
    public Optional<Road> update(Integer id, RoadDTO roadDTO) {
        return jpaApi.withTransaction(entityManager -> {
            Road existingRoad = entityManager.find(Road.class, id);
            if (existingRoad != null) {
                existingRoad.setPavementType(roadDTO.getPavementType());
                existingRoad.setLength(roadDTO.getLength());
                existingRoad.getUpdatedAt().setTime(System.currentTimeMillis());
                Segment segment = entityManager.find(Segment.class, roadDTO.getSegmentId());
                if (segment == null) {
                    throw new IllegalArgumentException("Segment not found");
                }
                existingRoad.setSegment(segment);
                entityManager.persist(existingRoad);
                return Optional.of(existingRoad);
            } else {
                return Optional.empty();
            }
        });
    }

    /**
     * Deletes a {@link Road} entity by its ID.
     *
     * Note: This implementation incorrectly deletes a {@link Road}.
     * It should find and delete the correct entity type.
     *
     * @param id the unique identifier of the road to delete
     */
    @Override
    public void delete(Integer id) {
        jpaApi.withTransaction(entityManager -> {
            Road road = entityManager.find(Road.class, id);
            logger.info("Found Road entity with ID: {}. Proceeding with deletion.", id);
            if (road != null) {
                entityManager.remove(road);
                entityManager.flush();
            }
        });
    }
}
