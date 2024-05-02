package hello.projectforpresident.controller;

import hello.projectforpresident.entity.User;
import hello.projectforpresident.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView mav = new ModelAndView("signup");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> user = userService.authenticateUser(email, password);
        if (user.isPresent()) {
            // 로그인 성공 처리
            return "redirect:/";
        } else {
            model.addAttribute("loginError", true);
            return "login";
        }
    }
}