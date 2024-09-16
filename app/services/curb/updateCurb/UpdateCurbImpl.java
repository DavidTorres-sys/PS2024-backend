package services.curb.updateCurb;

import persistence.dto.CurbDTO;
import persistence.entities.Curb;
import repositories.curb.ICurbRepository;

import javax.inject.Inject;
import java.util.Optional;

public class UpdateCurbImpl implements IUpdateCurb {

    private final ICurbRepository curbRepository;

    /**
     * Creates a new {@link UpdateCurbImpl} instance.
     *
     * @param curbRepository the repository to be used for curb management
     */
    @Inject
    public UpdateCurbImpl(ICurbRepository curbRepository) {
        this.curbRepository = curbRepository;
    }

    /**
     * Updates an existing {@link Curb} entity identified by its unique ID.
     *
     * @param id   the unique identifier of the curb to update
     * @param curb the new curb data to be applied
     * @return an {@link Optional} containing the updated curb, or empty if the curb was not found
     */
    @Override
    public Optional<Curb> update(Integer id, CurbDTO curbDTO) {
        try {
            return curbRepository.update(id, curbDTO);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
