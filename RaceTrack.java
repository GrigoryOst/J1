public class RaceTrack implements Obstacle{

    public int large;

    public RaceTrack(int large) {
        this.large = large;
    }

    @Override
    public boolean attempt(Members run) {
        if (run.run (large) == true) {
            return true;
        } else {
            return false;
        }
    }

    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    }
}
