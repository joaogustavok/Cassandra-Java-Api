## _Spring Boot Cassandra CRUD_
Spring Boot example that use Spring Data Cassandra to make CRUD operations with Cassandra database and Spring Web MVC for Rest APIs.

## Docker Setup

run Cassandra locally in a containerized environment, run the following docker run command:

```docker run -p 9042:9042 --rm --name cassandra -d cassandra:3.11```

After the container is created, access the Cassandra query language shell:

```docker exec -it cassandra cqlsh```

And create a keyspace for the application:

```CREATE KEYSPACE products WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};```

## Swagger Documentation

UI: [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)
