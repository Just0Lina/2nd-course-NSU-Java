package application.example.main.controller;

import application.example.main.domain.Product;
import application.example.main.domain.Settings;
import application.example.main.domain.User;
import application.example.main.repos.SettingsRepo;
import application.example.main.repos.UserRepo;
import application.example.main.service.FileService;
import application.example.main.service.ProductService;
import application.example.main.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SettingsRepo settingsRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private FileService<Settings> fileService;

    @Autowired
    private ProductService productService;


    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        return "userPlace/main";
    }

    @GetMapping("/error")
    public String error(Map<String, Object> model) {
        return "error";
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/productView")
    public String productView(Map<String, Object> model) {
        Iterable<Product> products = productService.findAll();
        model.put("products", products);
        return "productPlace/productView";
    }

    @Transactional
    @PostMapping("delete")
    public String userDeleteForm(@RequestParam String userId, Model model) {
        Long id = Long.valueOf(userId.replaceAll("\u00a0", ""));
        settingsRepo.deleteByUser_id(id);
        userRepo.deleteById(id);

        return "redirect:/user";
    }

    @GetMapping("/adminInfo")
    public String adminInfo(Map<String, Object> model) {
        return "userPlace/adminInfo";
    }

    @PostMapping("showAll")
    public String showAll(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "userPlace/adminInfo";
    }

/*    @PostMapping("filteuser/r")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<User> users;
        if (!filter.isEmpty()) {
            users = Collections.singleton(userRepo.findByUsername(filter));
        } else {
            users = userRepo.findAll();
        }
        model.put("users", users);
        return "user/adminInfo";
    }*/

    @PostMapping("filterTags")
    public String filterTags(@AuthenticationPrincipal User user,
                             Map<String, Object> model) {
        System.out.println(user);
        Iterable<Settings> settings = settingsRepo.findByUser_id(user.getId());
        model.put("tags", settings);
        return "user/main";
    }


    @PostMapping("showTags")
    public String showTags(Map<String, Object> model) {
        Iterable<Settings> settings = settingsRepo.findAll();
        model.put("settings", settings);
        return "user/adminInfo";
    }

    @PostMapping("subscribe")
    public String subscribeToTag(
            @AuthenticationPrincipal User user,
            @Valid Settings setting,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file) throws IOException {

//        if (tag.isEmpty()) return "adminInfo";
//        List<Settings> settings = settingsRepo.findByUser_idAndTag(user.getId(), tag);
//        if (!settings.isEmpty()) {
//            System.out.println("Here");
//            return "adminInfo";
//        }
//        Settings setting = new Settings(tag, user);
        if (bindingResult.hasErrors()) {
            System.out.println("Here");
            Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            System.out.println(errorMap);
            model.addAttribute("setting", setting);
        } else {
            setting.setUser(user);
//            FileService fileService;
            setting.setFilename(fileService.saveFile(setting, file));

//            if (!file.isEmpty()) {
//
//                File uploadDir = new File(uploadPath);
//                if (!uploadDir.exists()) {
//                    uploadDir.mkdir();
//                }
//                String uuidFile = UUID.randomUUID().toString();
//                String resultFilename = uuidFile + "." + file.getOriginalFilename();
//                file.transferTo(new File(uploadPath + "/" + resultFilename));
//                setting.setFilename(resultFilename);
//            }
            model.addAttribute("setting", null);
            settingsRepo.save(setting);
        }
        Iterable<Settings> settings = settingsRepo.findAll();
        model.addAttribute("settings", settings);
        return "user/adminInfo";
    }


}