# Example of Eureka with Spring Boot

## Taste

Do with the following order.

### Launch Service Registry

```bash
cd registry
./gradlew bootRun
```

Browse http://localhost:8761

### Launch First Service

Open new terminal.

```bash
cd service
./gradlew bootRun
```

Check http://localhost:8080/random-integers

### Launch Second Service consuming the upper service

Open new terminal.

```bash
cd client
./gradlew bootRun
```

Check http://localhost:8091/