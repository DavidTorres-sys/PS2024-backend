package controllers;

import io.micrometer.prometheusmetrics.PrometheusMeterRegistry;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class MetricsController extends Controller {
    private final PrometheusMeterRegistry prometheusMeterRegistry;

    @Inject
    public MetricsController(PrometheusMeterRegistry prometheusMeterRegistry) {
        this.prometheusMeterRegistry = prometheusMeterRegistry;
    }

    public Result getMetrics() {
        return ok(prometheusMeterRegistry.scrape()).as("text/plain");
    }
}
