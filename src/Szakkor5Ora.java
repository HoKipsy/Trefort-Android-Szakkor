/**
 * Created by dawars on 2016.10.28..
 */
public class Szakkor5Ora {

    public static void main(String[] args) {
        System.out.println("Debugging");

        int visszateresi_ertek;
        visszateresi_ertek = fuggvenyNev(1, 2);
        System.out.println(visszateresi_ertek);

        System.out.println(hatvany(2, 3));

        System.out.println(discriminant(1, -4, 4));

        System.out.println(factorial(6));
    }

    /**
     * Egyszerű függvény, ami összead két számot
     *
     * @param a - első összeadási tényező
     * @param b - második összeadási tényező
     * @return összeg, a + b
     */
    static int fuggvenyNev(int a, int b) {
        int result = a + b;
        return result;
    }

    /**
     * Hatványozó függvény
     *
     * @param base - hatványalap
     * @param n    - hatványkitevő
     * @return base ^ n = base * base ... * base
     */
    static double hatvany(double base, int n) {
        double res = 1;

        for (int i = 0; i < n; i++) {

            res = res * base;       // egyszerűsítve: res *= base;

        }

        return res;
    }

    /**
     * Diszkrimináns számolása a*x^2+b*x+c = 0 másodfokú egyenletben
     *
     * @param a x^2 együtthatója
     * @param b x együtthatója
     * @param c konstans
     * @return diszkrimináns = b^2 - 4ac
     */
    static double discriminant(double a, double b, double c) {
        return hatvany(b, 2) - 4 * a * c; // az eredményt íegyből a return-ba írhatjuk, nem kell ideiglenes változó
    }

    /**
     * Faktoriális - rekurzió megismerése
     * n! = n * (n-1) * (n-2) * ... * 3 * 2 * 1
     * n! = n * (n-1)!
     * 1! = 1
     **/
    static int factorial(int n) {
        // System.out.println(n); // for debugging
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}