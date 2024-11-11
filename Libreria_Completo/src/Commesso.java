import java.util.Scanner;

public class Commesso
{
    private String nome;
    private String cognome;
    final private String password = "Letsgoski";

    public Commesso(String _nome, String _cognome, String _password)
    {
        this.nome = _nome;
        this.cognome = _cognome;
    }
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCognome(){
        return cognome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public Commesso(){
        nome = null;
        cognome = null;
    }


    @Override
    public String toString() {
        return String.format(" nome: %s, cognome: %s" + nome + cognome + password);
    }



    //inserisci libro
    /*public static void CompraLibro(Libro [] scaffale, Scanner input)
    {
        Libro.inserisciLibro(scaffale, input);
    }*/

    //cancella libro
    private static void CancellaLibro(Libro [] scaffale, Scanner input){
        String titolo;
        System.out.println("Inserisci il titolo del libro da cancellare");
        titolo = input.nextLine();
        for(int i=0; i<scaffale.length; i++){
            if(scaffale[i].getTitolo().equals(titolo)){
                scaffale[i] = null;
            }
        }
    }

    //registro pagamenti
    private static void Saldo(Libro [] scaffale){
        double saldo = 0;
        for(int i=0; i<scaffale.length; i++){
            if(scaffale[i].isVenduto()){
                System.out.println("Questo libro è stato venduto");
                System.out.println(scaffale[i]);
                saldo = saldo + scaffale[i].getPrezzo();
            }
        }
        System.out.println("Saldo attuale " + saldo);

    }


    //Martino deve finire di configurare i PRESTITI
    public static void visualizzaLibriPrestatiATutti(Persona [] catalogoPersone)
    {



    }

}
