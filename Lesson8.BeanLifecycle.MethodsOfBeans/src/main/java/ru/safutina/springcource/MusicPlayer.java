package ru.safutina.springcource;

public class MusicPlayer {

    private Music music;

    private String name;   // Название нашего музыкального плеера.

    // С помощью getter мы будем получать значения в методе main.
    public String getName() {
        return name;
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
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer() {}

    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
