
package ru.safutina.springcource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.safutina.springcource.config.SpringConfig;
import ru.safutina.springcource.genresOfMusic.ClassicalMusic;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.playMusic());

        context.close();
    }
}