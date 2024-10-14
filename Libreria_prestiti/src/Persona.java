package Cliente;
import Libreria.Libro;

import java.util.Scanner;

public class Persona
{
    public String nome;
    public boolean prestato;
    protected String tesseraBiblioteca;
    protected int durataDelPrestito;
    protected String dataInizioPrestito;
    protected String dataFinePrestito;
    //decidete se aggiungere prenota come attributo


    @Override
    public String toString()
    {
        return String.format("Nome dell'Utente: %sTessera della biblioteca: %s Libro in prestito: %b Durata del prestito: %d Inizio del prestito: %s Scadenza del prestito: %s \n"
                ,nome, tesseraBiblioteca, prestato, durataDelPrestito, dataInizioPrestito, dataFinePrestito);
    }

    //metodo che permette l'accesso a i metodi sottostanti per poter visualizzare i propri dati personali sui libri
    public static String permessoDiUtilizzo(Persona[] catalogoPrestiti, Persona utente1)
    {
        //fai inserire da main la TesseraBiblioteca
        for(int i=0; i < catalogoPrestiti.length; i++)
        {
            if(catalogoPrestiti[i].tesseraBiblioteca == utente1.tesseraBiblioteca)
            {
                return "Bentoranto utente: "+ utente1.nome;
            }
        }
        return "La tessera della biblioteca inserita non è corretta ";
    }


    //questo metodo visualizza se l'utente ha libri presi in prestito, prima di fare ciò vediamo se ha la TesseraBiblioteca
    public static void visualizzaLibriPrestati(Persona [] catalogoPrestiti)
    {
        System.out.println("I libri prestati sono: ");

        for(int i=0; i < catalogoPrestiti.length; i++)
        {
            System.out.println("Tessera della biblioteca: "+catalogoPrestiti[i].tesseraBiblioteca);
            if(catalogoPrestiti[i].prestato == true)
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
    public static void visualizzaTempoRimastoDelPrestito(Persona [] catalogoPrestiti)
    {



    }

    //visualizza dati Utente
    public static void visualizzaTesseraBiblioteca(Persona [] catalogoPrestiti, Scanner scanner, Persona utente)
    {
        //Inserire Perona.tesseraBiblioteca
        utente.toString();
    }

}