package dev.abhisek.portfolio.service.impl;

import dev.abhisek.portfolio.model.Skill;
import dev.abhisek.portfolio.repository.SkillRepository;
import dev.abhisek.portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import dev.abhisek.portfolio.util.ModelUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;
    @Override
    public List<List<Skill>> getAllSkill() {
        return ModelUtil.oneDToTwoD(repository.findAll(),3);
    }
}
