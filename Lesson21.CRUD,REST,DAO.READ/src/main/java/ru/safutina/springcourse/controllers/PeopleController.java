package ru.safutina.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.safutina.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    /* Бин PersonDAO с помощь Spring внедряется автоматически в наш контроллер.
    Автоматически создаст бин PersonDAO и этот бин внедрит в наш контроллер.
    Person не @Component, мы не доджны создавать его бинов.
    Если есть DAO, значит, уже можно получать людей из нашей условной БД.
     */
    private final PersonDAO personDAO;

    @Autowired    // Можно писать, но можно и не писать; Spring в любом случае внедрит эту зависимость в наш контроллер.
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    // Метод возвращает список из людей
    @GetMapping()    // Адрес этого метода просто /people.
    public String index(Model model) {
        // Получим всех людей из DAO и передадим на отображение этих людей в представление
        // С помощью Thymeleaf отобразим этих людей
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    // При запуске вместо id можно поместить любое число и оно поместится в аргументы этого метода.
    @GetMapping("/{id}")
    // С помощью аннотации PathVariable мы извлекаем этот id из url, получаем доступ к нему внутри этого метода
    public String show(@PathVariable("id") int id, Model model) {
        /* Извлечение одного человека из DAO. Получим одного человека по id из DAO и передадим его на отображение в представление */
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
