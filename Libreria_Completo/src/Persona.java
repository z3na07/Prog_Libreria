import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Rappresenta una persona con nome, cognome e età iscritta alla libreria.
 * Questa classe fornisce metodi per ottenere e modificare le informazioni di tale soggetto.
 *
 * @author Martino (Hallo5685)
 * @version beta
 */
public class Persona
{
    private String nome;
    private boolean prestato;
    private String tesseraBiblioteca;
    private String password;
    private int indicePosizione;


    /**
     * Costruttore per creare un oggetto {@link Persona} con tutte le informazioni relative alla persona e al suo prestito bibliotecario.
     *
     * @param _nome il nome della persona.
     * @param _tesseraBiblioteca l'ID della tessera biblioteca associata alla persona.
     * @param _password la password associata alla persona per l'accesso al sistema.
     */
    public Persona(String _nome, String _tesseraBiblioteca, String _password)
    {
        this.nome = _nome;
        this.tesseraBiblioteca = _tesseraBiblioteca;
        this.password =_password;
    }

    /**
     * Costruttore per creare un oggetto {@link Persona} senza gli attributi istanziati
     * */
    public Persona()
    {
        this.nome = null;
        this.prestato = false;
        this.tesseraBiblioteca = null;

    }

    /**
     * Metodo che stampa tutti gli attributi di un'oggetto Persona
     *
     * @return una stringa che rappresenta l'utente iscritto alla libreria stampandone tutti gli attributi
     *
     * */
    @Override
    public String toString()
    {
        return String.format("Nome dell'Utente: %s Tessera della biblioteca: %s  \n"
                ,nome, tesseraBiblioteca);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (!(o instanceof Persona persona))
            return false;

        return isPrestato() == persona.isPrestato() && Objects.equals(getNome(), persona.getNome())
                && Objects.equals(getTesseraBiblioteca(), persona.getTesseraBiblioteca())
                && Objects.equals(getPassword(), persona.getPassword());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getNome(), isPrestato(), getTesseraBiblioteca(), getPassword());
    }

    /**
     * Questo metodo è un **getter** che permette di accedere al valore dell'indice che comunica dove si trova una persona.
     *
     * @return l'indice associato all'utente
     */

    public int getIndicePosizione()
    {
        return indicePosizione;
    }

    /**
     * Questo metodo è un **setter** che permette di associare un indice all'utente.
     *
     * @param indicePosizione intero che passiamo al metodo
     */
    public void setIndicePosizione(int indicePosizione)
    {
        this.indicePosizione = indicePosizione;
    }

    /**
     * Questo metodo è un **getter** che permette di accedere al valore del nome associata all'utente.
     *
     * @return il nome associato all'utente
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * Questo metodo è un **setter** che permette di associare un nome all'utente.
     *
     * @param nome stringa che passiamo al metodo
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * Questo metodo è un **getter** che permette di accedere al valore del prestito associata all'utente.
     *
     * @return {@code true} se il libro è stato prestato, {@code false} altrimenti
     */
    public boolean isPrestato()
    {
        return prestato;
    }

    /**
     * Imposta il valore booleano dell'attributo prestato dell'utente.
     *
     * @param prestato booleano che passiamo al metodo
     */
    public void setPrestato(boolean prestato)
    {
        this.prestato = prestato;
    }

    /**
     * Restituisce il valore della tessera della biblioteca dell'utente.
     *
     * Questo metodo è un **getter** che permette di accedere al valore della tessera della biblioteca associata all'utente.
     *
     * @return strung della tessera della biblioteca.
     */
    public String getTesseraBiblioteca()
    {
        return tesseraBiblioteca;
    }

    /**
     * Imposta il valore della tessera dell'utente.
     * Questo metodo è un **setter** che permette di inserire il valore della tessera della biblioteca.
     *
     * @param tesseraBiblioteca stringa che passiamo al metodo
     */
    public void setTesseraBiblioteca(String tesseraBiblioteca)
    {
        this.tesseraBiblioteca = tesseraBiblioteca;
    }


    /**
     * Restituisce la password dell'utente.
     * Questo metodo è un **getter** che permette di accedere al valore della password associata all'utente.
     *
     * @return la password dell'utente.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Imposta la password dell'utente.
     *
     * Questo metodo è un **setter** che permette di associare una password all'utente.
     *
     * @param password la stringa che passiamo al metodo
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Metodo che dopo aver verificato la tessera della biblioteca inserita da tastiera stampa i dati del cliente che ha inserito la tessera
     *
     * @param catalogoPersone Arraylist di tipo Persona di cui verrà stampato la cella selezionata
     * @param keyboard scanner che legge dati in input
     */
    public static void visualizzaDatiUtente(ArrayList <Persona> catalogoPersone, Scanner keyboard)
    {
        String utenteDappoggio;

        //Inserire Perona.tesseraBiblioteca
        System.out.println("Inserire tessera della biblioteca: ");
        utenteDappoggio = keyboard.nextLine();

        for(Persona persona : catalogoPersone)
        {
            if(persona.tesseraBiblioteca.equals(utenteDappoggio))
            {
                System.out.println(persona.toString());
            }
        }

    }

    /**
     * Metodo di tipo "Persona " che crea le credenziali del cliente per il primo accesso al softwere facendo inserier i parametri utili tra cui il nome e la password.
     * se tutto si è svolto senza probeli stampa la scritta: "ACCOUNT CREATO" e ritorna l'oggetto che è stato creato con i parametri inseriti dall'utente
     *
     * @param scanner scanner che legge i dati in input
     *
     * @return l'oggetto che è stato creato con i parametri inseriti dall'utente
     */
    public static Persona registrati(Scanner scanner) //throws Exception
    {

        //crazione oggetto
        Persona utente = new Persona();

        //creazioni credenziali con controllo
        do
        {
            System.out.println("Inserisci il tuo nome");
            utente.setNome(scanner.nextLine());

        }while(utente.nome.matches(".*\\d.*"));

        System.out.println("Inserisci la tua password");
        utente.setPassword(scanner.nextLine());

        String randomStr = RandomStringGenerator.generateRandomString(5);
        utente.tesseraBiblioteca = randomStr;

        System.out.println("ACCOUNT CREATO \n");

        //stampa della tessera da biblioteca tramite la variabile appena generata
        System.out.println("Ecco la tessera della biblioteca: "+randomStr);
        //nello switch crea un oggetto nul che verrà uguagliato a questo metodo, poi aggiungi all'array list l'oggetto che è stato creato nel main

        return utente;
    }

    /**
     * Permette ad un utente di accedere al sistema verificando l'ID della tessera e la password.
     * Questo metodo chiede all'utente di inserire l'ID della tessera della biblioteca e una password.
     * I dati immessi vengono confrontati con le informazioni contenute nel catalogo delle persone registrate.
     * Se l'ID e la password inseriti corrispondono a un utente registrato, il metodo restituisce {@code true}.
     * Se almeno uno dei dati è errato, il metodo restituisce {@code false}.
     *
     * @param catalogoPersone Arraylist di tipo Persona che contiene le informazioni su tutte le persone registrate.
     * @param scanner scanner che legge i dati in input
     *
     * @return {@code true} se l'ID della tessera e la password corrispondono a quelli di un utente nel catalogo, {@code false} altrimenti.
     */
    public static boolean accedi(ArrayList <Persona> catalogoPersone, Scanner scanner)
    {
        String tesser, pass;

        System.out.println("Inserisci l'id della tessera bibilioteca: ");
        tesser = scanner.nextLine();

        System.out.println("Inserisci la password");
        pass = scanner.nextLine();

        for (Persona persona : catalogoPersone)
        {
            if (persona.tesseraBiblioteca.equals(tesser))
            {
                if (persona.password.equals(pass))
                {
                    return true;
                }
            }
        }
        return false;

    }


    /**
     * Metodo void che visualizza i libri messi nel carrello dall'utente
     *
     * @param scaffale {@code ArrayList} di tipo {@code Libro} con al suo interno tutti i libri
     * @param keyboard Scanner che legge i dati in input
     * @param catalogoPersone {@code ArrayList} di tipo {@code Persona} con al suo interno tutti le persone che hanno effetuato la registrazione alla Libreria
     * */
    public static void visualizzaCarrello(ArrayList<Libro> scaffale, Scanner keyboard, ArrayList <Persona> catalogoPersone, boolean carrrelllo)
    {
        String tesseraFake;

        System.out.println("Inserisci l'id della tessera bibilioteca: ");
        tesseraFake = keyboard.nextLine();

        for(Persona persona : catalogoPersone)
        {
            if(persona.getTesseraBiblioteca().equals(tesseraFake))
            {
                if(!carrrelllo)
                {
                    System.out.println("Il carrello è vuoto");
                    break;

                }else
                {
                    //PER STAMPARE IL CARRELLO BISOGNA VEDERE CHE VENGA STAMPATO SOLO QUELLO DELLA PERSONA CON TESSERA DA BIBLIOTECA CORRETTA
                    for (Libro libro : scaffale)
                    {
                        //cerca l'indice della persona corretta che nel flag "libriVenduti" ha salvato l'isbn dei libri che deve stampare

                        //DA CONTROLLARE QUESTO PEZZO DI CODIDE E DA INSERIRE NELL'IF SOTTOSTANTE
                        //&& libro.getIsbn().equals(scaffale.getlibriComprati)

                        if (libro.isVenduto() && libro.getIndiceDiPersonaCheHaConprato() == persona.indicePosizione)
                        {
                            System.out.println(libro.toString());
                        }
                    }
                }
            }
        }

    }


    /**
     * Metodo per il pagamento nei libri del carrello
     *
     * @param contotot Il conto finale, ovvero la somma di tutti i prezzi dei Libri messi nel carrello
     * @param keyboard Scanner che legge i dati in input
     *
     * @return il metodo ritorna il conto totale azzerato se l'utente ha pagato
     * */
    public static double pagamento(double contotot, Scanner keyboard)
    {
        String conferma;

        System.out.println("Conto totale da pagare: "+contotot);
        System.out.println("Inserisci si per pagare, inserisci no per uscire");
        conferma = keyboard.nextLine();

        if(conferma.equalsIgnoreCase("si")) {

            System.out.println("IMPORTO PAGATO");

            contotot = 0;
        }
        return contotot;
    }


}
