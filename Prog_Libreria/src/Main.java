import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList <Persona> catalogoPersone = new ArrayList<>();

        String [] opzioniLogin = {"LOGIN ","entrata cliente","entrata commesso"};
        String [] opzioni = {"BIBLIOTECA","Login","","","","USCITA"};

        boolean fineLogin = true;
        boolean fine = true;

        int contPersone = 0;


        do
        {
            switch (Tools.Menu(opzioniLogin, keyboard))
            {
                case 1:
                    //registrazione

                    Persona nuovoUtente = new Persona();
                    nuovoUtente = Persona.registrati(catalogoPersone, keyboard, contPersone);
                    catalogoPersone.add(nuovoUtente);

                    fineLogin = false;
                    break;

                case 2:
                    //accesso cliente
                    if(Persona.accedi(catalogoPersone, keyboard) == true)
                    {
                        System.out.println("Accesso eseguito corretamente \n");
                    }

                    //esci dallo switch login per andare allo switch del menù
                    fineLogin = false;
                    break;

                case 3:
                    //accesso commesso
                    fineLogin = false;
                    break;
            }
        }while (fineLogin);




        //switch case che permetterà l'utilizzo el softwere dopo il login
        do
        {
            switch (Tools.Menu(opzioni, keyboard))
            {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 6:
                    //esci dallo switch case
                    fine = false;
                    break;
            }
        }while (fine);



    }
}