package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class HealthCheckController extends Controller {

    public Result health() {
        JsonNode response = Json.newObject()
                .put("status", "UP")
                .put("message", "Application is running");

        return ok(response);
    }
}
