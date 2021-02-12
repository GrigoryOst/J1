import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        catVsDog();
    }

    public static void catVsDog() {
        Scanner scanner = new Scanner(System.in);
        int distanceRun = (int) (Math.random() * 200);
        int distanceSwim = (int) (Math.random() * 0);
        Cat cat = new Cat(distanceRun, distanceSwim);

        distanceRun = (int) (Math.random() * 500);
        distanceSwim = (int) (Math.random() * 10);
        Dog dog = new Dog(distanceRun, distanceSwim);

        System.out.println("Кот может пробежать всего: " + cat.getAnimalDistanceRun() + " м. " +
                "Пес может пробежать всего: " + dog.getAnimalDistanceRun() + " м.");

        System.out.println("Введите дистанцию для бега:");
        int distance = scanner.nextInt();

        System.out.println("Кот пытается бежать(" + distance + "). Результат: " + cat.run(distance));
        System.out.println("Пес пытается бежать(" + distance + "). Результат: " + dog.run(distance));
        System.out.println("Общее количество котов = " + Cat.count);
        System.out.println("Общее количество псов = " + Dog.count);
        System.out.println();

        System.out.println("Кот не умеет плавать. Пес может проплыть: " + dog.getAnimalDistanceSwim() + " м.");

        System.out.println("Введите дистанцию для плавания:");
        distance = scanner.nextInt();

        System.out.println("Кот не умеет плавать.");
        System.out.println("Пес пытается плыть(" + distance + "). Результат: " + dog.swim(distance));
        System.out.println("Общее количество котов = " + Cat.count);
        System.out.println("Общее количество псов = " + Dog.count);
        System.out.println("Всего животных не пострадало = " + (Cat.count + Dog.count));
    }
}