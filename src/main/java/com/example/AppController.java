package com.example;


import com.example.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.services.QuestionService;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private QuestionService service;

    @RequestMapping("/")
    public String viewFirstPage(Model model) {
        List<Question> listQuestions = service.listAll();
        model.addAttribute("listQuestions", listQuestions);

        return "index";
    }

}
