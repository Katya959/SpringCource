package ru.safutina.springcource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// В скобках можно написать id нашего компонента (бина)
@Component
public class RockMusic implements Music {
    private List<String> songsOfRockMusic = new ArrayList<>();

    /* Блок инициализации объекта (англ. Instance initialization block).
    Он будет выполняться каждый раз, когда создается объект этого класса
     */
    {
        songsOfRockMusic.add("Purple Haze");
        songsOfRockMusic.add("Whole Lotta Love");
        songsOfRockMusic.add("Sympathy for the Devil");
    }
    @Override
    public List<String> getSongs() {
        return songsOfRockMusic;
    }
}