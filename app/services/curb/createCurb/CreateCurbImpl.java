package services.curb.createCurb;

import javax.inject.Inject;

import persistence.dto.CurbDTO;
import persistence.entities.Curb;
import persistence.mapper.ICurbMapper;
import repositories.curb.ICurbRepository;

/**
 * Implementation of the {@link ICreateCurb} interface for creating curbs.
 *
 * This service is responsible for creating a new {@link Curb} entity in the repository.
 */
public class CreateCurbImpl implements ICreateCurb {

    private final ICurbRepository curbRepository;
    private final ICurbMapper curbMapper;

    /**
     * Constructs a new {@link CreateCurbImpl} with the provided curb repository.
     *
     * @param curbRepository the repository used to persist the curb
     * @param curbMapper     the mapper used to map the curb to a DTO
     */
    @Inject
    public CreateCurbImpl(ICurbRepository curbRepository, ICurbMapper curbMapper) {
        this.curbRepository = curbRepository;
        this.curbMapper = curbMapper;
    }

    /**
     * Creates a new {@link Curb} entity.
     *
     * @param curbDTO the curb entity to be created
     */
    @Override
    public void create(CurbDTO curbDTO) {
        try {
            Curb curb = curbMapper.curbDTOToCurb(curbDTO);
            curbRepository.create(curb);
        } catch (Exception e) {
            throw new RuntimeException("Error creating curb: " + e.getMessage());
        }
    }
}
