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
    private LocalDate dataInizioPrestito;
    private LocalDate dataFinePrestito;
    //decidete se aggiungere prenota come attributo
    private String password;
    private final int libriPrestatiMax;

    /**
     * Costruttore per creare un oggetto {@link Persona} con tutte le informazioni relative alla persona e al suo prestito bibliotecario.
     *
     * @param _nome il nome della persona.
     * @param _prestato lo stato del prestito, dove {@code true} indica che la persona ha dei libri in prestito, {@code false} in caso non ne abbia.
     * @param _tesseraBiblioteca l'ID della tessera biblioteca associata alla persona.
     * @param _durataDelPrestito la durata del prestito in giorni.
     * @param _dataInizioPrestito la data di inizio del prestito.
     * @param _dataFinePrestito la data di fine del prestito.
     * @param _libriPrestatiMax il numero massimo di libri che la persona può avere in prestito.
     * @param _password la password associata alla persona per l'accesso al sistema.
     */
    public Persona(String _nome, boolean _prestato, String _tesseraBiblioteca, int _durataDelPrestito, LocalDate _dataInizioPrestito, LocalDate _dataFinePrestito, final int _libriPrestatiMax, String _password)
    {
        this.nome = _nome;
        this.prestato = _prestato;
        this.tesseraBiblioteca = _tesseraBiblioteca;
        this.durataDelPrestito = _durataDelPrestito;
        this.dataInizioPrestito = _dataInizioPrestito;
        this.dataFinePrestito = _dataFinePrestito;
        this.libriPrestatiMax = _libriPrestatiMax;
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
        this.durataDelPrestito = 0;
        this.dataInizioPrestito = null;
        this.dataFinePrestito = null;
        this.libriPrestatiMax = 0;
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
        return String.format("Nome dell'Utente: %sTessera della biblioteca: %s Libro in prestito: %b Durata del prestito: %d Inizio del prestito: %s Scadenza del prestito: %s \n"
                ,nome, tesseraBiblioteca, prestato, durataDelPrestito, dataInizioPrestito, dataFinePrestito);
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
     *
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
     * Metodo che permette l'accesso a i metodi sottostanti per poter visualizzare i propri dati personali sui libri
     *
     * @param catalogoPersone Arraylist di tipo Persona
     * @param utente1 oggetto di tipo persona che interpreta l'utente
     *
     * @return in base alla tessera restituisce l'utente o un messaggio di errore
     */
    public static String permessoDiUtilizzo(ArrayList <Persona> catalogoPersone, Persona utente1)
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


    /**
     * Metodo che visualizza se l'utente ha libri presi in prestito, prima di fare ciò vediamo se ha la TesseraBiblioteca
     *
     * @param catalogoPersone Arraylist di tipo Persona
     *
     */

    public static void visualizzaLibriPrestati(ArrayList <Persona> catalogoPersone)
    {
        System.out.println("I libri prestati sono: ");

        for(int i=0; i < catalogoPersone.size(); i++)
        {
            System.out.println("Tessera della biblioteca: "+catalogoPersone.get(i).tesseraBiblioteca);
            if(catalogoPersone.get(i).prestato /*== true*/)
            {
                System.out.println("L'utente ha preso in prestito il libro ");
            }
            else
            {
                System.out.println("Non ci sono libri presi in prestito al momento ");
            }
        }

    }

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
     * @param scanner scanner che legge dati in input
     */
    public static void visualizzaDatiUtente(ArrayList <Persona> catalogoPersone, Scanner scanner)
    {
        String utenteDappoggio;

        //Inserire Perona.tesseraBiblioteca
        System.out.println("Inserire tessera della biblioteca: ");
        utenteDappoggio = scanner.nextLine();

        for(int i=0; i < catalogoPersone.size(); i++)
        {
            if(catalogoPersone.get(i).tesseraBiblioteca.equalsIgnoreCase(utenteDappoggio))
            {
                catalogoPersone.toString();
            }

        }

    }

    /**
     * Metodo che la persona può utilizzare per vedere quanti libri ha in prestito al momento
     *
     * @param catalogoPersone Arraylist di tipo Persona
     */

    public static void  visualizzaLibriInPrestito(ArrayList <Persona> catalogoPersone )
    {

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

        System.out.println("ACCOUNT CREATO \n\n");

        //nello switch crea un oggetto nul che verrà uguagliato a questo metodo, poi aggiungi all'array list l'oggetto che è stato creato nel main

        return utente;
    }

    /**
     * Permette ad un utente di accedere al sistema verificando l'ID della tessera e la password.
     *
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

        for (int i = 0; i < catalogoPersone.size(); i++)
        {
            if (catalogoPersone.get(i).nome.equals(name))
            {
                if (catalogoPersone.get(i).password.equals(pass))
                {
                    return true;
                }
            }
        }
        return false;

    }



}
