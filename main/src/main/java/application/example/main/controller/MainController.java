package application.example.main.controller;

import application.example.main.domain.Settings;
import application.example.main.domain.User;
import application.example.main.repos.SettingsRepo;
import application.example.main.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SettingsRepo settingsRepo;

    @Value("${upload.path}")
    private String uploadPath;

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
        if (!filter.isEmpty()) {
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
        for (Settings setting : settings) {
            System.out.println(setting);
        }
        model.put("settings", settings);
        return "main";
    }

    @PostMapping("subscribe")
    public String subscribeToTag(
            @AuthenticationPrincipal User user,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file) throws IOException {

        if (tag.isEmpty()) return "main";

        Settings setting = new Settings(tag, user);

        if (!file.isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            setting.setFilename(resultFilename);
        }
        settingsRepo.save(setting);
        return "main";
    }

}