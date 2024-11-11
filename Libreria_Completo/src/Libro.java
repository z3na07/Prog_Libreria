import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


enum genere {romanzo, manuale, enciclopedia, fumetto};

public class Libro
{




    //costruttore della classe
    public Libro(String _isbn, String _editore, String _titolo, double _prezzo, boolean _venduto, String _autore) {
        isbn = _isbn;
        editore = _editore;
        titolo = _titolo;
        prezzo = _prezzo;
        venduto = _venduto;
        autore = _autore;
    }

    //costruttore vuoto
    public Libro() {
        isbn = null;
        editore = null;
        titolo = null;
        prezzo = 0;
        venduto = false;
        autore = null;
    }

    //Tutti metodi get e set
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditore() {
        return this.editore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isVenduto() {
        return this.venduto;
    }

    public void setVenduto(boolean venduto) {
        this.venduto = venduto;
    }

    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getIsbn() {
        return isbn;
    }

    public genere getTipo() {
        return tipo;
    }

    public void setTipo(genere tipo) {
        this.tipo = tipo;
    }

    //vari attributi
    private String isbn;


    private String editore;

    private String titolo;

    private double prezzo;

    private boolean venduto;

    private String autore;

    private genere tipo;


    //override del metodo to string in modo da farli stampare quello che vogliamo
    @Override
    public String toString() {
        return String.format("isbn libro: %s Editore libro: %s Titolo: %s Prezzo: %d Venduto %b\n", isbn, editore, titolo, prezzo, venduto);
    }

    //metodo ricerca di un libro in scaffale
    private static void ricerca(Libro input, ArrayList<Libro> scaffale) {
        String titolo;
        String autore;

        System.out.println("Inserisci il titolo del libro che vuoi ricercare");
        titolo = input.titolo;

        for (int i = 0; i < scaffale.size(); i++) {
            if (scaffale.get(i).titolo.equalsIgnoreCase(titolo)) {
                System.out.println("Inserisci l'autore del tuo libro");
                autore = input.autore;

                if (scaffale.get(i).autore.equalsIgnoreCase(autore)) {
                    System.out.println("Il tuo libro è stato trovato, ecco i suoi dati");
                    System.out.println(scaffale.get(i).toString());
                }
            }
        }
    }

    //metodo inserimento di un libro
    public static Libro inserisciLibro(ArrayList<Libro> scaffale, Scanner input) {
        Libro libro = new Libro();
        String[] tipoG = {"GENERE", "romanzo", "manuale", "enciclopedia", "fumetto"};

        System.out.println("**********************************");
        System.out.println("INSERIMENTO LIBRO NELLO SCAFFALE");
        System.out.println("**********************************");

        System.out.println("Inserisci il titolo del libro");
        libro.setTitolo(input.nextLine());

        do {
            System.out.println("Inserisci l'autore del libro");
            libro.setAutore(input.nextLine());
        } while (libro.autore.matches(".*\\d.*"));

        while (true) {
            try {
                System.out.println("Inserisci il prezzo del Libro");
                libro.setPrezzo(Double.parseDouble(input.next()));
                break;
            } catch (Exception e) {
                System.out.println("Valore errato, reinserire");
            }
        }

        input.nextLine();
        do {
            System.out.println("Inserisci ISBN del libro");
            libro.setIsbn(input.nextLine());
        } while (libro.getIsbn().length() != 12);

        System.out.println("Inserisci l'editore del libro");
        libro.setEditore(input.nextLine());

        System.out.println("Di che tipo è il tuo romanzo");
        switch (Utility.Menu(tipoG, input)) {
            case 1 -> libro.setTipo(genere.romanzo);
            case 2 -> libro.setTipo(genere.manuale);
            case 3 -> libro.setTipo(genere.enciclopedia);
            case 4 -> libro.setTipo(genere.fumetto);
        }

        return libro;
    }

    public static void visualizzaScaffale(ArrayList<Libro> scaffale)
    {
        System.out.println(scaffale.toString());
    }



}
