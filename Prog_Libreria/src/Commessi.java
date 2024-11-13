import java.util.Scanner;

/**
 * La classe Commesso rappresenta un commesso in una di libreria. Gestisce le informazioni personali
 * del commesso, come nome e cognome, e fornisce metodi per la gestione di un catalogo di libri e
 * per l'elaborazione di operazioni legate ai libri (ad esempio, inserimento, cancellazione, saldo)
 *
 * @author Mattia (programmatoresperto)
 * @version beta
 */
public class Commesso {

    private String nome;
    private String cognome;
    private String password = "Letsgoski";  // Password predefinita per il commesso

    /**
     * Costruttore {@link Commesso} della classe Commesso che inizializza il nome e cognome del commesso
     *
     * @param _nome Il nome del commesso
     * @param _cognome Il cognome del commesso
     * @param _password La password del commesso
     */
    public Commesso(String _nome, String _cognome, String _password) {
        this.nome = _nome;
        this.cognome = _cognome;
        this.password =_password;
    }

    /**
     * Restituisce il nome del commesso
     *
     * @return Il nome del commesso
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del commesso
     *
     * @param nome Il nuovo nome del commesso
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome del commesso
     *
     * @return Il cognome del commesso
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome del commesso
     *
     * @param cognome Il nuovo cognome del commesso
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Costruttore vuoto che inizializza nome e cognome a null
     */
    public Commesso() {
        nome = null;
        cognome = null;
    }

    /**
     * Restituisce una rappresentazione testuale del commesso
     * La stringa restituirà il nome, cognome e password del comme
     *
     * @return Una stringa che rappresenta il commesso
     */
    @Override
    public String toString() {
        return String.format(" nome: %s, cognome: %s" + nome + cognome + password);
    }

    /**
     * Metodo privato che cancella un libro dallo scaffale in base al titolo fornito dall'utente
     *
     * @param scaffale Un array di oggetti di tipo Libro che rappresenta lo scaffale dei libri
     * @param input scanner che legge i dati in input
     */
    private static void CancellaLibro(Libro[] scaffale, Scanner input) {
        String titolo;
        System.out.println("Inserisci il titolo del libro da cancellare");
        titolo = input.nextLine();
        for (int i = 0; i < scaffale.length; i++) {
            if (scaffale[i].getTitolo().equals(titolo)) {
                scaffale[i] = null;
            }
        }
    }

    /**
     * Metodo privato che calcola e visualizza il saldo totale dei libri venduti
     * Somma i prezzi dei libri venduti e li mostra all'utente
     *
     * @param scaffale Un array di oggetti di tipo Libro che rappresenta lo scaffale dei libri
     */
    private static void saldo(Libro[] scaffale) {
        double saldo = 0;
        for (int i = 0; i < scaffale.length; i++) {
            if (scaffale[i].isVenduto()) {
                System.out.println("Questo libro è stato venduto");
                System.out.println(scaffale[i]);
                saldo = saldo + scaffale[i].getPrezzo();
            }
        }
        System.out.println("Saldo attuale " + saldo);
    }

    /**
     * Metodo che visualizza i libri prestati a tutte le persone registrate nel catalogo
     * Questo metodo è ancora da implementare
     *
     * @param catalogoPersone Un array di oggetti di tipo Persona che rappresentano il catalogo delle persone
     */
    public static void visualizzaLibriPrestatiATutti(Persona[] catalogoPersone) {
        for (int i = 0; i<catalogoPersone.length; i++){
            if (catalogoPersone[i].isPrestato()){
                System.out.println(catalogoPersone[i]);
            }
        }
    }

}
