package main.plane.redisrepo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {}