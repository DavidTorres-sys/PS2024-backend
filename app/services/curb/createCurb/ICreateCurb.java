package services.curb.createCurb;

import persistence.dto.CurbDTO;
import persistence.entities.Curb;

/**
 * Service interface for creating a new {@link Curb} entity.
 * This interface defines the contract for creating curbs within the system.
 *
 * <p>Implementations of this interface should handle the business logic related to the creation of curbs.</p>
 */
public interface ICreateCurb {

    /**
     * Creates a new {@link CurbDTO} entity.
     *
     * @param curb the curb entity to be created
     */
    void create(CurbDTO curb);
}
