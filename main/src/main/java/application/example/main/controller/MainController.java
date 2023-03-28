package application.example.main.controller;

import application.example.main.domain.Settings;
import application.example.main.domain.User;
import application.example.main.repos.SettingsRepo;
import application.example.main.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SettingsRepo settingsRepo;

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/error")
    public String error(Map<String, Object> model) {
        return "error";
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @PostMapping("showAll")
    public String showAll(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<User> users;
        if (filter != null) {
            users = userRepo.findByUsername(filter);
        } else {
            users = userRepo.findAll();
        }
        model.put("users", users);
        return "main";
    }

    @PostMapping("showTags")
    public String showTags(Map<String, Object> model) {
        Iterable<Settings> settings = settingsRepo.findAll();
        model.put("settings", settings);
        return "main";
    }

    @PostMapping("subscribe")
    public String subscribeToTag(@AuthenticationPrincipal User user, @RequestParam String tag, Map<String, Object> model) {
        Settings setting = new Settings(tag, user);
        settingsRepo.save(setting);
        
        Iterable<Settings> settings = settingsRepo.findAll();
        model.put("settings", settings);
        return "main";
    }

}