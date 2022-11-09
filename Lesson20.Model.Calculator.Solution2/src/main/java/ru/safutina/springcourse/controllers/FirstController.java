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

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b,
                             @RequestParam(value = "action") String action,
                             Model model) {
        //С помощью модели передадим эти параметры http-запроса в представление, и отобразим их пользователю.

        //Также можно просто завести переменную result общую как double. Но в этом случае все, кроме деления, будет с дробной частью.
        double result;
        switch(action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "substraction":
                result = a - b;
                break;
            case "division":
                result =  (double)a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);

        return "first/calculator";
    }
}
