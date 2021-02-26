import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        example();

    }

    public static void example () {

        String [][] arr = new String[][] {{"1","2","3","4"}, {"4","3","2","1"},{"3","2","4","1"},{"4","1","3","2"}};
        try {
            try {
                int result = exc(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Неправильный размер массива");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильный размер массива");
        }
    }

    public static int exc (String[][] arr ) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length !=4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length !=4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }



}
