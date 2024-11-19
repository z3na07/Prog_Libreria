import utility.Tools;

import java.util.Random;
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
        Random random  = new Random();

        ArrayList<Persona> catalogoPersone = new ArrayList<>();
        ArrayList<Libro> scaffale = new ArrayList<>();


        String[] opzioniLogin = {"MENU", "Registrati", "entrata cliente", "entrata commesso", "uscita"};
        String[] opzioniCom = {"BIBLIOTECA", "Inserisci Libro", "Visualizza scaffale", "Rimuovi Libro", "Visualizza saldo totale", "uscita"};
        String[] opzioniUtente = {"MENU", "Acquista libro", "Visualizza carrello", "Visualizza il catalogo","Visualizza dati utente", "uscita"};

        //dichiarazioni boolean
        boolean fineCommesso = true;
        boolean fineLogin = true;
        boolean fine = true;

        //dichiarazione variabili intere
        int contPersone = 0;
        int indice = 0;
        String tesseraFake;


        //creazione dei libri di defaul da metter di base nell'array list scaffale
        Libro petrarca = new Libro("1234", "Enaudi", "Il Canzoniere ", 14, false, "Petrarca");
        Libro boccaccio = new Libro("1738", "Giunti", "Il Decameron", 15, false, "Boccaccio");
        Libro dante = new Libro("1890", "Mondadori", "La Divina Commedia", 50, false, "Dante");
        Libro manzoni = new Libro("900", "Feltrinelli", "I Promessi Sposi", 16, false, "Manzoni");

        scaffale.add(petrarca);
        scaffale.add(boccaccio);
        scaffale.add(dante);
        scaffale.add(manzoni);

        do
        {
            switch (Tools.Menu(opzioniLogin, keyboard))
            {
                case 1:
                    //registrazione utente

                    Persona nuovoUtente = new Persona();
                    nuovoUtente = Persona.registrati(keyboard);
                    catalogoPersone.add(nuovoUtente);

                    //ENTRATA NEL MENU DELL'UTENTE TRAMITE UNO SWITCH CASE
                    //switch case che permetterà l'utilizzo el softwere dopo il login DEL CLIENTE
                    do {
                        switch (Tools.Menu(opzioniUtente, keyboard))
                        {
                            case 1:
                                //acquista libro
                                if (scaffale.isEmpty())
                                {
                                    System.out.println("Non ci sono libri da acquistare");
                                } else
                                {
                                    if(Libro.ricerca(scaffale, keyboard, indice) == -1)
                                    {
                                        System.out.println("Il libro non è presente nel catalogo ");
                                    }
                                    else
                                    {
                                        System.out.println("Il prezzo da pagare è: "+scaffale.get(indice).getPrezzo()+" euro");
                                        Tools.Wait(3);
                                        System.out.println("Il libro verrà messo nel carrello ");
                                        scaffale.get(indice).setVenduto(true);
                                    }
                                }
                                break;

                            case 2:

                                Persona.visualizzaCarrello(scaffale, keyboard, catalogoPersone);

                                break;

                            case 3:
                                //visualizza il catalogo
                                Libro.visualizzaScaffale(scaffale);
                                break;

                            case 4:
                                //visualizza dati dell'utente
                                Persona.visualizzaDatiUtente(catalogoPersone, keyboard);

                                break;

                            case 5:

                                //esci dallo switch case
                                fine = false;
                                break;
                        }
                    } while (fine);

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
                        //CASEW ENORME
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
            switch (Tools.Menu(opzioniCom, keyboard)) {
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
                    Libro.rimuoviLibro(scaffale, keyboard);
                    break;

                case 4:
                    Commesso.saldoTotale(scaffale);
                    break;

                case 6:
                    //esci dallo switch case
                    fineCommesso = false;
                    break;
            }
        } while (fineCommesso);


        /*
        * import java.util.Random;

public class RandomStringGenerator {
    public static String generateRandomString(int length) {

        //altre stringhe possibili: ABCDEFGHIJKLMNOPQRSTUVWXYZ
        // Definisci l'insieme di caratteri
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        // Genera una stringa casuale
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}*/



    }
}