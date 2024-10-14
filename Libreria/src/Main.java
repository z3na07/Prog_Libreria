import java.util.Scanner;

import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int log;
        boolean fine = true;
        System.out.println("Login");
        System.out.println("1 cliente 2 commesso");
        log = input.nextInt();
        if(log == 1){
            String[] operazioni = {"RUBRICA",
                    "[1] Ricerca libro",
                    "[2] Prenota",
                    "[3] Prendi in prestito"};
            do {
                // Switch case per la gestione delle diverse opzioni del menu
                switch (menu(operazioni, input)){
                    //case 1:
                }
            }while (fine);
        } else if (log == 2) {
            String[] operazioni = {"RUBRICA",
                    "[1] Ricerca libro",
                    "[2] Prenota",
                    "[3] Prendi in prestito",
                    "[4] Aggiungi libro",
                    "[5] Togli libro"};
            do {
                // Switch case per la gestione delle diverse opzioni del menu
                switch (menu(operazioni, input)) {
                    case 1:
                }
            }while (fine);


        }

    }
}