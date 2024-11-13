import java.util.Scanner;
//import java.time.LocalDate;
import java.util.ArrayList;

/**
 * E' il punto di ingresso principale dell'applicazione.
 * Contiene il metodo "main" che viene eseguito all'avvio del programma.
 *
 * @author Martino (Hallo5685), Leonardo (z3na07), Mattia (programmatoresperto)
 * @version beta
 */

public class Main
{
    /**
     * Metodo principale dell'applicazione che viene eseguito ogni inzio programma
     *
     * @param args argomenti da riga di comando, che vengono passati all'applicazione al momento dell'esecuzione.
     *
     * @version beta
     * */

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Persona> catalogoPersone = new ArrayList<>();
        ArrayList<Libro> scaffale = new ArrayList<>();

        String[] opzioniLogin = {"MENU", "Registrati", "entrata cliente", "entrata commesso"};
        String[] opzioniCom = {"BIBLIOTECA", "Inserisci Libro", "Visualizza scaffale", "", "", "USCITA"};
        String[] opzioniUtente = {"MENU", "Acquista libro", "Cerca i tuoi libri", "Visualizza il catalogo", "Prendi in prestito"};

        boolean fineCommesso = true;
        boolean fineLogin = true;
        boolean fine = true;

        int contPersone = 0;

        //creazione dei libri di defaul da metter di base nell'array list scaffale
        Libro petrarca = new Libro("1234", "Enaudi","Il Canzoniere ",120, false, "Petrarca");
        Libro boccaccio = new Libro();
        Libro dante = new Libro();
        Libro leopardi = new Libro();

        do
        {
            switch (Utility.Menu(opzioniLogin, keyboard))
            {
                case 1:
                    //registrazione

                    Persona nuovoUtente = new Persona();
                    nuovoUtente = Persona.registrati(keyboard);
                    catalogoPersone.add(nuovoUtente);

                    fineLogin = false;
                    break;

                case 2:
                    //accesso cliente
                    if (Persona.accedi(catalogoPersone, keyboard)) {
                        System.out.println("Accesso eseguito corretamente \n");
                    } else {
                        System.out.println("Nome utente o password errata");
                    }

                    //esci dallo switch login per andare allo switch del menù
                    fineLogin = false;
                    break;

                case 3:
                    //accesso commesso
                    System.out.println("Inserisci password");

                    break;

                default:
                    fineLogin = false;
                    break;
            }
        } while (fineLogin);


        //switch case che permetterà l'utilizzo el softwere dopo il login DEL COMMESSO
        do
        {
            switch (Utility.Menu(opzioniCom, keyboard))
            {
                case 1:
                    //inserimento libro

                    Libro libroMomentaneo = new Libro();
                    libroMomentaneo = Libro.inserisciLibro(keyboard);
                    scaffale.add(libroMomentaneo);

                    break;

                case 2:
                    Libro.visualizzaScaffale(scaffale);
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 6:
                    //esci dallo switch case
                    fineCommesso = false;
                    break;
            }
        } while (fineCommesso);


        //switch case che permetterà l'utilizzo el softwere dopo il login DEL CLIENTE
        do
        {
            switch (Utility.Menu(opzioniUtente, keyboard))
            {
                case 1:
                    if (scaffale.isEmpty())
                    {
                        System.out.println("Non ci sono libri da acquistare");
                    } else
                    {

                    }
                    break;
                case 2:
                    //visualizza il catalogo
                    Libro.visualizzaScaffale(scaffale);
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 6:
                    //esci dallo switch case
                    fine = false;
                    break;

            }

        } while (fine);
    }
}
