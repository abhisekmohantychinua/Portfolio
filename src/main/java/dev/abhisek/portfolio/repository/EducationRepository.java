package dev.abhisek.portfolio.repository;

import dev.abhisek.portfolio.model.Education;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends MongoRepository<Education,String> {
}
