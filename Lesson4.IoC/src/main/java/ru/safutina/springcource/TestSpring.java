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
        // Получили из applicationContext bean - объект, который реализует интерфейс Music (класса ClassicalMusic или RockMusic).
        // Меняем лишь класс, bean которого хотим создавать.
        Music music = context.getBean("musicBean", Music.class);
        //Мы не перекомпилируем наше приложение, лишь в applicationContext меняем класс, в music запишется объект того класса, который указан в
        //applicationContext.xml

        // Внедрение зависимости (пока вручную) - жанра музыки. Теперь он может ее играть.
        MusicPlayer musicPlayer = new MusicPlayer(music);

        musicPlayer.playMusic();
        // При завершении работы с ApplicationContext мы его закрываем.
        context.close();
    }
}
