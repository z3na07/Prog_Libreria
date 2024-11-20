import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

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
     * Restituisce la password del commesso
     *
     * @return la password commesso
     */
    public String getPassword()
    {
        return password;
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
     *  Confronta due oggetti tra loro sfruttando i loro parametri
     *
     *  @return {@code true} se gli oggetti sono uguali {@code false} altrimenti
     */
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Commesso commesso = (Commesso) obj;

        return Objects.equals(nome, commesso.nome) &&
                Objects.equals(cognome, commesso.cognome) &&
                Objects.equals(password, commesso.password);
    }


    /**
     * Metodo publico che cancella un libro dallo scaffale in base al titolo fornito dall'utente
     *
     * @param scaffale Un array di oggetti di tipo Libro che rappresenta lo scaffale dei libri
     * @param keyboard scanner che legge i dati in input
     */
    public static void rimuoviLibro(ArrayList <Libro> scaffale, Scanner keyboard){

        String isbnFittizzio;

        System.out.println("Inserisci l'isbn del libro");
        isbnFittizzio = keyboard.next();

        for(Libro libro : scaffale){

            if(libro.getIsbn().equals(isbnFittizzio)){
                scaffale.remove(libro);
            }
        }

    }

    /**
     * Metodo privato che calcola e visualizza il saldo totale dei libri venduti
     * Somma i prezzi dei libri venduti e li mostra all'utente
     *
     * @param scaffale Un array di oggetti di tipo Libro che rappresenta lo scaffale dei libri
     */
    public static void saldoTotale(ArrayList<Libro> scaffale) {
        double saldo = 0;
        for(Libro libro : scaffale){
            if (libro.isVenduto()){
                saldo += libro.getPrezzo();
            }
        }
        System.out.println("Saldo attuale " + saldo);
    }

}
