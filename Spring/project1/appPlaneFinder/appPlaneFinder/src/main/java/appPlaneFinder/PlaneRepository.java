package appPlaneFinder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

//public interface PlaneRepository extends CrudRepository<Aircraft, Long> {
//}
public interface PlaneRepository extends ReactiveCrudRepository<Aircraft, Long> {
}
