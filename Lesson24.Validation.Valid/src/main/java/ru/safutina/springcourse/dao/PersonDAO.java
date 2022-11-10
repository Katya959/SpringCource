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

        people.add(new Person(++PEOPLE_COUNT, "Jackson", 20, "jackson@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Tompson", 35, "tompson@bk.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Petr", 42, "petr42@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Vlad", 26, "vladik@mail.ru"));
    }

    public List<Person> index() {
        return people; // С помощью Thymeleaf отобразим в браузере
    }

    public Person show(int id) {
        // Используем лямбда-выражения
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p->p.getId() == id);
    }
}
