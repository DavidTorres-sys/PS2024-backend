package persistence.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

/**
 * The SegmentDTO class is a Data Transfer Object for the Segment entity.
 * It is used to transfer segment data between different layers of the application.
 */
@Data
public class SegmentDTO {

    private Integer id;
    private Long segmentNumber;
    private String nomenclature;
    private Float length;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<RoadDTO> roads;
    private List<CurbDTO> curbs;

}
