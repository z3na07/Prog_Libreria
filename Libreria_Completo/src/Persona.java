import java.time.LocalDate;
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

    //dovrà essere un valore costante
    private int durataDelPrestito;
    //decidete se aggiungere prenota come attributo
    private String password;


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
     * Restituisce la durata del prestito dell'utente.
     *
     * Questo metodo è un **getter** che permette di accedere al valore della durata del prestito associata all'utente.
     *
     * @return la durata del prestito.
     */
    public int getDurataDelPrestito()
    {
        return durataDelPrestito;
    }

    /**
     * Imposta la durata del prestito dell'utente.
     * Questo metodo è un **setter** che permette di associare una data di inizio prestito all'utente.
     *
     * @param durataDelPrestito dato che passiamo al metodo
     *
     */
    public void setDurataDelPrestito(int durataDelPrestito)
    {
        this.durataDelPrestito = durataDelPrestito;
    }

    /*public String getDataInizioPrestito()
    {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(String dataInizioPrestito)
    {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public String getDataFinePrestito()
    {
        return dataFinePrestito;
    }

    public void setDataFinePrestito(String dataFinePrestito)
    {
        this.dataFinePrestito = dataFinePrestito;
    }*/

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


     /*
     * Metodo che permette l'accesso a i metodi sottostanti per poter visualizzare i propri dati personali sui libri
     *
     * @param catalogoPersone Arraylist di tipo Persona
     * @param utente1 oggetto di tipo persona che interpreta l'utente
     *
     * @return in base alla tessera restituisce l'utente o un messaggio di errore
     */
/*    public static String permessoDiUtilizzo(ArrayList <Persona> catalogoPersone, Persona utente1)
    {
        //fai inserire da main la TesseraBiblioteca
        for(int i=0; i < catalogoPersone.size(); i++)
        {
            if(catalogoPersone.get(i).tesseraBiblioteca.equalsIgnoreCase(utente1.tesseraBiblioteca))
            {
                return "Bentoranto utente: "+ utente1.nome;
            }
        }
        return "La tessera della biblioteca inserita non è corretta ";
    }
*/

    /**
     * Metodo che visualizza se l'utente ha libri presi in prestito, prima di fare ciò vediamo se ha la TesseraBiblioteca
     *
     * @param catalogoPersone Arraylist di tipo Persona
     *
     */



    /**
     * Inserendo da tessera da biblioteca, controllando se possiede un libro in prestito, se si allora si visualizza quando è iniziato il prestito
     *
     * (Non utilizzato/finito, per tanto non completo)
     *
     * @param catalogoPersone Arraylist di tipo Persona
     *
     */
    public static void visualizzaTempoRimastoDelPrestito(Persona [] catalogoPersone)
    {



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
     * Metodo che la persona può utilizzare per vedere quanti libri ha in prestito al momento
     *
     * @param catalogoPersone Arraylist di tipo Persona
     */


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
        String name, pass;

        System.out.println("Inserisci l'id della tessera bibilioteca: ");
        name = scanner.nextLine();

        System.out.println("Inserisci la password");
        pass = scanner.nextLine();

        for (Persona persona : catalogoPersone)
        {
            if (persona.nome.equals(name))
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
    public static void visualizzaCarrello(ArrayList<Libro> scaffale, Scanner keyboard, ArrayList <Persona> catalogoPersone){

        String tesseraFake;

        System.out.println("Inserisci l'id della tessera bibilioteca: ");
        tesseraFake = keyboard.nextLine();

        for(Persona persona : catalogoPersone){
            if(persona.getTesseraBiblioteca().equals(tesseraFake)){
                for(Libro libro : scaffale){
                    if(libro.isVenduto()){
                        System.out.println(libro.toString());
                    }
                }
            }
        }


    }



}
