package ru.safutina.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String helloPage(HttpServletRequest request) {
        // Получение доступа к параметрам из GET запроса.
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
