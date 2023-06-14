package dev.abhisek.portfolio.service.impl;

import dev.abhisek.portfolio.model.Education;
import dev.abhisek.portfolio.repository.EducationRepository;
import dev.abhisek.portfolio.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository repository;

    @Override
    public List<Education> getAllEducation() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "start"));
    }
}
