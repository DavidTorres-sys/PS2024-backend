package services.curb.readCurb;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import persistence.dto.CurbDTO;
import persistence.entities.Curb;
import persistence.mapper.ICurbMapper;
import repositories.curb.ICurbRepository;

/**
 * Implementation of the {@link IReadCurb} interface for reading curb data.
 *
 * This class provides methods to retrieve {@link Curb} entities from the repository.
 * It handles the logic for fetching all curbs or a specific curb by its ID.
 */
public class ReadCurbImpl implements IReadCurb {

    private final ICurbRepository curbRepository;
    private final ICurbMapper curbMapper;

    /**
     * Constructs a new {@link ReadCurbImpl} with the provided curb repository.
     *
     * @param curbRepository the repository used to fetch curb data
     */
    @Inject
    public ReadCurbImpl(ICurbRepository curbRepository, ICurbMapper curbMapper) {
        this.curbRepository = curbRepository;
        this.curbMapper = curbMapper;
    }

    /**
     * Retrieves all {@link Curb} entities from the repository.
     *
     * This method calls the repository's {@link ICurbRepository#getAll()} method to
     * fetch all curbs. If no curbs are found, it returns an empty list.
     *
     * @return a list of all {@link Curb} entities, or an empty list if no curbs are found
     * @throws RuntimeException if an error occurs while fetching the curbs
     */
    @Override
    public List<CurbDTO> getAll() {
        try {
            List<Curb> curbs = curbRepository.getAll();
            List<CurbDTO> curbDTOs = new ArrayList<>();

            for (Curb curb : curbs) {
                CurbDTO curbDTO = curbMapper.curbToCurbDTO(curb);
                curbDTOs.add(curbDTO);
            }
            if (curbs.isEmpty()) {
                return Collections.emptyList();
            }
            return curbDTOs;
        } catch (Exception e) {
            throw new RuntimeException("Error getting all curbs: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves a {@link Curb} entity by its ID.
     *
     * This method calls the repository's {@link ICurbRepository#get(Integer)} method to
     * fetch the curb with the specified ID. If the curb is not found, it returns an empty {@link Optional}.
     *
     * @param id the ID of the curb to be retrieved
     * @return an {@link Optional} containing the {@link Curb} if found, or empty if not found
     */
    @Override
    public Optional<CurbDTO> get(Integer id) {
        try {
            Optional<Curb> curb = curbRepository.get(id);
            return curb.map(curbMapper::curbToCurbDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error getting curb with ID " + id + ": " + e.getMessage(), e);
        }
    }
}
