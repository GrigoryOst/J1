import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        System.out.println("Second");
        secondWork();
        System.out.println("Third");
        thirdWork();
        System.out.println("Fourth");
        fourthWork();
        System.out.println("Fifth");
        fifthhWork();
        System.out.println("Sixth");
        sixthWork();
    }

    public static void secondWork () {

        Integer[] n = {9,5,98,43,7,234,2,9,10,20,48};
        List<Integer> list = Arrays.asList(n);
        int a = list.indexOf(5);
        System.out.println("Первый индекс :" + a);


    }

    public static void thirdWork () {
        ThirdWorkReverse reverse = (str3) -> {
            String result3 = "";
            int i;
            for (i = str3.length()-1; i >= 0; i--) {
                result3 += str3.charAt(i);
            } return result3;
        };
        System.out.println(reverse.func3("java interview"));


    }

    public static void fourthWork () {

        int[] values4 = {2,4,5,6,10,13};
        FourthWorkMaxNubmer maxNubmer = (n) -> {
            int sum4;
            sum4 = values4[0];
            for (int i = 0; i < n.length; i++) {
                if (values4[i] > sum4) {
                    sum4 = values4[i];
                }
            } return sum4;
        };
        System.out.println("Максимальное число равно: " + maxNubmer.func4(values4));

    }

    public static void fifthhWork () {

        double[] values5 = {1.0,2.0,3.0,4.0,5.0};

        FifthWorkAverageNumber averageNumber = (n) -> {
            double sum5 = 0;
            if (n.length == 0);
            for (int i = 0; i < n.length; i++) {
                sum5 += n[i];
            } return sum5 / n.length;
        };
        System.out.println("Среднее число равно: " + averageNumber.func5(values5));

    }

    public static void sixthWork () {
        List<String> values6 = Arrays.asList ("bca321", "cbag3132", "abc412", "cab421");
        List<String> result = values6.stream()
                .filter(x -> x.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(result.toString());
        }
    }