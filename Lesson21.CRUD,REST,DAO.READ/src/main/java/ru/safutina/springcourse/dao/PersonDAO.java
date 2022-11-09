package ru.safutina.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.safutina.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

// Помечаем как компонент
@Component
public class PersonDAO {
    // Будет общаться со списком (условная БД пока). Извлекать людей из списка, находить конкретного человека по id из списка.
    private static int PEOPLE_COUNT;
    private List<Person> people;

    // Создадим несколько людей, чтобы были данные в списке, которые можно отобразить
    // Блок инициализации
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Jackson"));
        people.add(new Person(++PEOPLE_COUNT, "Tompson"));
        people.add(new Person(++PEOPLE_COUNT, "Petr"));
        people.add(new Person(++PEOPLE_COUNT, "Vlad"));
    }

    public List<Person> index() {
        return people; // С помощью Thymeleaf отобразим в браузере
    }

    public Person show(int id) {
        // Используем лямбда-выражения
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
