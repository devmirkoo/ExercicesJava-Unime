import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero da 1 a 99: ");
        Integer number = scanner.nextInt();

        System.out.printf("Il numero inserito é %d", number);
    }
}