package ulohy;
/*Úloha 1: Program na priradenie známky

        Vytvorte prostredníctvom vstupu z konzoly rozhodovací test, ktorý vypíše známku A, B alebo C podľa týchto kritérií:
        Ak je percento nad 90, tak vypíše známku A
        Ak je percento nad 75, tak vypíše známku B
        Ak je percento nad 65, tak vypíše známku C
        Použite metódu pre rozhodovanie.*/


import java.util.Scanner;

public class PriradenieZnamky {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int percenta = 0;
        int sum = 0;
        int priemer = 0;
        int pocet =0;
        while(percenta >=0) {

            System.out.println("Zadaj percentá(HINT: pri zadaní záporného čísla sa program ukončí) : ");
            percenta = sc.nextInt(); // TODO Pri pouzivatelskom vstupe rovno zobrazit aj %
            if(percenta>= 0) {
                //sum = sum + percenta;//Pripočitavame percenta k povodnemu sumáru,čiže sum
                sum += percenta;//Pripočitavame percenta k povodnemu sumáru,čiže sum
                //pocet = pocet+1
                pocet++;//Obsah premennej pocet zvysime o 1
            }
            //&& použijeme pri podmienkach ktoré musia platiť zároven (AND)
            //||(pravý alt+W) použijeme pri podmienkach pri ktorých stačí,ked platí jdna z nich(OR)
            if (percenta > 90)
                System.out.println("A");
            else if (percenta < 90 && percenta >= 75)
                System.out.println("B");
            else if (percenta >=65  && percenta < 75)
                System.out.println("C");
            else if (percenta >= 0 && percenta < 65)
                System.out.println("Neuspel");
                //break;// Stopne nekonečný cyklus
            else
            System.out.println("Neočakávaný vstup");

        }

        System.out.println("Priemer známok je: " + (sum/pocet));
        System.out.println("Koniec programu");
    }
}