class Dog extends Animal {

    static int count = 0;

    Dog(int animalDistanceRun, int animalDistanceSwim) {
        super(animalDistanceRun, animalDistanceSwim);
        count++;
    }

    @Override
    public boolean run(int mean) {
        return super.run(mean);
    }

    @Override
    public boolean swim(int mean) {
        return super.swim(mean);
    }

    @Override
    int getAnimalDistanceRun() {
        return super.getAnimalDistanceRun();
    }

    @Override
    int getAnimalDistanceSwim() {
        return super.getAnimalDistanceSwim();
    }

}
