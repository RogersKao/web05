package kao.ij1.web05.repositories;

import kao.ij1.web05.models.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
