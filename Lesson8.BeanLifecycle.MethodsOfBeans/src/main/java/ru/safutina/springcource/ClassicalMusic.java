package ru.safutina.springcource;

public class ClassicalMusic implements Music {
    //Ограничиваем создание объектов этого класса (с помощью new) - делаем приватный конструктор
    private ClassicalMusic() {}

    // Создаем фабричный метод
    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    // Название init-method может быть любым
    public void doMyInit() {
        System.out.println("Dping my initialization");
    }

    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
