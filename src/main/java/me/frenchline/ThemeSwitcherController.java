package me.frenchline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author swlee
 * @contact frenchline707@gmail.com
 * @since 2019-11-05
 */
@Controller
public class ThemeSwitcherController {

    @GetMapping("/spring-mvc-theme")
    public String themeSwitcher() {
        return "spring-mvc-theme";
    }
}
