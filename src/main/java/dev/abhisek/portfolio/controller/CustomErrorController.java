package dev.abhisek.portfolio.controller;

import dev.abhisek.portfolio.exception.handler.GlobalExceptionHandler;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String error(Model model) {
        model.addAttribute("errorModel",
                GlobalExceptionHandler
                        .ErrorModel
                        .builder()
                        .heading("404")
                        .message("Oops! the page not found on server")
                        .build());

        return "errorpage";
    }
}
