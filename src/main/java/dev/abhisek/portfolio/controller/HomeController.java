package dev.abhisek.portfolio.controller;

import dev.abhisek.portfolio.model.Contact;
import dev.abhisek.portfolio.model.Feedback;
import dev.abhisek.portfolio.service.*;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.NoSuchAlgorithmException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final ExperienceService experienceService;
    private final EducationService educationService;
    private final SkillService skillService;
    private final LanguageService languageService;
    private final ProjectService projectService;
    private final ContactService contactService;
    private final FeedbackService feedbackService;

    @Value("${static.data.facebook-profile}")
    private String facebook;
    @Value("${static.data.linkedin-profile}")
    private String linkedin;
    @Value("${static.data.github-profile}")
    private String github;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("title", "Abhisek | Home");
        model.addAttribute("skills", skillService.getAllSkill());
        model.addAttribute("facebook", facebook);
        model.addAttribute("linkedin", linkedin);
        model.addAttribute("github", github);
        return "home";
    }

    @GetMapping("/resume")
    public String resume(Model model) {
        model.addAttribute("title", "Abhisek | Resume");
        model.addAttribute("experiences", experienceService.getAllExperience());
        model.addAttribute("educations", educationService.getAllEducation());
        model.addAttribute("skills", skillService.getAllSkill());
        model.addAttribute("languages", languageService.getAllLanguage());
        return "resume";
    }

    @GetMapping("/project")
    public String project(Model model) {
        model.addAttribute("title", "Abhisek | Projects");
        model.addAttribute("projects", projectService.getAllProject());
        return "project";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact Me !!!");
        model.addAttribute("contact", Contact.builder().build());
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@ModelAttribute Contact contact, RedirectAttributes redirectAttributes) throws MessagingException, NoSuchAlgorithmException {
        contactService.addContact(contact);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/contact";
    }

    @GetMapping("/verify")
    public String verification(@RequestParam String token, Model model) {
        Contact contact = contactService.verifyContact(token);
        model.addAttribute("title", "Success");
        model.addAttribute("contact", contact);
        return "success";
    }

    @GetMapping("/feedback")
    public String feedback(Model model) {
        model.addAttribute("title", "Feedback");
        model.addAttribute("feedback", Feedback.builder().build());
        return "feedback";
    }

    @PostMapping("/feedback")
    public String feedback(@ModelAttribute Feedback feedback, RedirectAttributes redirectAttributes) {
        feedbackService.addFeedback(feedback);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }


}
