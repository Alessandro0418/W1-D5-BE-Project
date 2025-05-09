package Project;

import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Creazione elementi
        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci tipo elemento (1=Immagine, 2=Audio, 3=Video):");
            int tipo = Integer.parseInt(scanner.nextLine());

            if (tipo == 0) {
                break;
            }

            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();

            switch (tipo) {
                case 1 -> {
                    System.out.print("Luminosità: ");
                    int luminosita = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Immagine(titolo, luminosita);
                }
                case 2 -> {
                    System.out.print("Durata: ");
                    int durata = Integer.parseInt(scanner.nextLine());
                    System.out.print("Volume: ");
                    int volume = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new RegistrazioneAudio(titolo, durata, volume);
                }
                case 3 -> {
                    System.out.print("Durata: ");
                    int durata = Integer.parseInt(scanner.nextLine());
                    System.out.print("Volume: ");
                    int volume = Integer.parseInt(scanner.nextLine());
                    System.out.print("Luminosità: ");
                    int luminosita = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Video(titolo, durata, volume, luminosita);
                }
                default -> {
                    System.out.println("Tipo non valido, riprova.");
                    i--;
                }
            }
        }

        // Esecuzione
        int scelta;
        do {
            System.out.print("\nScegli quale elemento eseguire (1-5) o 0 per uscire: ");
            scelta = Integer.parseInt(scanner.nextLine());

            if (scelta > 0 && scelta <= 5) {
                ElementoMultimediale el = elementi[scelta - 1];
                if (el instanceof Immagine img) {
                    img.show();
                } else if (el instanceof Riproducibile ripr) {
                    ripr.play();
                }
            }
        } while (scelta != 0);

        System.out.println("Chiusura Player.");
        scanner.close();
    }
}
