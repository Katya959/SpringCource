package ru.safutina.springcource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        //Music music = context.getBean("musicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);

        /* Получаем musicPlayer из context. В качестве аргумента передаем id нашего bean, а также класс.
        С помощью Spring мы внедряем зависимость. Не внедряется зависимость вручную, это доверили Spring
        с помощью тега constructor-arg и ссылки на объект.
        */
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

        context.close();
        /*
        Spring читает этот файл: сначала создает bean-ы, потом дошел до bean-a MusicPlayer и внедрил
        musicBean в MusicPlayer. Таким образом, совершил Dependency Injection.
         */
    }
}
