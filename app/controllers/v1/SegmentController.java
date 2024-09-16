package controllers.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import persistence.dto.SegmentDTO;
import persistence.entities.Segment;
import services.segment.createSegment.ICreateSegment;
import services.segment.deleteSegment.IDeleteSegment;
import services.segment.readSegment.IReadSegment;
import services.segment.updateSegment.IUpdateSegment;

/**
 * Controller for handling CRUD operations on segments.
 */
public class SegmentController extends Controller {

    private final IReadSegment readSegment;
    private final ICreateSegment createSegment;
    private final IDeleteSegment deleteSegment;
    private final IUpdateSegment updateSegment;

    @Inject
    public SegmentController(
            IReadSegment readSegment,
            ICreateSegment createSegment,
            IDeleteSegment deleteSegment,
            IUpdateSegment updateSegment
    ) {
        this.readSegment = readSegment;
        this.createSegment = createSegment;
        this.deleteSegment = deleteSegment;
        this.updateSegment = updateSegment;
    }

    @Operation(summary = "Retrieve all segments",
            description = "Fetches a list of all segments.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of segments",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SegmentDTO.class)))
    })
    public Result getAll() {
        List<SegmentDTO> segments = readSegment.getAll();
        return ok(Json.toJson(segments));
    }

    @Operation(summary = "Create a new segment",
            description = "Creates a new segment with the provided details.")
    @RequestBody(description = "Segment details to create", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SegmentDTO.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successful creation of segment",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SegmentDTO.class)))
    })
    public Result create(Http.Request request) {
        SegmentDTO segment = Json.fromJson(request.body().asJson(), SegmentDTO.class);
        createSegment.create(segment);
        return created(Json.toJson(segment));
    }

    @Operation(summary = "Retrieve a specific segment", description = "Fetches a segment by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of segment",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SegmentDTO.class))),
            @ApiResponse(responseCode = "404", description = "Segment not found")
    })
    public Result get(Integer id) {
        Optional<SegmentDTO> segment = readSegment.get(id);
        return ok(Json.toJson(segment));
    }

    @Operation(summary = "Delete a segment", description = "Deletes a segment by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful deletion of segment"),
            @ApiResponse(responseCode = "404", description = "Segment not found")
    })
    public Result delete(Integer id) {
        deleteSegment.delete(id);
        return ok();
    }

    @Operation(summary = "Update a segment", description = "Updates a segment with the provided ID and details.")
    @RequestBody(description = "Updated segment details", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Segment.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful update of segment",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Segment.class))),
            @ApiResponse(responseCode = "404", description = "Segment not found")
    })
    public Result update(Integer id, Http.Request request) {
        Segment segment = Json.fromJson(request.body().asJson(), Segment.class);
        updateSegment.update(id, segment);
        return ok(Json.toJson(segment));
    }
}
