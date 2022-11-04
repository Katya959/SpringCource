package ru.safutina.springcource;

import java.util.List;

public interface Music {
    //Возвращает одну песню в определенном жанре (в зав-ти от класса, объект которого создан).
    List<String> getSongs();
}
