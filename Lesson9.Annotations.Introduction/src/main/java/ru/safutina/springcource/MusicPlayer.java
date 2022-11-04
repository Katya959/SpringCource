package ru.safutina.springcource;

public class MusicPlayer {

    // Применим Инверсию управления (архитектуру IoC).
    // Зависимость - общий интерфейс Music
    private Music music;

    // Передаем зависимость. Используется полиморфизм.
    // IoC (с помощью конструктора).
    public MusicPlayer(Music music) {
        this.music = music;
    }

    // Будет использоваться внедренная зав-ть. Один из жанров музыки, из него будем получать музыку.
    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
