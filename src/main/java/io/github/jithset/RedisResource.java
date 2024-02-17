package io.github.jithset;

import io.github.jithset.services.RedisService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/redis")
public class RedisResource {
    @Inject
    RedisService redisService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        redisService.publishData();
        return "Hello";
    }

    @GET
    @Path("/reactive")
    @Produces(MediaType.TEXT_PLAIN)
    public String redisReactive() {
        redisService.reactivePublishData();
        return "Hello from RESTEasy Reactive";
    }
}
