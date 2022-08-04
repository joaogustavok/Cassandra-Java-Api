package cassandra.test.cassandratest.controller;

import cassandra.test.cassandratest.model.ProductEntity;
import cassandra.test.cassandratest.repository.ProductEntityRepository;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    public ProductController(ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    final ProductEntityRepository productEntityRepository;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        var products = this.productEntityRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable UUID id) {
        var product = this.productEntityRepository.findById(id);

        return product.map(productEntity -> new ResponseEntity<>(productEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        try {
            var savedProduct = this.productEntityRepository.save(
                    new ProductEntity(Uuids.timeBased()
                            , product.getName()
                            , product.getDescription()
                            , product.getValue()));

            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable UUID id) {
        try {
            this.productEntityRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
