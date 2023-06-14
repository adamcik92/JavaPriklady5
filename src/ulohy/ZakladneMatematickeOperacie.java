package ulohy;

/*Vytvorte jednoduchý program, ktorého cieľom bude výpočet 5 základných matematických operácií a to sčítanie (+), odčítanie (-), násobenie (*) a delenie (/), modulo (%).
        Matematické operácie budú “narábať” s dvoma hodnotami, ktoré budú zadané v premenných, napr. cislo1  a cislo2.


        Pozn.: Nezabúdať na to, že sa môže jednať o desatinné čísla.
        Program nám zároveň vypíše takýto text:
        Výsledkom sčítania hodnôt 2 a 3 je 5.
        Výsledkom odčítania hodnôt 2 a 3 je -1.
        atď.
        Bonusová úloha: Vedeli by ste v prípade desatinných miest nahradiť desatinnú bodku za čiarku?
        Pomôcka:
//      Ako naformatovat cislo v SK formate na 2 desatinne miesta, pouzijeme %.2f
        System.out.printf("Desatinné číslo naformátované ako desatinná čiarka %.2f", desatinneCislo);
        Bonusová úloha č.2: Vstup hodnôt by mohol byť cez konzolu, čiže Scanner.*/

import java.util.Scanner;

public class ZakladneMatematickeOperacie {
    public static double sucet (double x, double y) {
        return x+y;

    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("zadaj prve cislo ");
        double cislo01 = sc.nextDouble();
        double cislo02 = sc.nextDouble();
        System.out.println("zadal si hodnoty " + cislo01+ " a " + cislo02);
        System.out.println("ich sucet je " + (cislo01+cislo02));
        System.out.println("ich rozdiel je " + (cislo01-cislo02));
        System.out.println("ich sucin je " + (cislo01*cislo02));
        System.out.println("ich podiel je " + (cislo01/cislo02));
        System.out.println("zvysok po deleni je " + (cislo01%cislo02));

        System.out.println(sucet(cislo01,cislo02));

        sc.close();


    }
}
