public class Animal {
    private final int animalDistanceRun;
    private final int animalDistanceSwim;


    Animal(int animalDistanceRun, int animalDistanceSwim) {
        this.animalDistanceRun = animalDistanceRun;
        this.animalDistanceSwim = animalDistanceSwim;
    }

    public boolean run(int mean) {
        return animalDistanceRun > mean;
    }

    public boolean swim(int mean) {
        return animalDistanceSwim > mean;
    }

    int getAnimalDistanceRun() {
        return animalDistanceRun;
    }

    int getAnimalDistanceSwim() {
        return animalDistanceSwim;
    }


}
