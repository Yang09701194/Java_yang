package main.plane.mongodb

import org.springframework.data.repository.CrudRepository

interface AircraftRepository: CrudRepository<Aircraft, String>
