import com.sun.jmx.snmp.internal.SnmpAccessControlModel;

public class Man implements Members {

    String name;
    int runDistance;
    int jumpDistance;
    int maxRun = 1000;
    int maxJump = 100;

    public Man() {
        this.jumpDistance = maxJump;
        this.runDistance = maxRun;
        this.name = "Антон";
    }

    @Override
    public boolean run (int runDistance) {
        if (this.runDistance > runDistance) {
            System.out.println(name + " смог пробежать!");
            return true;
        } else {
            System.out.println(name + " не смог пробежать!");
            return false;
        }
    }

    @Override
    public boolean jump(int jumpDistance) {
        if (this.jumpDistance > jumpDistance) {
            System.out.println(name + " смог перепрыгнуть!");
            return true;
        } else {
            System.out.println(name + " не смог перепрыгнуть!");
            return false;
        }
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public int getJumpDistance() {
        return jumpDistance;
    }

    public void setJumpDistance(int jumpDistance) {
        this.jumpDistance = jumpDistance;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(int maxJump) {
        this.maxJump = maxJump;
    }
}
