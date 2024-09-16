package persistence.dto;

import java.sql.Timestamp;

import lombok.Data;


/**
 * The CurbDTO class is a Data Transfer Object for the Curb entity.
 * It is used to transfer curb data between different layers of the application.
 */
@Data
public class CurbDTO {

    private Integer id;
    private Integer segmentId;
    private String material;
    private Integer length;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}