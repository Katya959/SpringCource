package ru.safutina.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    // Будем отображать приветствие Hello, World!

    // Метод, который будет возвращать необходимое представление.
    // В скобках указываем какой url будет приходить в этот метод контроллера.
    @GetMapping("/hello-world")
    /* Когда пользователь будет вводить в строке браузера наше_приложение/hello-world,
    его запрос будет приходить в контроллер, в этот метод этого контроллера.
     */
    public String sayHello() {
        /* В этом методе пользователя можно перенаправлять, обращаться к модели,
        доставать данные из БД, показывать эти данные пользователю и тд */

        // Здесь же мы просто вернем представление. Наше представление должно называться hello_world.html.
        return "hello_world";
    }
}
