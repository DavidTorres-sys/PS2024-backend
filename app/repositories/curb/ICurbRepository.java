package repositories.curb;

import java.util.List;
import java.util.Optional;

import persistence.dto.CurbDTO;
import persistence.entities.Curb;

/**
 * Interface for managing persistence and retrieval operations related to the {@link Curb} entity.
 * This repository follows an asynchronous pattern using CompletionStage for non-blocking operations.
 */
public interface ICurbRepository {

    /**
     * Retrieves all {@link Curb} entities.
     *
     * @return a list of all curbs in the system
     */
    List<Curb> getAll();

    /**
     * Persists a new {@link Curb} entity in the system.
     *
     * @param curb the curb entity to be created
     */
    void create(Curb curb);

    /**
     * Retrieves a {@link Curb} entity by its unique ID.
     *
     * @param id the unique identifier of the curb to retrieve
     * @return an {@link Optional} containing the found curb, or empty if no curb was found
     */
    Optional<Curb> get(Integer id);

    /**
     * Updates an existing {@link Curb} entity by its ID.
     *
     * @param id the unique identifier of the curb to update
     * @param curbDTO the new curb data to replace the existing one
     * @return an {@link Optional} containing the updated curb, or empty if no curb was found with the provided ID
     */
    Optional<Curb> update(Integer id, CurbDTO curbDTO);

    /**
     * Deletes a {@link Curb} entity by its unique ID.
     *
     * @param id the unique identifier of the curb to delete
     */
    void delete(Integer id);

}
