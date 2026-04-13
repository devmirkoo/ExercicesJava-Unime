/*
* Esercizio 4: Calcolo Media con Sentinella (Ciclo While).
*
Obiettivo: Usare un ciclo la cui fine è determinata dall'utente.
Come fare: Inizializza tre variabili: somma (a 0), conteggio (a 0) e input.
* Crea un ciclo while che continui finché input è maggiore o uguale a zero (input >= 0).
* All'interno del ciclo, chiedi all'utente di inserire un voto (un numero negativo farà da "sentinella" per terminare il ciclo).
* Se il numero è positivo, aggiungilo a somma e incrementa conteggio.
* Finito il ciclo, dividi la somma per il conteggio e stampa la media.
* */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        int somm = 0; int count = 0;
        Integer input = 1;

        while (input >= 0) {
            System.out.println("Inserisci un valore:" );
            Scanner scanner = new Scanner(System.in);

            input = scanner.nextInt();

            if (input >= 0) {
                somm += input;
                count++;
                System.out.println("Valore sommato: " + input);
            } else {
                break;
            }
        }

        System.out.printf("Risultati:\nTotale Somma: %d\n Stato Contatore: %d\nMedia: %.2f", somm, count, (float) somm / count);
    }
}