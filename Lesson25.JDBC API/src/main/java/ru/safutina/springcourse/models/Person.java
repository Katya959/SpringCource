package ru.safutina.springcourse.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// Наша модель - человек.
public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty") // Не может пустым значением! ""
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters") // Размер name (количество символов, букв)
    private String name;

    @Min(value = 0, message = "Age should be greater than 0")  // Только целые положительные числа!
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")   // Проверяется, что лежит именно email; используется регулярное выражение
    private String email;

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
