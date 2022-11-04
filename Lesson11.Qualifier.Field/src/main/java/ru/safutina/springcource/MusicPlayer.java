package ru.safutina.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/* Внедрение зависимости в наш MusicPlayer.
Раньше мы создавали объект класса MusicPlayer вручную с использованием ключевого слова new,
теперь мы будем создавать его с помощью Spring, получать его из контекста уже с внедренной зависимостью.
 */
@Component

public class MusicPlayer {
    @Autowired
    // Решена проблема неоднозначности
    @Qualifier("classicalMusic")
    private Music music;

    public String playMusic() {
        return "Playing: " + music.getSong();
    }
}
