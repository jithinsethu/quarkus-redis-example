package io.github.jithset.services;

import io.github.jithset.dto.Location;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.pubsub.PubSubCommands;
import io.quarkus.redis.datasource.pubsub.ReactivePubSubCommands;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class RedisService {
    private static final Logger LOG = Logger.getLogger(RedisService.class);
    private final String channel = "channel1";
    private final PubSubCommands<Location> pub;
    private final ReactivePubSubCommands<Location> reactivePub;

    public RedisService(RedisDataSource ds, ReactiveRedisDataSource rds) {
        pub = ds.pubsub(Location.class);
        reactivePub =  rds.pubsub(Location.class);
    }

    public void publishData() {
        Location location = new Location();
        location.setId(UUID.randomUUID());
        location.setTimestamp(LocalDateTime.now());
        pub.publish(channel, location);
    }

    public void reactivePublishData() {
        Location location = new Location();
        location.setId(UUID.randomUUID());
        location.setTimestamp(LocalDateTime.now());
        reactivePub.publish(channel, location);
    }
}
