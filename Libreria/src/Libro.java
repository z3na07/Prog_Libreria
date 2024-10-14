enum genere  {Romanzo, Manuale, enciclopedia, fumetto};
public class Libro {
    public Libro(String _isbn, String _editore, String _titolo, double _prezzo, boolean _venduto ) {
        isbn = _isbn;
        editore = _editore;
        titolo = _titolo;
        prezzo = _prezzo;
        venduto = _venduto;
    }


    private String isbn;


    private String editore;

    private String titolo;

    private double prezzo;

    private boolean venduto;

    @Override
    public String toString(){
        return String.format("isbn libro: %s Editore libro: %s Titolo: %s Prezzo: %d Venduto %b\n", isbn, editore, titolo, prezzo, venduto);
    }

    private static void ricerca(String titolo)
    {
        System.out.println("Inserisci il titolo del libro che vuoi ricercare");

    }
}