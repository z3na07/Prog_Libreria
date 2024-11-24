import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;


enum genere {romanzo, manuale, enciclopedia, fumetto};
/**
 * Classe che gestisce tutte le azioni sullo scaffale e sui libri stessi sia appena creati che quelli gia all'interno di scaffale
 *
 * @author Leonardo (z3na07)
 * @version 1
 * */
public class Libro
{

    /**
     * Costruttore della classe {@code Libro}. Questo costruttore inizializza un oggetto {@code Libro}
     * con i valori specificati per il codice ISBN, l'editore, il titolo, il prezzo, lo stato di vendita
     * e l'autore.
     *
     * @param _isbn Il codice ISBN del libro. Un identificatore unico per ogni edizione del libro.
     * @param _editore Il nome dell'editore del libro.
     * @param _titolo Il titolo del libro.
     * @param _prezzo Il prezzo del libro. Un valore numerico che rappresenta il costo del libro.
     * @param _venduto Un valore booleano che indica se il libro è stato venduto (true) o meno (false).
     * @param _autore Il nome dell'autore del libro.
     */
    public Libro(String _isbn, String _editore, String _titolo, double _prezzo, boolean _venduto, String _autore) {
        isbn = _isbn;
        editore = _editore;
        titolo = _titolo;
        prezzo = _prezzo;
        venduto = _venduto;
        autore = _autore;
    }

    /**
     * Costruttore vuoto della classe {@code Libro}
     */
    public Libro() {
        isbn = null;
        editore = null;
        titolo = null;
        prezzo = 0;
        venduto = false;
        autore = null;
    }



    /**
     * Metodo set del attributo isbn
     *
     * @param isbn isbn del libro
     * */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Metodo get del attributo Editore
     *
     * @return ritorna il valore del campo editore
     */
    public String getEditore() {
        return this.editore;
    }

    /**
     * metodo set dell'attributo editore
     *
     * @param editore editore del libro
     * */
    public void setEditore(String editore) {
        this.editore = editore;
    }

    /**
     * Metodo get dell'attributo titoloù
     *
     * @return ritorna il valore del campo titolo
     * */
    public String getTitolo() {
        return this.titolo;
    }

    /**
     * Metodo set dell'attributo titolo
     *
     * @param titolo titolo del libro
     * */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Metodo get dell'attributo prezzo
     *
     * @return ritorna il valore del campo prezzo
     * */
    public double getPrezzo() {
        return this.prezzo;
    }

    /**
     * Metodo set dell'attributo prezzo
     *
     * @param prezzo prezzo del libro
     * */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Metodo che ritorna se il libro è venduto oppure no
     *
     * @return ritorna il valore del campo venduto (true o false)
     * */
    public boolean isVenduto() {
        return this.venduto;
    }

    /**
     * metodo set dell'attributo venduto
     *
     * @param venduto valore booleano che riconosce se il libro è stato venduto oppure no
     * */
    public void setVenduto(boolean venduto) {
        this.venduto = venduto;
    }

    /**
     * Metodo get dell'attributo autore
     *
     * @return ritorna il valore del campo editore
     * */
    public String getAutore() {
        return this.autore;
    }

    /**
     * Metodo set dell'attribvuto autore
     *
     * @param autore autore del libro
     * */
    public void setAutore(String autore) {
        this.autore = autore;
    }

    /**
     * Metodo get dell'attributo isbn
     *
     * @return ritorna il valore del campo isbn
     * */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Metodo get dell'attributo tipo
     *
     * @return ritorna il calore del campo tipo
     * */
    public genere getTipo()
    {
        return tipo;
    }

    /**
     * Metodo set dell'attributo tipo
     *
     * @param tipo attributo di tipo {@code enum} che ci dice se il libro è romanzo thriller o fumetto
     * */
    public void setTipo(genere tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo get dell'attributo indiceDiPersonaCheHaConprato
     *
     * @return ritorna l'indice della persona che ha comprato il libro
     * */
    public int getIndiceDiPersonaCheHaConprato()
    {
        return indiceDiPersonaCheHaConprato;
    }

    /**
     * Metodo set dell'attributo indiceDiPersonaCheHaConprato
     *
     * @param indiceDiPersonaCheHaConprato attributo che salva l'indice della persona che ha comprato un determinato libro
     * */
    public void setIndiceDiPersonaCheHaConprato(int indiceDiPersonaCheHaConprato)
    {
        this.indiceDiPersonaCheHaConprato = indiceDiPersonaCheHaConprato;
    }

    //vari attributi
    private String isbn;
    private String editore;
    private String titolo;
    private double prezzo;
    private boolean venduto;
    private String autore;
    private genere tipo;
    private int indiceDiPersonaCheHaConprato;

    /**
     * Override del metodo toString
     *
     * @return riorna una {@code String} in cui sono stampati tutti gli attributi del libro e i loro corrispettivi valori
     * */
    @Override
    public String toString()
    {
        return String.format("isbn libro: %s || Editore libro: %s || Titolo: %s || Prezzo: %.2f || Venduto: %b\n", isbn, editore, titolo, prezzo, venduto);
    }

    /**
     *
     * Ovveride del metodo equals
     *
     * @return {@code true} se gli oggetti comprati sono uguali, {@code false} altrimenti
     * */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        return Double.compare(prezzo, libro.prezzo) == 0 && venduto == libro.venduto && Objects.equals(isbn, libro.isbn) && Objects.equals(editore, libro.editore) && Objects.equals(titolo, libro.titolo) && Objects.equals(autore, libro.autore) && tipo == libro.tipo;
    }

    /**
     * Restituisce un valore hash per questo oggetto.
     * Questo metodo calcola un valore hash basato sui campi significativi
     * della classe {@code Libro}.
     * Oggetti uguali (secondo il metodo {@code equals}) devono restituire lo stesso valore hash.
     *
     * @return il valore hash di questo oggetto
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(isbn, editore, titolo, prezzo, venduto, autore, tipo);
    }

    /**
     * Metodo ricerca che restituisce un booleano e cerca i libri tramite l'isbn univoco
     *
     * @param keyboard scanner che legge i dati in input
     * @param scaffale un {@code ArrayList} di tipo {@code Libro} al cui interno sono salvati tutti i libri
     *
     * @return indice se il libro è stato trovato, -1 altrimenti
     * */
    public static int ricerca(ArrayList<Libro> scaffale, Scanner keyboard, int indice)
    {
        System.out.println("Inserire il l'isbn del libro: ");
        String isbnMomentaneo = keyboard.nextLine();

        for (int i = 0; i < scaffale.size(); i++)
        {
            Libro libro = scaffale.get(i);

            if (libro.isbn.equalsIgnoreCase(isbnMomentaneo))
            {
                if (i != indice)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Metodo inserisci libro che premette di inserire un libro all'interno dell'{@code ArrayLIst} Scaffale facendo inserire tutti gli attributi
     *
     * @param input Scanner che legge i dati in input
     *
     * @return il programma returna l'oggetto libro che poi verrà inserito in scaffale
     * */

    //QUANDO INSERISCI UN LIBRO DEVI CREARE IL SUO ISBN CON UN RANDOM, MA SE IL LIBRO GIA' ESISTE ALLORA DEVI COPIARE IL SUO ISBN (SENZA USARE IL RANDOM)
    public static Libro inserisciLibro(Scanner input)
    {
        Libro libro = new Libro();
        String[] tipoG = {"GENERE", "romanzo", "manuale", "enciclopedia", "fumetto"};

        System.out.println("**********************************");
        System.out.println("INSERIMENTO LIBRO NELLO SCAFFALE");
        System.out.println("**********************************");

        System.out.println("Inserisci il titolo del libro");
        libro.setTitolo(input.nextLine());

        do
        {
            System.out.println("Inserisci l'autore del libro");
            libro.setAutore(input.nextLine());

        } while (libro.autore.matches(".*\\d.*"));

        while (true)
        {
            try
            {
                System.out.println("Inserisci il prezzo del Libro");
                libro.setPrezzo(Double.parseDouble(input.next()));
                break;
            } catch (Exception e) {
                System.out.println("Valore errato, reinserire");
            }
        }

        input.nextLine();
        do
        {
            System.out.println("Inserisci ISBN del libro");
            libro.setIsbn(input.nextLine());

        } while (libro.getIsbn().length() == 12);

        System.out.println("Inserisci l'editore del libro");
        libro.setEditore(input.nextLine());

        System.out.println("Di che tipo è il tuo libro");
        switch (Utility.Menu(tipoG, input)) {
            case 1 -> libro.setTipo(genere.romanzo);
            case 2 -> libro.setTipo(genere.manuale);
            case 3 -> libro.setTipo(genere.enciclopedia);
            case 4 -> libro.setTipo(genere.fumetto);
        }

        return libro;
    }

    /**
     * metodo che stampa a schermo tutti i dati di tutti i libri dell'{@code ArrayList} scaffale
     *
     * @param scaffale {@code ArrayList} di tipo {@code Libro} che contiene tutti i libri
     * */
    public static void visualizzaScaffale(ArrayList<Libro> scaffale)
    {
        for(Libro libro : scaffale)
        {
            System.out.println(libro);
        }
    }


}
