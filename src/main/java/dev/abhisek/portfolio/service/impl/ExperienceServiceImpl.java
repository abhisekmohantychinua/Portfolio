package dev.abhisek.portfolio.service.impl;

import dev.abhisek.portfolio.model.Experience;
import dev.abhisek.portfolio.repository.ExperienceRepository;
import dev.abhisek.portfolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository repository;

    @Override
    public List<Experience> getAllExperience() {
        return repository.findAll();
    }
}
