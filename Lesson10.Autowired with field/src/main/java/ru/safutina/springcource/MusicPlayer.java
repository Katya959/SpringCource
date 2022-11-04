package ru.safutina.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* Внедрение зависимости в наш MusicPlayer.
Раньше мы создавали объект класса MusicPlayer вручную с использованием ключевого слова new,
теперь мы будем создавать его с помощью Spring, получать его из контекста уже с внедренной зависимостью.
 */
@Component
public class MusicPlayer {
    @Autowired
    private Music music;

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
