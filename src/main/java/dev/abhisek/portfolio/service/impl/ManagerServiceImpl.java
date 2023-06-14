package dev.abhisek.portfolio.service.impl;

import dev.abhisek.portfolio.entity.Manager;
import dev.abhisek.portfolio.repository.ManagerRepository;
import dev.abhisek.portfolio.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository repository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Manager addManager(Manager manager) {
        manager.setId(UUID.randomUUID().toString());
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        manager.setRoles(List.of("MANAGER"));
        manager.setEnabled(false);
        return repository.save(manager);
    }
}
