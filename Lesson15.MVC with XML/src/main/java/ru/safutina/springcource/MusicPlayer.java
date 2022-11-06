package ru.safutina.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/* Внедрение зависимости в наш MusicPlayer.
Раньше мы создавали объект класса MusicPlayer вручную с использованием ключевого слова new,
теперь мы будем создавать его с помощью Spring, получать его из контекста уже с внедренной зависимостью.
 */

public class MusicPlayer {
    // Внедрим значение с помощью аннотации
    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    private List<Music> listOfMusic;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public MusicPlayer(List<Music> listOfMusic) {
        this.listOfMusic = listOfMusic;
    }

    public String playMusic() {
        Random rnd = new Random();
        int k = rnd.nextInt(listOfMusic.size());
        return "Playing: " + listOfMusic.get(k).getSong() + " with volume: " + this.volume;
    }
}