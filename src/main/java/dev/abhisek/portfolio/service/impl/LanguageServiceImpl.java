package dev.abhisek.portfolio.service.impl;

import dev.abhisek.portfolio.model.Language;
import dev.abhisek.portfolio.repository.LanguageRepository;
import dev.abhisek.portfolio.service.LanguageService;
import dev.abhisek.portfolio.util.ModelUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository repository;

    @Override
    public List<List<Language>> getAllLanguage() {
        return ModelUtil.oneDToTwoD(repository.findAll(), 3);
    }
}
