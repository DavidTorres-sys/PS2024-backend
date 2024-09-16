package persistence.dto;

import java.sql.Timestamp;

import lombok.Data;


/**
 * The RoadDTO class is a Data Transfer Object for the Road entity.
 * It is used to transfer road data between different layers of the application.
 */
@Data
public class RoadDTO {

    private Integer id;
    private Integer segmentId;
    private String pavementType;
    private Float length;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}