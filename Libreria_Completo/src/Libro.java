
enum genere  {Romanzo, Manuale, enciclopedia, fumetto};
public class Libro {
    //costruttore della classe
    public Libro(String _isbn, String _editore, String _titolo, double _prezzo, boolean _venduto, String _autore ) {
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

//vari attributi
    private String isbn;


    private String editore;

    private String titolo;

    private double prezzo;

    private boolean venduto;

    private String autore;

    //override del metodo to string in modo da farli stampare quello che vogliamo
    @Override
    public String toString(){
        return String.format("isbn libro: %s Editore libro: %s Titolo: %s Prezzo: %d Venduto %b\n", isbn, editore, titolo, prezzo, venduto);
    }

    //metodo ricerca di un libro in scaffale
    private static void ricerca(Libro input, Libro [] scaffale, final int MAX_LIBRI){

        String titolo;
        String autore;

        System.out.println("Inserisci il titolo del libro che vuoi ricercare");
        titolo = input.titolo;

        for(int i=0; i < MAX_LIBRI; i++){

            if(scaffale[i].titolo.equalsIgnoreCase(titolo)){

                System.out.println("Inserisci l'autore del tuo libro");
                autore = input.autore;

                if(scaffale[i].autore.equalsIgnoreCase(autore)){

                    System.out.println("Il tuo libro è stato trovato, ecco i suoi dati");
                    System.out.println(scaffale[i].toString());


                }


            }

        }




    }







}











