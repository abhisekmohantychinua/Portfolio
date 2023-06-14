package dev.abhisek.portfolio.repository;

import dev.abhisek.portfolio.model.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends MongoRepository<Skill,String> {
}
