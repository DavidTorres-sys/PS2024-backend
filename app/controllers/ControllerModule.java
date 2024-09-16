package controllers;

import com.google.inject.AbstractModule;
import io.micrometer.prometheusmetrics.PrometheusConfig;
import io.micrometer.prometheusmetrics.PrometheusMeterRegistry;


public class ControllerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PrometheusMeterRegistry.class).toInstance(new PrometheusMeterRegistry(PrometheusConfig.DEFAULT));
    }
}

