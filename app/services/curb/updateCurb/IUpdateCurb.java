package services.curb.updateCurb;

import java.util.Optional;

import persistence.dto.CurbDTO;
import persistence.entities.Curb;

/**
 * Service interface for updating an existing {@link Curb} entity.
 * This interface defines the contract for updating curbs within the system.
 *
 */
public interface IUpdateCurb {

    /**
     * Updates an existing {@link Curb} entity identified by its unique ID.
     *
     * @param id the unique identifier of the curb to update
     * @param curb the new curb data to be applied
     * @return an {@link Optional} containing the updated curb, or empty if the curb was not found
     */
    Optional<Curb> update(Integer id, CurbDTO curb);
}
