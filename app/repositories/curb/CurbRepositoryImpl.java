package repositories.curb;

import persistence.dto.CurbDTO;
import persistence.entities.Segment;
import play.db.jpa.JPAApi;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import persistence.entities.Curb;

/**
 * Implementation of the {@link ICurbRepository} interface for managing {@link Curb} entities.
 * This class handles the CRUD operations for curbs in the system, utilizing JPA for persistence.
 */
public class CurbRepositoryImpl implements ICurbRepository {

    private final JPAApi jpaApi;

    /**
     * Constructor to inject the {@link JPAApi} dependency for database operations.
     *
     * @param jpaApi the JPA API used to handle transactions and entity management
     */
    @Inject
    public CurbRepositoryImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }


    /**
     * Retrieves all {@link Curb} entities from the database.
     *
     * @return a list of all curbs in the system
     */
    @Override
    public List<Curb> getAll() {
        return jpaApi.withTransaction(entityManager -> {
            return entityManager.createQuery("FROM Curb", Curb.class).getResultList();
        });
    }

    /**
     * Persists a new {@link Curb} entity in the database.
     *
     * @param curb the curb entity to be created
     */
    @Override
    public void create(Curb curb) {
        jpaApi.withTransaction(entityManager -> {
            entityManager.persist(curb);
        });
    }

    /**
     * Retrieves a {@link Curb} entity by its ID.
     *
     * @param id the unique identifier of the curb to retrieve
     * @return an {@link Optional} containing the curb, or empty if not found
     */
    @Override
    public Optional<Curb> get(Integer id) {
        return jpaApi.withTransaction(entityManager -> {
            Curb curb = entityManager.find(Curb.class, id);
            return Optional.ofNullable(curb);
        });
    }

    /**
     * Updates an existing {@link Curb} entity in the database.
     *
     * @param id the unique identifier of the curb to update
     * @param curb the new curb data to replace the existing one
     * @return an {@link Optional} containing the updated curb, or empty if not found
     */
    @Override
    public Optional<Curb> update(Integer id, CurbDTO curb) {
        return jpaApi.withTransaction(entityManager -> {
            Curb existingCurb = entityManager.find(Curb.class, id);
            if (existingCurb != null) {
                existingCurb.setMaterial(curb.getMaterial());
                existingCurb.setLength(curb.getLength());
                existingCurb.getUpdatedAt().setTime(System.currentTimeMillis());
                Segment segment = entityManager.find(Segment.class, curb.getSegmentId());
                if (segment == null) {
                    throw new IllegalArgumentException("Segment not found");
                }
                existingCurb.setSegment(segment);
                entityManager.persist(existingCurb);
                return Optional.of(existingCurb);
            } else {
                return Optional.empty();
            }
        });
    }

    /**
     * Deletes a {@link Curb} entity by its ID.
     *
     * @param id the unique identifier of the curb to delete
     */
    @Override
    public void delete(Integer id) {
        jpaApi.withTransaction(entityManager -> {
            Curb curb = entityManager.find(Curb.class, id);
            if (curb != null) {
                entityManager.remove(curb);
            }
        });
    }
}
