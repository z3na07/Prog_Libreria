public class Persona
{
    protected boolean prestato;
    protected String tesseraBiblioteca;
    protected int durataDelPrestito;
    protected String dataInizioPrestito;
    protected String dataFinePrestito;


    @Override
    public String toString()
    {
        return String.format("Tessera della biblioteca: %s Libro in prestito: %b Durata del prestito: %d Inizio del prestito: %s Scadenza del prestito: %s \n"
                                ,tesseraBiblioteca, prestato, durataDelPrestito, dataInizioPrestito, dataFinePrestito);
    }

    //
    private static void visualizzaLibriPrestati(Persona [] prestiti, boolean prestato)
    {
        System.out.println("I libri prestati sono: ");

        for(int i=0; i < prestiti.length; i++)
        {
            System.out.printf(prestiti[i].);

        }

    }


}