import java.util.Arrays;

public class Main extends Thread {
    @Override
    public void run() {
        super.run();
    }

    private static final int size = 10000000;
    private static final int n = 4;
    private static final  int h = size / n;
    private static  float[] arr = new float[size];

    public static void main(String[] args) {
        Main m = new Main();
        m.firstArr();
        m.secondArr();

    }

    private void firstArr() {
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }

        long end = System.currentTimeMillis();
        System.out.println("Время окончание первого метода: " + (end + a));

    }

    private void secondArr() {
        Thread[] threads = new Thread[n];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        float[][] halfArr = new float[n][h];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr, i*h, halfArr[i], 0, h);
        }

        long split = System.currentTimeMillis();
        System.out.println("Время разделения: " + (split + a));

        for (int i = 0; i < n; i++) {
            int over = i;
            threads[i] = new Thread(() -> calcSecondArr(halfArr, over));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long concat = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            System.arraycopy(halfArr[i], 0, arr, i*h, h);
        }

        long end = System.currentTimeMillis();
        System.out.println("Время соединеения: " + (end + concat));
        System.out.println("Время окончания второго метода: " + (end + a));
    }

    private void calcSecondArr(float[][] arr, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < h; i++) {
            arr[n][i] = (float) (arr[n][i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }

        long end = System.currentTimeMillis();
        System.out.println("Время окончания " + (n+1) + " потока: " + (end - start));
    }
}
