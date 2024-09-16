package persistence.entities;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * The Curb class represents a curb element associated with a road segment.
 * It contains information about the material used for the curb and timestamps
 * for creation and last update.
 *
 * This entity is mapped to the "CURB" table in the database.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "curb")
public class Curb {

    /**
     * The unique identifier for the curb.
     * It is auto-generated by the database and serves as the primary key of the "CURB" table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * The segment associated with this curb.
     * This defines a many-to-one relationship where multiple curbs can belong to one road segment.
     * It is mapped to the "segment_id" column in the "CURB" table and references the "id" column in the "Segment" table.
     */
    @ManyToOne
    @JoinColumn(name = "segment_id", referencedColumnName = "id")
    @JsonBackReference
    private Segment segment;

    /**
     * The material used for the curb.
     * It is stored as an integer in the "material" column of the "CURB" table, which may correspond to a material type ID.
     */
    @NonNull
    @Column(name = "material", nullable = false)
    private String material;

    /**
     * The length of the curb in meters.
     * It is stored as an integer in the "length" column of the "CURB" table.
     */
    @NonNull
    @Column(name = "length", nullable = false)
    private Integer length;

    /**
     * The timestamp indicating when the curb was created.
     * It is stored in the "created_at" column in the "CURB" table.
     */
    @NonNull
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    /**
     * The timestamp indicating when the curb was last updated.
     * It is stored in the "updated_at" column in the "CURB" table.
     */
    @NonNull
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

}