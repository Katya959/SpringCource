package ru.safutina.springcource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.safutina.springcource.Computer;
import ru.safutina.springcource.Music;
import ru.safutina.springcource.MusicPlayer;
import ru.safutina.springcource.genresOfMusic.ClassicalMusic;
import ru.safutina.springcource.genresOfMusic.JazzMusic;
import ru.safutina.springcource.genresOfMusic.RockMusic;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
/* Внедрение зависимостей вручную (Spring тепер автоматически не создает бины из классов,
не будет также автоматически внедрять зависимости */
public class SpringConfig {
    // Это все делал за нас Spring автоматически.
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public JazzMusic jazzMusic() {
        return new JazzMusic();
    }

    @Bean
    public List<Music> listOfMusic() {
        return Arrays.asList(rockMusic(), classicalMusic(), jazzMusic());
    }

    @Bean
    public MusicPlayer musicPlayer() {
        // Если не первый вызов метода, просто возвращается объект из контекста.
        return new MusicPlayer(listOfMusic());
    }

    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }
}
