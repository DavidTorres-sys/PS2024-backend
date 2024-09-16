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

import persistence.dto.RoadDTO;
import persistence.entities.Road;
import services.road.createRoad.ICreateRoad;
import services.road.deleteRoad.IDeleteRoad;
import services.road.readRoad.IReadRoad;
import services.road.updateRoad.IUpdateRoad;

public class RoadController extends Controller {

    private final IReadRoad readRoad;
    private final ICreateRoad createRoad;
    private final IDeleteRoad deleteRoad;
    private final IUpdateRoad updateRoad;

    @Inject
    public RoadController(
            IReadRoad readRoad,
            ICreateRoad createRoad,
            IDeleteRoad deleteRoad,
            IUpdateRoad updateRoad
    ) {
        this.readRoad = readRoad;
        this.createRoad = createRoad;
        this.deleteRoad = deleteRoad;
        this.updateRoad = updateRoad;
    }

    @Operation(summary = "Retrieve all roads",
            description = "Fetches a list of all roads.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of roads",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoadDTO.class)))
    })
    public Result getAll() {
        List<RoadDTO> roads = readRoad.getAll();
        return ok(Json.toJson(roads));
    }

    @Operation(summary = "Create a new road",
            description = "Creates a new road from the provided details.")
    @RequestBody(description = "Road details to create",
            required = true, content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = RoadDTO.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successful creation of road",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoadDTO.class)))
    })
    public Result create(Http.Request request) {
        RoadDTO road = Json.fromJson(request.body().asJson(), RoadDTO.class);
        createRoad.create(road);
        return created(Json.toJson(road));
    }

    @Operation(summary = "Retrieve a specific road", description = "Fetches a road by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of road",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoadDTO.class))),
            @ApiResponse(responseCode = "404", description = "Road not found")
    })
    public Result get(Integer id) {
        Optional<RoadDTO> road = readRoad.get(id);
        return ok(Json.toJson(road));
    }

    @Operation(summary = "Delete a road", description = "Deletes a road by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful deletion of road"),
            @ApiResponse(responseCode = "404", description = "Road not found")
    })
    public Result delete(Integer id) {
        deleteRoad.delete(id);
        return ok();
    }

    @Operation(summary = "Update a road",
            description = "Updates a road with the provided ID and details.")
    @RequestBody(description = "Updated road details",
            required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = RoadDTO.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful update of road",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Road.class))),
            @ApiResponse(responseCode = "404", description = "Road not found")
    })
    public Result update(Integer id, Http.Request request) {
        RoadDTO roadDTO = Json.fromJson(request.body().asJson(), RoadDTO.class);
        updateRoad.update(id, roadDTO);
        return ok(Json.toJson(roadDTO));
    }
}
