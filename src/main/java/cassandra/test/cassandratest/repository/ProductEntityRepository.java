package cassandra.test.cassandratest.repository;

import cassandra.test.cassandratest.model.ProductEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductEntityRepository extends CassandraRepository<ProductEntity, UUID> {
}
