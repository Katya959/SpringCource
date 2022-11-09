package ru.safutina.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    // У всех методов в этом классе теперь будет префикс в адресе /first.

    @GetMapping("/hello")
    /* Хотим принимать на вход GET запросы
    В параметры url хотим передавать параметры.
    Внедряем HttpServletRequest, чтобы принимать эти параметры.
    Объект HttpServletRequest - все сведения о поступающем http-запросе от пользователя.
    */
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        //С помощью модели передадим эти параметры http-запроса в представление, и отобразим их пользователю.

        //System.out.println("hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
