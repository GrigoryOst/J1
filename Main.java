public class Main {

    public static void main(String[] args) {
        exceptions();

    }

    public static void exceptions() {
        Object[][] arr;
        int sum = 0;
        try {
            arr = initArray (4,4);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += (int) arr[i][j];
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("в ячейке [" + i +"] , [" + j + "] находится неизвестный символ");
                }


            }
            System.out.println("Cумма массива = " + sum);
        }
    }

    public static Object[][] initArray (int x, int y) throws MyArraySizeException {
        if (x != 4 || y != 4) {
            throw new MyArraySizeException("Массив 4х4");
        }
        return new Object[][] {{1,2,3,4},{1,2,"3",4}};
    }
}
