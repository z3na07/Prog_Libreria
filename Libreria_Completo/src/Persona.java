import java.util.Scanner;

public class Persona
{
    private String nome;
    private boolean prestato;
    private String tesseraBiblioteca;
    //dovrà essere un valore costante
    private int durataDelPrestito;
    private String dataInizioPrestito;
    private String dataFinePrestito;
    //decidete se aggiungere prenota come attributo
    private final int libriPrestatiMax;

    //creazione costruttore
    public Persona(String _nome, boolean _prestato, String _tesseraBiblioteca, int _durataDelPrestito, String _dataInizioPrestito, String _dataFinePrestito, final int _libriPrestatiMax)
    {
        this.nome = _nome;
        this.prestato = _prestato;
        this.tesseraBiblioteca = _tesseraBiblioteca;
        this.durataDelPrestito = _durataDelPrestito;
        this.dataInizioPrestito = _dataInizioPrestito;
        this.dataFinePrestito = _dataFinePrestito;
        this.libriPrestatiMax = _libriPrestatiMax;
    }

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


    @Override
    public String toString()
    {
        return String.format("Nome dell'Utente: %sTessera della biblioteca: %s Libro in prestito: %b Durata del prestito: %d Inizio del prestito: %s Scadenza del prestito: %s \n"
                ,nome, tesseraBiblioteca, prestato, durataDelPrestito, dataInizioPrestito, dataFinePrestito);
    }

    /*public String setNome() finisci il metodo
    {

    }*/




    //metodo che permette l'accesso a i metodi sottostanti per poter visualizzare i propri dati personali sui libri
    public static String permessoDiUtilizzo(Persona[] catalogoPersone, Persona utente1)
    {
        //fai inserire da main la TesseraBiblioteca
        for(int i=0; i < catalogoPersone.length; i++)
        {
            if(catalogoPersone[i].tesseraBiblioteca == utente1.tesseraBiblioteca)
            {
                return "Bentoranto utente: "+ utente1.nome;
            }
        }
        return "La tessera della biblioteca inserita non è corretta ";
    }


    //questo metodo visualizza se l'utente ha libri presi in prestito, prima di fare ciò vediamo se ha la TesseraBiblioteca

    public static void visualizzaLibriPrestati(Persona [] catalogoPersone)
    {
        System.out.println("I libri prestati sono: ");

        for(int i=0; i < catalogoPersone.length; i++)
        {
            System.out.println("Tessera della biblioteca: "+catalogoPersone[i].tesseraBiblioteca);
            if(catalogoPersone[i].prestato == true)
            {
                System.out.println("L'utente ha preso in prestito il libro ");
            }
            else
            {
                System.out.println("Il libro non è in prestito ");
            }
        }

    }

    //questo metodo funziona facendo inserire la tessera da biblioteca, controllando se possiede un libro in prestito, se si allora si visualizza quando è iniziato il prestito
    public static void visualizzaTempoRimastoDelPrestito(Persona [] catalogoPersone)
    {



    }

    //visualizza dati Utente
    public static void visualizzaDatiUtente(Persona [] catalogoPersone, Persona utente)
    {
        //Inserire Perona.tesseraBiblioteca
        utente.toString();
    }

    //metodo che la persona può utilizzare per vedere quanti libri ha in prestito al momento
    public static void  visualizzaLibriInPrestito(Persona [] catalogoPersone )
    {



    }

    //metodo inserimento persona in catalogoPersone



}