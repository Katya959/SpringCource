package ru.safutina.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

/* Внедрение зависимости в наш MusicPlayer.
Раньше мы создавали объект класса MusicPlayer вручную с использованием ключевого слова new,
теперь мы будем создавать его с помощью Spring, получать его из контекста уже с внедренной зависимостью.
 */
@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic,
                       RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public void playMusic(GenreOfMusic musicGenre) {
        Random random = new Random();

        // Случайное число между 0 и 2
        int randomNumber = random.nextInt(3);

        if (musicGenre == GenreOfMusic.CLASSICAl) {
            // Будет играть классическая песня из списка под номером randomNumber
            System.out.println(classicalMusic.getSongs().get(randomNumber));
        }
        else {
            // будет играть рок песня из списка под номером randomNumber
            System.out.println(rockMusic.getSongs().get(randomNumber));
        }
    }
}
