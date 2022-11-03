package ru.safutina.springcource;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    // Список музыки
    private List<Music> musicList = new ArrayList<>();

    //private Music music;

    private String name;   // Название нашего музыкального плеера.

    // С помощью getter мы будем получать значения в методе main.
    public String getName() {
        return name;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public int getVolume() {
        return volume;
    }

    // Setter используются в applicationContext для назначения значений полям
    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    private int volume;    // Громкость

    //IoC (с помощью конструктора)
    /*public MusicPlayer(Music music) {
        this.music = music;
    }*/

    /* Вручную создаем, так как пустой конструктор, который java создала,
    удалился при создании конструктора с аргументом */
    public MusicPlayer() {}

    /*public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }*/

    public void playMusicList() {
        for (Music music: musicList)
        System.out.println("Playing: " + music.getSong());
    }
}
