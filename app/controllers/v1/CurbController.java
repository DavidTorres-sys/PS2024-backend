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

import services.curb.createCurb.ICreateCurb;
import services.curb.deleteCurb.IDeleteCurb;
import services.curb.readCurb.IReadCurb;
import services.curb.updateCurb.IUpdateCurb;
import persistence.entities.Curb;
import persistence.dto.CurbDTO;

public class CurbController extends Controller {

    private final IReadCurb readCurb;
    private final ICreateCurb createCurb;
    private final IDeleteCurb deleteCurb;
    private final IUpdateCurb updateCurb;

    @Inject
    public CurbController(
            IReadCurb readCurb,
            ICreateCurb createCurb,
            IDeleteCurb deleteCurb,
            IUpdateCurb updateCurb
    ) {
        this.readCurb = readCurb;
        this.createCurb = createCurb;
        this.deleteCurb = deleteCurb;
        this.updateCurb = updateCurb;
    }

    @Operation(summary = "Retrieve all curbs", description = "Fetches a list of all curbs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of curbs",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CurbDTO.class)))
    })
    public Result getAll() {
        List<CurbDTO> curbs = readCurb.getAll();
        return ok(Json.toJson(curbs));
    }

    @Operation(summary = "Create a new curb", description = "Creates a new curb from the provided details.")
    @RequestBody(description = "Curb details to create",
            required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CurbDTO.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successful creation of curb",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CurbDTO.class)))
    })
    public Result create(Http.Request request) {
        CurbDTO curb = Json.fromJson(request.body().asJson(), CurbDTO.class);
        createCurb.create(curb);
        return created(Json.toJson(curb));
    }

    @Operation(summary = "Retrieve a specific curb", description = "Fetches a curb by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of curb",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CurbDTO.class))),
            @ApiResponse(responseCode = "404",
                    description = "Curb not found")
    })
    public Result get(Integer id) {
        Optional<CurbDTO> curb = readCurb.get(id);
        return ok(Json.toJson(curb));
    }

    @Operation(summary = "Delete a curb", description = "Deletes a curb by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful deletion of curb"),
            @ApiResponse(responseCode = "404", description = "Curb not found")
    })
    public Result delete(Integer id) {
        deleteCurb.delete(id);
        return ok();
    }

    @Operation(summary = "Update a curb", description = "Updates a curb with the provided ID and details.")
    @RequestBody(description = "Updated curb details",
            required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CurbDTO.class)))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful update of curb",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CurbDTO.class))),
            @ApiResponse(responseCode = "404", description = "Curb not found")
    })
    public Result update(Integer id, Http.Request request) {
        CurbDTO curbDTO = Json.fromJson(request.body().asJson(), CurbDTO.class);
        updateCurb.update(id, curbDTO);
        return ok(Json.toJson(curbDTO));
    }
}
