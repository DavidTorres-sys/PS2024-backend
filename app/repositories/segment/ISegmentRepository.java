package repositories.segment;

import java.util.List;
import java.util.Optional;

import persistence.dto.SegmentDTO;
import persistence.entities.Segment;

/**
 * Interface for managing persistence and retrieval operations related to the {@link Segment} entity.
 * This repository follows an asynchronous pattern using CompletionStage for non-blocking operations.
 */
public interface ISegmentRepository {

    /**
     * Retrieves a list of all Segments from the database.
     *
     * @return A List containing a  {@link Segment} objects representing all segments.
     *         The stream can be processed asynchronously when the stage completes.
     */
    List<Segment> getAll();

    /**
     * Creates a new Segment record in the database.
     *
     * @param segment The {@link Segment} object to be created.
     */
    void create(Segment segment);

    /**
     * Retrieves a specific Segment by its ID.
     *
     * @param id The ID of the segment to be retrieved.
     * @return A Optional object of {@link Segment}.
     *         If the segment exists, it will be present in the Optional, otherwise the Optional will be empty.
     */
    Optional<Segment> get(Integer id);

    /**
     * Updates an existing Segment record in the database.
     *
     * @param id The ID of the segment to be updated.
     * @param segment The updated {@link Segment} object.
     * @return A Optional object of {@link Segment}.
     *         The Optional will contain the updated segment if the update was successful, or be empty if the segment was not found.
     */
    Optional<Segment> update(Integer id, Segment segment);

    /**
     * Deletes a Segment record from the database.
     *
     * @param id The ID of the segment to be deleted.
     */
    void delete(Integer id);

}
