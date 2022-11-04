package ru.safutina.springcource;
import org.springframework.stereotype.Component;

// В скобках можно написать id нашего компонента (бина)
@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}