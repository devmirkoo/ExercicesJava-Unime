/*
* Esercizio 5: Simulazione Popolazione (Ciclo For).
Obiettivo: Ripetere un'azione per un numero noto di volte.
Come fare: Chiedi all'utente di inserire un numero iniziale di insetti e un tasso di crescita settimanale (es. raddoppio).
* Crea un ciclo for che simuli l'andamento per 10 settimane.
* L'intestazione del ciclo sarà for (int i = 1; i <= 10; i++).
* Ad ogni iterazione, aggiorna il numero di insetti e usa System.out.println per mostrare la settimana e la popolazione corrente.
* */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        System.out.println("Inserisci il numero di insetti, e il tasso di crescita settimanale.");
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();
        Integer raddoppio = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            n *= raddoppio;
            System.out.printf("Settimana %d\nNumero attuale insetti: %d\n\n", i, n);
        }

        System.out.printf("I tuoi insetti sono diventati in totale: " + n);
    }
}
