public class Wall implements Obstacle {

    public int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean attempt(Members run) {
        if (run.jump(height) == true) {
            return true;
        } else {
            return false;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
