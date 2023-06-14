package dev.abhisek.portfolio.service.impl;

import dev.abhisek.portfolio.model.Project;
import dev.abhisek.portfolio.repository.ProjectRepository;
import dev.abhisek.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;
    @Override
    public List<Project> getAllProject() {
        return repository.findAll();
    }
}
