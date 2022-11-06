package ru.safutina.springcource.genresOfMusic;
import org.springframework.stereotype.Component;
import ru.safutina.springcource.Music;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// В скобках можно написать id нашего компонента (бина)

public class RockMusic implements Music {

    @PostConstruct
    public void doMyInit() {
        System.out.println("Doing my initialization");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}