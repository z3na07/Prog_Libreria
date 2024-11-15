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

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Persona> catalogoPersone = new ArrayList<>();
        ArrayList<Libro> scaffale = new ArrayList<>();

        String[] opzioniLogin = {"MENU", "Registrati", "entrata cliente", "entrata commesso", "uscita"};
        String[] opzioniCom = {"BIBLIOTECA", "Inserisci Libro", "Visualizza scaffale", "", "", "uscita"};
        String[] opzioniUtente = {"MENU", "Acquista libro", "Cerca i tuoi libri", "Visualizza il catalogo", "Prendi in prestito", "uscita"};

        boolean fineCommesso = true;
        boolean fineLogin = true;
        boolean fine = true;

        int contPersone = 0;

        //creazione dei libri di defaul da metter di base nell'array list scaffale
        Libro petrarca = new Libro("1234", "Enaudi", "Il Canzoniere ", 14, false, "Petrarca");
        Libro boccaccio = new Libro("1738", "Giunti", "Il Decamerun", 15, false, "Boccaccio");
        Libro dante = new Libro("1890", "Mondadori", "La Divina Commedia", 50, false, "Dante");
        Libro leopardi = new Libro("900", "Feltrinelli", "L'infinito", 16, false, "Leopardi");

        scaffale.add(petrarca);
        scaffale.add(boccaccio);
        scaffale.add(dante);
        scaffale.add(leopardi);

        do {
            switch (Utility.Menu(opzioniLogin, keyboard))
            {
                case 1:
                    //registrazione utente

                    Persona nuovoUtente = new Persona();
                    nuovoUtente = Persona.registrati(keyboard);
                    catalogoPersone.add(nuovoUtente);

                    //ENTRATA NEL MENU DELL'UTENTE TRAMITE UNO SWITCH CASE
                    //switch case che permetterà l'utilizzo el softwere dopo il login DEL CLIENTE
                    do {
                        switch (Utility.Menu(opzioniUtente, keyboard))
                        {
                            case 1:
                                //acquista libro
                                if (scaffale.isEmpty())
                                {
                                    System.out.println("Non ci sono libri da acquistare");
                                } else
                                {

                                }
                                break;

                            case 2:
                                break;

                            case 3:
                                //visualizza il catalogo
                                Libro.visualizzaScaffale(scaffale);
                                break;

                            case 4:
                                break;

                            case 5:
                                //esci dallo switch case
                                fine = false;
                                break;

                        }
                    } while (fine);

                    //fineLogin = false;
                    break;

                //CASE 2 DELLO SWITCH PRINCIPALE
                case 2:
                    //accesso cliente
                    if (Persona.accedi(catalogoPersone, keyboard))
                    {
                        System.out.println("Accesso eseguito corretamente \n");
                        fineLogin = false;
                    } else
                    {
                        System.out.println("Nome utente o password errata");
                    }

                    //esci dallo switch login per andare allo switch del menù

                    break;

                case 3:
                    //accesso commesso
                    Commesso commesso = new Commesso();

                    System.out.println("Inserisci password");
                    String passwordRapida = keyboard.nextLine();

                    if(passwordRapida.equals(commesso.getPassword()))
                    {

                    }
                    break;

                case 4:
                    fineLogin = false;
                    //uscita completa dal programma
                    System.exit(0);
                    break;
            }
        } while (fineLogin);




        //switch case che permetterà l'utilizzo el softwere dopo il login DEL COMMESSO
        do {
            switch (Utility.Menu(opzioniCom, keyboard)) {
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


    }
}
