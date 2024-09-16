package services.curb.readCurb;

import java.util.List;
import java.util.Optional;

import persistence.dto.CurbDTO;
import persistence.entities.Curb;

/**
 * Interface for curb reading operations.
 *
 * This interface defines methods for retrieving {@link Curb} entities from the repository.
 * It provides functionality to fetch all curbs or a specific curb by its ID.
 */
public interface IReadCurb {

    /**
     * Retrieves all {@link Curb} entities from the repository.
     *
     * @return a list of all {@link Curb} entities
     */
    List<CurbDTO> getAll();

    /**
     * Retrieves a {@link Curb} entity by its ID.
     *
     * This method looks up the curb with the specified ID and returns it wrapped in an {@link Optional}.
     *
     * @param id the ID of the curb to be retrieved
     * @return an {@link Optional} containing the {@link Curb} if found, or empty if not found
     */
    Optional<CurbDTO> get(Integer id);

}
