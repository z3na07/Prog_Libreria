import java.util.Scanner;
import java.util.ListResourceBundle;

/**
 * Classe con all'interno metodi gia pre-creati che potrebbero servire
 * @version beta
 * */
public class Utility
{

    /**
     * Metodo menu che visualizza a schermo un menu in modo che l'utente possa selezionare una scelta
     *
     * @param opzioni {@code Array} di tipo Stringa che contiene al suo interno i vari campi di selezione
     * @param scanner  scanner che legge i dati in input
     *
     * @return il metodo ritorna il valore numerico della scelta
     * */
    public static int Menu(String opzioni[], Scanner scanner) {// parametri formali
        int scelta;

        do {
            clrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " " + opzioni[i]);
            }
            scelta = (Integer.parseInt(scanner.nextLine()));
            //tastiera.nextLine();
            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1) || (scelta > opzioni.length - 1));
        //tastiera.nextLine();
        return scelta;
    }

    /**
     * impedisce di istanziare la classe:
     *          Se un costruttore è dichiarato come privato, non può essere
     *          invocato dall'esterno della classe,
     *          rendendo impossibile creare nuove istanze da altre classi.
     * */
    private Utility()
    {};



    //@throws InterruptedException Se il thread è interrotto durante l'esecuzione del comando. (nel caso inseriscilo nel commento sottostante)
    /**
     * Cancella lo schermo della console eseguendo il comando appropriato per il sistema operativo.
     *
     * Se il sistema operativo è Windows, verrà eseguito il comando "cls" per pulire la finestra del terminale.
     * Se si verifica un errore durante l'esecuzione del comando, l'eccezione verrà stampata nel log degli errori.
     *
     *
     */
    public static void clrScr()
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@throws InterruptedException Se il thread è interrotto durante l'esecuzione del comando.
    /**
     * metodo per apsettare
     *
     * @param attesa lasso di tempo che si aspetta
     *
     *
     *
     */
    public static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
