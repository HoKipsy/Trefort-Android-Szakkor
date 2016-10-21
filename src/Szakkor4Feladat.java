import java.util.Arrays;

/**
 * Created by dawars on 10/21/16.
 */
public class Szakkor4Feladat {
    /**
     * @param m  összeg, amit ki akarunk fizetni
     * @param c  milyen értékű pénzeink vannak (tömb)         <-- bemenet, csak olvasni szabad
     * @param db a c[i] értékű pénzből db[i] darabunk kell   <-- kimenet, bele kell írni
     * @return minimálisan hány érme kell a felváltáshoz
     */
    static int felvalt(int m, int[] c, int[] db) {
        int eredmeny = 0;       // ide kell menteni, hogy minimálisan hány érme szükséges

        // TODO: 2. feladat megoldása


        return eredmeny;
    }

    public static void main(String[] args) {

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
