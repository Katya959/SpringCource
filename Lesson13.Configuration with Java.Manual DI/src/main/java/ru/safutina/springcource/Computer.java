package ru.safutina.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* MusicPlayer - часть нашего класса Computer (в компьютере есть музыкальный плеер).
Зависимость зависит от другой зависимости. */
public class Computer {

    private int id;
    private MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        // id не будет внедряться Spring.
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer " + id + " " + musicPlayer.playMusic();
    }
}