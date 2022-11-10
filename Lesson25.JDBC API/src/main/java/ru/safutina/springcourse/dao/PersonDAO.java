package ru.safutina.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.safutina.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Помечаем как компонент
@Component
public class PersonDAO {
    // Будет общаться со списком (условная БД пока). Извлекать людей из списка, находить конкретного человека по id из списка.
    private static int PEOPLE_COUNT;

    // Такие данные желательно должны хранится в отдельном файле properties. Этот файл не показываем никому обычно
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    // Создаем соединение к нашей БД с помощью JDBC
    private static Connection connection;

    static {
        // В последних версиях это делается автоматически
        try {
            /* С помощью рефлексии подгружаем класс Driver.
            Удостоверяемся, что этот класс загружен в оперативную память и им можно пользоваться.
             */
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // С помощью драйвера подключаемся к нашей БД
            connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {
        // Считываем из БД всех людей
        List<Person> people = new ArrayList<>();
        try {
            /* Тот объект, который содержит в себе SQL запрос к БД.
            На нашем соединении создаем объект-запрос к БД.
             */
            Statement statement =  connection.createStatement();
            String SQL = "SELECT * FROM person";
            /* На нашем statement (на нашей БД) выполняем наш sql запрос
            ResultSet - инкапсулирует результат выполнения запроса
             */
            ResultSet resultSet = statement.executeQuery(SQL);

            //Похоже на работу итератора
            while (resultSet.next()) {
                Person person = new Person();
                /* Получаем значение колонки с названием id у текущей строки, на которой сейчас находимся
                Далее это значение кладем в наш person.

                Hibernate это делает за нас. Он автоматически конвертирует строки таблицы в наши объекты в нашем Java приложении
                */
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    /*public Person show(int id) {
         Используем лямбда-выражения
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
   }*/

    public void save(Person person) {
        //person.setId(++PEOPLE_COUNT);
        //people.add(person);
        try {
            Statement statement = connection.createStatement();
            /*
            1) Это очень неудобно
            2) Может возникать большое количество ошибок
            3) Могут возникать SQL инъекции
             */
            String SQL = "INSERT INTO person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";

            //INSERT INTO person VALUES(1, "Tom", 18, 'asfhjs@mail.com')
            statement.executeUpdate(SQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {
        /*
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
        */
    }

    public void delete(int id) {
        //people.removeIf(p->p.getId() == id);
    }
}
