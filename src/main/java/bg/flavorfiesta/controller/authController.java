package bg.flavorfiesta.controller;

import bg.flavorfiesta.model.dto.UserRegisterDto;
import bg.flavorfiesta.service.userService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class authController {

    private final bg.flavorfiesta.service.userService userService;

    public authController(userService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    private UserRegisterDto regModelDto() {
        return new UserRegisterDto();
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid UserRegisterDto regModelDto, BindingResult bindingResult, RedirectAttributes redAttrib) {

        if (bindingResult.hasErrors()) {
            //Shows error
            redAttrib.addFlashAttribute("regModelDto", regModelDto);
            redAttrib.addFlashAttribute("org.springframework.validation.BindingResult.regModelDto", bindingResult);
            return "redirect:register";
        }

        boolean isRegistered = userService.createNewUser(regModelDto);

        if (isRegistered) {
            return "redirect:login";
        } else {
            return "redirect:register";
        }

    }
}
