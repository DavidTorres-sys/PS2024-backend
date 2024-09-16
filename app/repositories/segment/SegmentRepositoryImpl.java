package repositories.segment;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import play.db.jpa.JPAApi;

import persistence.entities.Segment;

/**
 * Implementation of the {@link ISegmentRepository} interface for managing {@link Segment} entities.
 *
 * This repository provides methods to perform CRUD operations on {@link Segment} entities using JPA.
 * It utilizes the {@link JPAApi} to interact with the database within transactions.
 */
public class SegmentRepositoryImpl implements ISegmentRepository {

    private final JPAApi jpaApi;

    /**
     * Constructs a new {@link SegmentRepositoryImpl} with the provided JPA API.
     *
     * @param jpaApi the JPA API used to manage transactions and entity operations
     */
    @Inject
    public SegmentRepositoryImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    /**
     * Retrieves all {@link Segment} entities from the database.
     *
     * This method executes a JPQL query to fetch all segments.
     *
     * @return a list of all {@link Segment} entities
     */
    @Override
    public List<Segment> getAll() {
        return jpaApi.withTransaction(entityManager -> {
            return entityManager.createQuery("FROM Segment", Segment.class).getResultList();
        });
    }

    /**
     * Creates a new {@link Segment} entity in the database.
     *
     * This method persists the provided segment within a transaction.
     *
     * @param segment the {@link Segment} entity to be created
     */
    @Override
    public void create(Segment segment) {
        jpaApi.withTransaction(entityManager -> {
            entityManager.persist(segment);
        });
    }

    /**
     * Retrieves a {@link Segment} entity by its ID.
     *
     * This method looks up the segment with the specified ID and returns it wrapped in an {@link Optional}.
     *
     * @param id the ID of the segment to be retrieved
     * @return an {@link Optional} containing the {@link Segment} if found, or empty if not found
     */
    @Override
    public Optional<Segment> get(Integer id) {
        return jpaApi.withTransaction(entityManager -> {
            Segment segment = entityManager.find(Segment.class, id);
            return Optional.ofNullable(segment);
        });
    }

    /**
     * Updates an existing {@link Segment} entity in the database.
     *
     * This method finds the segment by its ID and updates its fields with the provided segment data.
     * The updated segment is then persisted within a transaction.
     *
     * @param id the ID of the segment to be updated
     * @param segment the {@link Segment} entity containing the new data
     * @return an {@link Optional} containing the updated {@link Segment} if the update was successful, or empty if the segment was not found
     */
    @Override
    public Optional<Segment> update(Integer id, Segment segment) {
        return jpaApi.withTransaction(entityManager -> {
            Segment existingSegment = entityManager.find(Segment.class, id);
            if (existingSegment != null) {
                existingSegment.setNomenclature(segment.getNomenclature());
                existingSegment.getUpdatedAt().setTime(System.currentTimeMillis());
                existingSegment.setSegmentNumber(segment.getSegmentNumber());
                existingSegment.setLength(segment.getLength());
                entityManager.persist(existingSegment);
                return Optional.of(existingSegment);
            } else {
                return Optional.empty();
            }
        });
    }

    /**
     * Deletes a {@link Segment} entity from the database.
     *
     * This method finds the segment by its ID and removes it from the database. If the segment is not found,
     * it does nothing.
     *
     * @param id the ID of the segment to be deleted
     */
    @Override
    public void delete(Integer id) {
        jpaApi.withTransaction(entityManager -> {
            Segment segment = entityManager.find(Segment.class, id);
            if (segment != null) {
                entityManager.remove(segment);
            }
        });
    }
}
