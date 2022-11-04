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
    private Music music1;
    private Music music2;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic() {
        return "Playing: " + music1.getSong() + ", " + music2.getSong();
    }
}
