package cassandra.test.cassandratest.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class ProductEntity {

    @PrimaryKey
    private UUID id;
    private String name;
    private String description;
    private Double value;

    public ProductEntity() {
    }

    public ProductEntity(UUID id, String name, String description, Double value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
