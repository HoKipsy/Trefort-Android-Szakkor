public class Szakkor3Megoldas {


    /**
     * Irjuk ki, hogy n paros-e vagy paratlan
     * Hint: a 2-vel oszthato szamok parosak, a tobbi nem (es van a nulla)
     *
     * @param n
     */
    static void parity(int n) {
        if (n % 2 == 0) // ha a 2-es osztási maradék 0
            System.out.println(n + " is even"); // páros
        else
            System.out.println(n + " is odd"); // páratlan
    }

    /**
     * Emeljuk tagonkent negyzetre az array elemeit es irjuk ki
     * Hint: array.length
     *
     * @param array
     */
    static void squareArray(int[] array) {

        for (int i = 0; i < array.length; i++) {    // bejárjuk a tömböt

            array[i] = array[i] * array[i];         // A négyzetre emelést Javaban az önmagával való szorzással csináljuk
            System.out.println(array[i]);
        }
    }

    /**
     * Irjuk ki n szam szamjegyeinek osszeget
     * Hint: modulo (%) es while ciklus
     *
     * @param n
     */
    static void digits(int n) {

        //while ciklussal
        int num = n;
        while (num > 0) {        // amíg a num nagyobb, mint 0
            System.out.println(num % 10);       // a 10-es maradék megadja az utolsó számjegyet
            num /= 10;          // osszuk le 10-el (eltávolítja az utolsó számjegyet)
        }

        // for ciklussal
        for (int number = n; number > 0; number /= 10) {     // a number /= 10 a number = number / 10 rövidítése
            System.out.println(number % 10);                // a 10-es maradék megadja az utolsó számjegyet
        }
    }

    /**
     * Kiirja az osszes prim szamot 1 es n kozott
     * Hint: csak 1 es onmaga az osztoja
     *
     * @param n
     */
    static void prim(int n) {

        boolean isPrime = true;     // igaz, ha az éppen vizsgált szám prím

        System.out.println("Prím: " + 2);      // ezt tudjuk, easy

        for (int number = 3; number < n; number += 2) { // végigmegyünk a páratlan számokon n-ig

            for (int i = 3; i <= Math.sqrt(number); i++) {// a szám osztóit csak a szám négyzetgyökéig (sqrt) kell vizsgálni

                if (number % i == 0) {              // ha n maradék nélkül osztható i-vel

                    isPrime = false;                // nem prím
                    break;  // tovább már nem kell ellenőrizni, mert már nem lehet prím
                }
            }
            // megnéztük az "összes" osztót
            if(isPrime)
                System.out.println("Prím: " + number);
            isPrime = true;     // visszaállítjuk a következő számra
        }
    }

    public static void main(String[] args) {
        System.out.println("----- 1. feladat -----");
        parity(2);
        parity(3);
        parity(5);

        System.out.println("----- 2. feladat -----");
        squareArray(new int[]{1, 2, 3, 4, 5, 6, 7});

        System.out.println("----- 3. feladat -----");
        digits(123456);

        System.out.println("----- 4. feladat -----");
        prim(1000);
    }

}
