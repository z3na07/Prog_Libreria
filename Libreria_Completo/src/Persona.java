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

    private String password;
    private final int libriPrestatiMax;

    //creazione costruttore
    public Persona(String _nome, boolean _prestato, String _tesseraBiblioteca, int _durataDelPrestito, String _dataInizioPrestito, String _dataFinePrestito, final int _libriPrestatiMax, String _password)
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

    final int fMax = 50;
    Persona [] catalogoPersone = new Persona[fMax];


    @Override
    public String toString()
    {
        return String.format("Nome dell'Utente: %sTessera della biblioteca: %s Libro in prestito: %b Durata del prestito: %d Inizio del prestito: %s Scadenza del prestito: %s \n"
                ,nome, tesseraBiblioteca, prestato, durataDelPrestito, dataInizioPrestito, dataFinePrestito);
    }

    /*public String setNome() finisci il metodo
    {

    }*/

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public boolean isPrestato()
    {
        return prestato;
    }

    public void setPrestato(boolean prestato)
    {
        this.prestato = prestato;
    }

    public String getTesseraBiblioteca()
    {
        return tesseraBiblioteca;
    }

    public void setTesseraBiblioteca(String tesseraBiblioteca)
    {
        this.tesseraBiblioteca = tesseraBiblioteca;
    }

    public int getDurataDelPrestito()
    {
        return durataDelPrestito;
    }

    public void setDurataDelPrestito(int durataDelPrestito)
    {
        this.durataDelPrestito = durataDelPrestito;
    }

    public String getDataInizioPrestito()
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
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }




    //metodo che permette l'accesso a i metodi sottostanti per poter visualizzare i propri dati personali sui libri
    public static String permessoDiUtilizzo(Persona[] catalogoPersone, Persona utente1)
    {
        //fai inserire da main la TesseraBiblioteca
        for(int i=0; i < catalogoPersone.length; i++)
        {
            if(catalogoPersone[i].tesseraBiblioteca.equalsIgnoreCase(utente1.tesseraBiblioteca))
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
                System.out.println("Non ci sono libri presi in prestito al momento ");
            }
        }

    }

    //questo metodo funziona facendo inserire la tessera da biblioteca, controllando se possiede un libro in prestito, se si allora si visualizza quando è iniziato il prestito
    public static void visualizzaTempoRimastoDelPrestito(Persona [] catalogoPersone)
    {



    }

    //visualizza dati Utente
    public static void visualizzaDatiUtente(Persona [] catalogoPersone, String utenteDappoggio, Scanner scanner)
    {
        //Inserire Perona.tesseraBiblioteca
        System.out.println("Inserire tessera della biblioteca: ");
        utenteDappoggio = scanner.nextLine();

        for(int i=0; i < catalogoPersone.length; i++)
        {
            if(catalogoPersone[i].tesseraBiblioteca.equalsIgnoreCase(utenteDappoggio))
            {
                catalogoPersone[i].toString();
            }

        }

    }

    //metodo che la persona può utilizzare per vedere quanti libri ha in prestito al momento
    public static void  visualizzaLibriInPrestito(Persona [] catalogoPersone )
    {



    }

    //metodo inserimento persona in catalogoPersone
    public static Persona [] registrati(Persona [] catalogoPersone, Scanner scanner, int contPersone) throws Exception
    {
        //crazione oggetto
        Persona utente = new Persona();

        //creazioni credenziali con controllo
        do
        {
            System.out.println("Inserisci il tuo nome");
            utente.setNome(scanner.next());
        }while(utente.nome.matches(".*\\d.*"));

        System.out.println("Inserisci la tua password");
        utente.setPassword(scanner.next());

        catalogoPersone[contPersone] = utente;

        System.out.println("ACCOUNT CREATO \n\n");

        //contPersone deve essere aumentato di uno nel main ogni volta che il petodo ha avuto successo

        return catalogoPersone;
    }


    public static boolean accedi(Persona [] catalogoPersone, Scanner scanner)
    {
        String name,pass;

        System.out.println("Inserisci l'id della tessera bibilioteca: ");
        name = scanner.next();

        System.out.println("Inserisci la password");
        pass = scanner.next();

        for(int i=0;i< catalogoPersone.length;i++)
        {
            if(catalogoPersone[i].nome.equals(name))
            {
                if(catalogoPersone[i].password.equals(pass))
                {
                    return true;
                }

            }

        }

        return false;
    }





}
