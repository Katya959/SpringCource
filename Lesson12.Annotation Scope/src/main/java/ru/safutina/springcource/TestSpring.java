
package ru.safutina.springcource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);

        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);

        // Проверим, указывают ли данные переменные на один и тот же объект, на один и тот же участок в памяти.
        System.out.println(classicalMusic1 == classicalMusic2);  // true сo scope singleton, false сo scope prototype

        context.close();
    }
}