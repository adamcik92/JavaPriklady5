package ulohy;

import java.util.Scanner;
public class ZakladneMatematickeUlohyCezKonzolovyVstup {
    public static double scitaj(double cislo1, double cislo2) {
        return cislo1 + cislo2;

    }

    public static double modulo(double cislo1, double cislo2) {
        return cislo1 % cislo2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Inicializacia Scanner pre vstup z konzoly
        System.out.print("Zadaj PRVÉ číslo (a potvrď klávesom ENTER): ");
        double cislo1 = sc.nextDouble(); //Pre konkretny pouzivatelsky vstup(desatinne cislo) pouzijeme metodu nextDouble

        System.out.print("Zadaj DRUHÉ číslo (a potvrď klávesom ENTER): ");
        double cislo2 = sc.nextDouble(); //Pre konkretny pouzivatelsky vstup(desatinne cislo) pouzijeme metodu nextDouble
        double sum = scitaj(cislo1, cislo2);


        System.out.printf("Výsledok sčítania čísel %.2f a %.2f je: %.2f", cislo1, cislo2, sum);

        double modulo = modulo(cislo1, cislo2);
        System.out.printf("\nVýsledok modula(zvyšku po delení) čísel %.2f a %.2f je: %.2f", cislo1, cislo2, modulo);
    }
}
