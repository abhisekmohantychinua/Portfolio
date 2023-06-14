package dev.abhisek.portfolio.repository;

import dev.abhisek.portfolio.model.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends MongoRepository<Experience,String> {
}
