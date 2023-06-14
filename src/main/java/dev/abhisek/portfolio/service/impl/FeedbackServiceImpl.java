package dev.abhisek.portfolio.service.impl;

import dev.abhisek.portfolio.model.Feedback;
import dev.abhisek.portfolio.repository.FeedbackRepository;
import dev.abhisek.portfolio.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository repository;

    @Override
    public void addFeedback(Feedback feedback) {
        repository.save(feedback);
    }
}
