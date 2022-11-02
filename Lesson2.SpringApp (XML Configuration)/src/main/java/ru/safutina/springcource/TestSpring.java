package ru.safutina.springcource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    //Тестирование работы Spring framework.
    public static void main(String[] args) {
        /* Файл в скобке должен лежать в папке с ресурсами, иначе ClassPathXmlApplicationContext не сможет найти этот файл.
        Он обязательно должен лежать в ClassPath папке нашей java, там он виден.
        * */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        /* Конфгурационный файл прочитан. Теперь можно из ApplicationContext достать наш bean, созданный spring.
        Передаем методу id нашего bean, а также класс, bean которого хотим получить.
         */
        // Получили объект класса TestBean. Он уже готовый, с ним можно работать.
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());
        // При завершении работы с ApplicationContext мы его закрываем.
        context.close();
    }
}
