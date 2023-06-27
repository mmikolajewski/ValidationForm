package pl.javastart.validation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserDtoRepository userDtoRepository;

    public RegistrationController(UserDtoRepository userDtoRepository) {
        this.userDtoRepository = userDtoRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("newUser", userDto);
        return "home";
    }

    @PostMapping("/form")
    String home(@Valid @ModelAttribute("newUser") UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("newUser", userDto);
            return "home";
        } else {
            userDtoRepository.save(userDto);
            return "redirect:/approved";
        }
    }
    @GetMapping("/approved")
    String approved() {
        return "approved";
    }
}
