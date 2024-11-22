import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Utility che fornisce i metodi menù, wait e clair screen per il comodo utilizzo del programma
 * @author Martino (Hallo5685)
 * @version 1
 * */
public class Utility
{
    /**
     * Mostra un menu di opzioni all'utente e restituisce la scelta effettuata.
     * Il metodo gestisce errori di input, come inserimenti non numerici o opzioni fuori intervallo,
     * e richiede all'utente di reinserire una scelta valida.
     *
     * @param opzioni  Un array di stringhe che rappresenta le opzioni del menu.
     *                 La prima posizione (indice 0) è utilizzata come titolo del menu.
     * @param scanner  Un oggetto {@link Scanner} utilizzato per leggere l'input dell'utente.
     *
     * @return Un intero che rappresenta la scelta effettuata dall'utente, compresa tra 1 e {@code opzioni.length - 1}.
     *
     * @throws NumberFormatException  Se l'input non è convertibile in un numero intero.
     * @throws InputMismatchException Se il tipo di input non è valido.
     */
    public static int Menu(String opzioni[], Scanner scanner)
    {
        int scelta = -1; // Inizializziamo con un valore di default non valido
        do
        {
            try
            {
                clrScr(); // Pulisce lo schermo
                System.out.println("------------------");
                System.out.println(opzioni[0]);
                System.out.println("------------------");

                for (int i = 1; i < opzioni.length; i++)
                {
                    System.out.println("[" + i + "] " + opzioni[i]);
                }

                scelta = Integer.parseInt(scanner.nextLine()); // Converte l'input in intero

                if (scelta < 1 || scelta > opzioni.length - 1) {
                    System.out.println("Opzione Sbagliata. Riprova.");
                    Wait(500);
                }
            } catch (NumberFormatException e)
            {
                System.out.println("Errore: Input non valido. Inserisci un numero.");
                Wait(500);

            } catch (InputMismatchException e)
            {
                System.out.println("Errore: Tipo di input non valido. Riprova.");
                scanner.nextLine();
                Wait(500);
            }

        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }


    //Il costruttore ha lo stessp nome della classe
    private Utility()
    {}; /*impedisce di istanziare la classe:
         Se un costruttore è dichiarato come privato, non può essere
         invocato dall'esterno della classe,
         rendendo impossibile creare nuove istanze da altre classi. */
    public static void clrScr()
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait(int attesa)
    {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
