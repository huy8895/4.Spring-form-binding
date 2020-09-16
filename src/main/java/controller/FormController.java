package controller;

import model.ConfigMail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {
    @GetMapping
    public String show(Model model){
        String[] languages = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        int[] emailPerPage = new int[]{ 5, 10, 15, 25, 50, 100};
        model.addAttribute("languages",languages);
        model.addAttribute("emailPerPage",emailPerPage);
        model.addAttribute("configMail",new ConfigMail());
        return "/index";
    }

    @PostMapping
    public String Update(ConfigMail configMail){
        System.out.println("configMail: ");
        System.out.println("configMail.getLanguage() = " + configMail.getLanguage());
        System.out.println("configMail.getSignature() = " + configMail.getSignature());
        System.out.println("configMail.isSpamFilter() = " + configMail.isSpamFilter());
        System.out.println("configMail.getPageSize() = " + configMail.getPageSize());
        return "redirect:/form";
    }
}
