import java.util.Arrays;

/**
 * Created by dawars on 10/21/16.
 */
public class Szakkor4Megoldas {

    /**
     * Szamoljuk ki az array elemeinek atlagat
     *
     * @param array tomb egesz szamokkal
     * @return a tomb elemeinek osszege
     */
    static double average(int[] array) {
        double avg = 0;

        for (int i = 0; i < array.length; i++) {
            avg += array[i];
        }
        // Compute average in double. Beware that int/int produces int.
        return avg / array.length;
    }

    /**
     * Adjuk ossze a 1 + 1/4 + 1/9 + ... 1/n^2 szamokat addig, amig az utolso tag nagyobb, mint eps
     *
     * @param eps
     * @return
     */
    static double harmonicSum(double eps) {
        double sum = 0;

        for (int i = 1; eps < 1.0f / (i * i); i++) {
            sum += 1.0f / (i * i);
        }

        return sum;
    }


    /**
     * TODO: Ez egy bonyolult, gondolkodos feladat
     *
     * @param m  összeg, amit ki akarunk fizetni
     * @param c  milyen értékű pénzeink vannak (tömb)         <-- bemenet, csak olvasni szabad
     * @param db a c[i] értékű pénzből db[i] darabunk kell   <-- kimenet, bele kell írni
     * @return minimálisan hány érme kell a felváltáshoz
     */
    static int felvalt(int m, int[] c, int[] db) {
        int eredmeny = 0;       // ide kell menteni, hogy minimálisan hány érme szükséges

        // greedy / moho megoldas, nem ad optimalis eredmenyt
        int sum = m;

        for (int i = 0; i < c.length; i++) {
            db[i] = sum / c[i];
            eredmeny += db[i];

            sum -= c[i] * db[i];

        }

        return eredmeny;
    }

    public static void main(String[] args) {
        System.out.println("----- 1. feladat -----");

        System.out.println("Average: " + average(new int[]{1, 1, 3, 5, 6, 8, 9, 9, 15}));


        System.out.println("----- 2. feladat -----");
        System.out.println(harmonicSum(1e-5));


        System.out.println("----- 3. feladat -----");
        int[] c = new int[]{25, 20, 5, 1};  // teszt adat
        int[] db = new int[c.length];       // üres tömb a megoldásnak
        int n = felvalt(42, c, db);         // a függvényhívás után ide kerül a "return" értéke


        // eredmény ellenőrzése

        int n_ell = 4;
        int[] db_ell = new int[]{0, 2, 0, 2}; // ellenőrző megoldás

        if (n == n_ell && Arrays.equals(db, db_ell))
            System.out.println("Jó megoldás!");
        else {
            System.out.println("Hibás eredmény!");
            System.out.println("A minimális érmék várt értéke: " + n_ell + " a tiéd viszont: " + n);
            System.out.print("A darabszámok várt értéke: [ ");
            for (int i : db_ell) System.out.print(i + " ");
            System.out.print("] a tiéd viszont: [ ");
            for (int i : db) System.out.print(i + " ");
            System.out.println("]");
        }
    }
}
