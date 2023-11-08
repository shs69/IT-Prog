package Labs.Lab4_Exceptions;

public class ArrayAverage {
    public static void main(String[] args) {
        try {
            System.out.println(arrayAverage(new Object[]{new int[]{}, 3, 4, 4, 5}));
        } catch(ArrayStoreException e) {
            System.out.println("Вы ввели не число");
        } catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать данный тип к целочисленному типу");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс массива выходит за пределы");
        }

        try {
            System.out.println(arrayAverage(new Object[]{1, 3, 4, 4, 5}, 10));
        } catch(ArrayStoreException e) {
            System.out.println("Вы ввели не число");
        } catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать данный тип к целочисленному типу");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс массива выходит за пределы");
        }

        try {
            System.out.println(arrayAverage(new Object[]{"new int[]{}", 3, 4, 4, 5}));
        } catch(ArrayStoreException e) {
            System.out.println("Вы ввели не число");
        } catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать данный тип к целочисленному типу");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс массива выходит за пределы");
        }
    }


    public static float arrayAverage(Object[] massive) throws ArrayStoreException, NumberFormatException, ArrayIndexOutOfBoundsException{
        float sum = 0;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Integer) {
                sum += (int) massive[i];
            } else if (massive[i] instanceof String) {
                    sum += Integer.parseInt((String) massive[i]);
            } else {
                throw new ArrayStoreException();
            }

        }
        return sum / massive.length;
    }

    public static float arrayAverage(Object[] massive, int len) throws ArrayStoreException, NumberFormatException, ArrayIndexOutOfBoundsException{
        float sum = 0;
        for (int i = 0; i < len; i++) {
            if (massive[i] instanceof Integer) {
                sum += (int) massive[i];
            } else if (massive[i] instanceof String) {
                sum += Integer.parseInt((String) massive[i]);
            } else {
                throw new ArrayStoreException();
            }

        }
        return sum / massive.length;
    }
}
