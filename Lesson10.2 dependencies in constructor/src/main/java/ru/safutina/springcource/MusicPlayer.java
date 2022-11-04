package ru.safutina.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* Внедрение зависимости в наш MusicPlayer.
Раньше мы создавали объект класса MusicPlayer вручную с использованием ключевого слова new,
теперь мы будем создавать его с помощью Spring, получать его из контекста уже с внедренной зависимостью.
 */
@Component

public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    // Внедрение сразу двух зависимостей (бин ClassicalMusic и бин RockMusic) с помощью конструктора.
    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public String playMusic() {
        return "Playing: " + classicalMusic.getSong();
    }
}
