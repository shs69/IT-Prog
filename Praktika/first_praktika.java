package Praktika;

public class first_praktika {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println(qcd(48, 18));
        System.out.println(qcd(52, 8));
        System.out.println(qcd(259, 28));

        System.out.println(tickerSaler(70, 1500));
        System.out.println(tickerSaler(24, 950));
        System.out.println(tickerSaler(53, 1250));

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));

    }

    public static float convert(int gallons) {
        return gallons * 3.785f;
    }

    public static int fitCalc(int minutes, int inten) {
        return inten * minutes;
    }

    public static int containers(int box, int bag, int barrel) {
        return box * 20 + bag * 50 + barrel * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if ((x + y) > z & (y + z) > x & (z + x) > y) {
            if ((x == y) & (y == z)) {
                return "isosceles";
            } else if ((x == y) | (x == z) | (y == z)) {
                return "equilateral";
            } else {
                return "different-sided";
            }
        } else {
            return "not a triangle";
        }
    }

    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int howManyItems(int n, float w, float h) {
        return (int) (n / w / h / 2);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int qcd(int a, int b) {
        int c = 0;
        for (int i = b; i > 0; i--) {
            if ((a % i == 0) & (b % i == 0)) {
                c = i;
                break;
            }
        }
        return c;
    }

    public static int tickerSaler(int count, int stoim) {
        return (int) (count * stoim * 0.72);
    }

    public static int tables(int student, int table) {
        return table * 2 > student ? 0 : (student - table * 2) / 2 + (student - table * 2) % 2;
    }
}
