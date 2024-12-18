import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
//import java.time.LocalDate;
import java.util.ArrayList;

/**
 * E' il punto di ingresso principale dell'applicazione.
 * Contiene il metodo "main" che viene eseguito all'avvio del programma.
 *
 * @author Martino (Hallo5685), Leonardo (z3na07), Mattia (programmatoresperto)
 * @version 1
 */

public class Main
{
    /**
     * Metodo principale dell'applicazione che viene eseguito ogni inzio programma
     *
     * @param args argomenti da riga di comando, che vengono passati all'applicazione al momento dell'esecuzione.
     *
     * */

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        ArrayList<Persona> catalogoPersone = new ArrayList<>();
        ArrayList<Libro> scaffale = new ArrayList<>();


        String[] opzioniLogin = {"MENU", "Registrati", "entrata cliente", "entrata commesso", "uscita"};
        String[] opzioniCom = {"BIBLIOTECA", "Inserisci Libro", "Visualizza scaffale", "Rimuovi Libro", "Visualizza saldo totale", "cerca libro", "uscita"};
        String[] opzioniUtente = {"MENU", "Acquista libro", "Visualizza carrello", "Visualizza il catalogo","Visualizza dati utente","Procedi al pagamento", "uscita"};

        //dichiarazioni boolean
        boolean fineCommesso;
        boolean fineLogin;
        boolean fine = true;
        boolean carrrelllo = false;

        //dichiarazione variabili intere
        int indice = 0;
        int indiceVolatile = 0;
        double contoTot = 0;


        //creazione dei libri di defaul da metter di base nell'array list scaffale
        Libro petrarca = new Libro("1234", "Enaudi", "Il Canzoniere ", 14, false, "Petrarca");
        Libro boccaccio = new Libro("1738", "Giunti", "Il Decameron", 15, false, "Boccaccio");
        Libro dante = new Libro("1890", "Zanichelli", "La Divina Commedia", 50, false, "Dante");
        Libro manzoni = new Libro("900", "Feltrinelli", "I Promessi Sposi", 16, false, "Manzoni");
        Libro bulgakov = new Libro("1500", "Trecani","Il Maestro e Margherita",12, false, "Bulgakov");
        Libro riordan = new Libro("456", "Mondadori", "Percy Jackson e gli dei dell'olimpo", 11, false, "Riordan");

        scaffale.add(petrarca);
        scaffale.add(boccaccio);
        scaffale.add(dante);
        scaffale.add(manzoni);
        scaffale.add(bulgakov);
        scaffale.add(riordan);

        do
        {
            fineLogin = true;
            switch (Utility.Menu(opzioniLogin, keyboard))
            {
                case 1:
                    //registrazione utente

                    Persona nuovoUtente;
                    nuovoUtente = Persona.registrati(keyboard);
                    nuovoUtente.setIndicePosizione(indiceVolatile);
                    catalogoPersone.add(nuovoUtente);

                    //ENTRATA NEL MENU DELL'UTENTE TRAMITE UNO SWITCH CASE
                    //switch case che permetterà l'utilizzo el softwere dopo il login DEL CLIENTE
                    do {
                        fine = true;

                        switch (Utility.Menu(opzioniUtente, keyboard))
                        {
                            case 1:
                                //acquista libro
                                if (scaffale.isEmpty())
                                {
                                    System.out.println("Non ci sono libri da acquistare");
                                } else
                                {
                                    int risulatatoRicerca = Libro.ricerca(scaffale, keyboard, indice);

                                    if(risulatatoRicerca == -1)
                                    {
                                        System.out.println("Il libro non è presente nel catalogo ");
                                    }
                                    else
                                    {
                                        System.out.println("Il prezzo da pagare è: "+scaffale.get(risulatatoRicerca).getPrezzo()+" euro");
                                        Utility.Wait(3);

                                        System.out.println("Il libro verrà messo nel carrello ");
                                        scaffale.get(risulatatoRicerca).setVenduto(true);

                                        //imposta l'attributo indiceDiPersonaCheHaComprato al numero corrispondente dato da indiceVolatile
                                        scaffale.get(risulatatoRicerca).setIndiceDiPersonaCheHaConprato(indiceVolatile);
                                        carrrelllo = true;

                                        contoTot = scaffale.get(risulatatoRicerca).getPrezzo();
                                        catalogoPersone.get(indiceVolatile).setContoDaPagare(contoTot); //+= scaffale.get(risulatatoRicerca).getPrezzo();

                                    }
                                }
                                break;

                            case 2:
                                //visualizza il carrello
                                Persona.visualizzaCarrello(scaffale, keyboard, catalogoPersone, carrrelllo);

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

                                if(contoTot == 0)
                                {
                                    System.out.println("non hai nulla da pagare");
                                }else
                                {
                                    if(Persona.pagamento(contoTot, keyboard,catalogoPersone, indiceVolatile) == 0)
                                    {
                                        catalogoPersone.get(indiceVolatile).setContoDaPagare(0);
                                    }
                                }
                                break;

                            case 6:

                                //esci dallo switch case
                                fine = false;
                                break;
                        }
                    } while (fine);

                    //incremento della posizione da salvare negli attributi di libro e persona
                    indiceVolatile++;

                    //break del primo case principale
                    break;

                //CASE 2 DELLO SWITCH PRINCIPALE
                case 2:
                    //accesso cliente, controllare case 4 dello switch perchè esce dal menu
                    if (Persona.accedi(catalogoPersone, keyboard))
                    {
                        System.out.println("Accesso eseguito corretamente \n");
                        //fineLogin = false;

                        do {
                            fine = true;

                            switch (Utility.Menu(opzioniUtente, keyboard))
                            {
                                case 1:
                                    //acquista libro
                                    if (scaffale.isEmpty())
                                    {
                                        System.out.println("Non ci sono libri da acquistare");
                                    } else
                                    {
                                        int risulatatoRicerca = Libro.ricerca(scaffale, keyboard, indice);

                                        if(risulatatoRicerca == -1)
                                        {
                                            System.out.println("Il libro non è presente nel catalogo ");
                                        }
                                        else
                                        {
                                            System.out.println("Il prezzo da pagare è: "+scaffale.get(risulatatoRicerca).getPrezzo()+" euro");
                                            Utility.Wait(3);

                                            System.out.println("Il libro verrà messo nel carrello ");
                                            scaffale.get(risulatatoRicerca).setVenduto(true);

                                            //imposta l'attributo indiceDiPersonaCheHaComprato al numero corrispondente dato da indiceVolatile
                                            scaffale.get(risulatatoRicerca).setIndiceDiPersonaCheHaConprato(indiceVolatile);
                                            carrrelllo = true;

                                            contoTot = scaffale.get(risulatatoRicerca).getPrezzo();
                                            catalogoPersone.get(indiceVolatile).setContoDaPagare(contoTot); //+= scaffale.get(risulatatoRicerca).getPrezzo();

                                        }
                                    }
                                    break;

                                case 2:
                                    //visualizza il carrello
                                    Persona.visualizzaCarrello(scaffale, keyboard, catalogoPersone, carrrelllo);

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

                                    if(contoTot == 0)
                                    {
                                        System.out.println("non hai nulla da pagare");
                                    }else
                                    {
                                        if(Persona.pagamento(contoTot, keyboard,catalogoPersone, indiceVolatile) == 0)
                                        {
                                            catalogoPersone.get(indiceVolatile).setContoDaPagare(0);
                                        }
                                    }
                                    break;

                                case 6:

                                    //esci dallo switch case
                                    fine = false;
                                    break;
                            }
                        } while (fine);
                    } else
                    {
                        System.out.println("Nome utente o password errata");
                    }
                    break;

                case 3:
                    //ACCESSO COMMESSO
                    Commesso commesso = new Commesso();

                    System.out.println("Inserisci password");
                    String passwordRapida = keyboard.nextLine();

                    if(passwordRapida.equals(commesso.getPassword()))
                    {
                        //switch case che permetterà l'utilizzo del software dopo il login DEL COMMESSO
                        do
                        {
                            fineCommesso = true;

                            switch (Utility.Menu(opzioniCom, keyboard))
                            {
                                case 1:
                                    //inserimento libro
                                    Libro libroMomentaneo;
                                    libroMomentaneo = Libro.inserisciLibro(keyboard);
                                    scaffale.add(libroMomentaneo);

                                    break;

                                case 2:
                                    Libro.visualizzaScaffale(scaffale);
                                    break;

                                case 3:
                                    Commesso.rimuoviLibro(scaffale, keyboard);
                                    break;

                                case 4:
                                    Commesso.saldoTotale(scaffale);
                                    break;

                                case 5:
                                    if(Libro.ricerca(scaffale, keyboard, indice) != -1)
                                    {
                                        System.out.println("Il libro è presente");
                                    }
                                    break;

                                case 6:
                                    //esci dallo switch case
                                    fineCommesso = false;
                                    break;
                            }
                        } while (fineCommesso);
                    }
                    break;

                case 4:
                    fineLogin = false;
                    //uscita completa dal programma
                    System.exit(0);
                    break;
            }
        } while (fineLogin);


    }
}
