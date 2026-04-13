/*
* Esercizio 3 (Il costrutto Switch):
* Scrivi un programma che utilizzi un'enumerazione (es. MovieRating con valori EXCELLENT, AVERAGE, BAD).
* Usa uno switch per stampare un commento specifico in base alla categoria scelta (es. "Devi vedere questo film!" se eccellente)
* */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Valuta il film (Scrivi: EXCELLENT, AVERAGE, o BAD): ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next().toUpperCase();

            MovieRating input = MovieRating.valueOf(userInput);
            switch (input) {
                case EXCELLENT:
                    System.out.println("Hai valutato questo film ECCELLENTE");
                    break;
                case AVERAGE:
                    System.out.println("Hai valutato questo film NELLA MEDIA");
                    break;
                case BAD:
                    System.out.println("Hai valutato questo film BRUTTO");
                    break;
                default:
                    System.out.println("Valutazione inesistente");
                    break;
            }

        scanner.close();
    }
}