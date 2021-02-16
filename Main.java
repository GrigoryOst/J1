import java.util.Random;

public class Main {


    public static void main(String[] args) {
        team();

    }

    private static void team () {


        Members human1 = new Man();
        Members cat1 = new Cat();
        Members robot1 = new Robot();
        Random random = new Random();

        Obstacle wall1 = new Wall(random.nextInt(500));
        Obstacle run1 = new RaceTrack(random.nextInt(10000));

        Members[] members1 = {human1, cat1, robot1};
        Obstacle[] obstacles1 = {wall1, run1};

        battle(members1, obstacles1);

        System.out.println("Победила Дружба!");
    }

    static void battle (Members run[], Obstacle obstacle[]) {
        for (int i = 0; i < run.length; i++) {
            for (int j = 0; j < obstacle.length; j++) {
                if (!obstacle[j].attempt(run[i])) {
                    System.out.println(run[i] + " вышел из гонки!");
                    if (run.length == (i+1)) {
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

    }
}
