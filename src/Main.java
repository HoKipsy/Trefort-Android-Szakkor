public class Main {


    /**
     * Irjuk ki, hogy n paros-e vagy paratlan
     * Hint: a 2-vel oszthato szamok parosak, a tobbi nem (es van a nulla)
     * @param n
     */
    static void parity(int n){

    }

    /**
     * Emeljuk tagonkent negyzetre az array elemeit es irjuk ki
     * Hint: array.length
     * @param array
     */
    static void squareArray(int[] array) {

        // TODO: ciklus feltetel
//        for( ... ){
//
//            array[i] = ... ;    // TODO: negyzetre emeles
//            System.out.println(array[i]);  // kiiras
//        }
    }

    /**
     * Irjuk ki n szam szamjegyeinek osszeget
     * Hint: modulo (%) es while ciklus
     * @param n
     */
    static void digits(int n) {

    }

    /**
     * Kiirja az osszes prim szamot 1 es n kozott
     * Hint: csak 1 es onmaga az osztoja
     * @param n
     */
    static void prim(int n) {

    }

    public static void main(String[] args) {

        parity(2);
        parity(3);
        parity(5);

        squareArray(new int[]{1, 2, 3, 4, 5, 6, 7});

        digits(123456);

        prim(1000);
    }

}
