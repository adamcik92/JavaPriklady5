/*Vypíšte do konzoly nasledujúci text:

        Študent Jozef Mrkvička sa narodil 03.04.2000, z maturitnej skúšky má známku 1.5 a od septembra 2022 nastúpi do nového zamestnania ako Java programátor.
        V Bratislave dňa 18.06.2022
        Poznámka: Dátum narodenia, známku a rok + aktuálny dátum nastavte tak, aby sa dali meniť v zdrojovom kóde (t.j. cez premenné).*/

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PrikladNaPracusPremennymi {
    public static void main(String[] args) {


        String menoStudenta = "Jozef Mrkvička";
        String datumN =  "3.4.2000";
        double znamka = 1.5;
        String datumA = "1.7.2023";
        Date datum = new Date();
        SimpleDateFormat formatDatumu = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println("Študent" + menoStudenta +  " sa narodil " + datumN + " a z maturitnej skúšky má známku " + znamka + " a od " + datumA + " nastúpi do nového zamestnania ako Java programátor.");
        System.out.println("V Bratislave dňa " + formatDatumu.format(datum));

        LocalDate localDate = LocalDate.of( 2014 , Month.FEBRUARY , 11 ); //Naplnime premennu localDate konkretnym dátumom
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

        System.out.println("Vypisujem localDate: " + localDate.format(formatter));

        System.out.printf("Študent má známku %.1f", znamka);



    }
}
