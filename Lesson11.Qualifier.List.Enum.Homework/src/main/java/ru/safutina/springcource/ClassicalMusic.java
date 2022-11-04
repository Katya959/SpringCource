package ru.safutina.springcource;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    private List<String> songsOfClassicalMusic = new ArrayList<>();

    /* Блок инициализации объекта (англ. Instance initialization block).
    Он будет выполняться каждый раз, когда создается объект этого класса
     */
    {
        songsOfClassicalMusic.add("The Planets");
        songsOfClassicalMusic.add("The Song of Hiawatha");
        songsOfClassicalMusic.add("Enigma Variations");
    }
    @Override
    public List<String> getSongs() {
        return songsOfClassicalMusic;
    }
}
