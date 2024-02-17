# redis-example

Sample project describing the issue when publishing data using ReactiveRedisDataSource pubsub


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Redis CLI command to subscribe a channel

```shell
redis-cli

SUBSCRIBE <channel-name>
```
