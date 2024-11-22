import java.util.Random;

/**
 * Una classe utility per generare stringhe casuali di lunghezza specificata.
 * L'insieme di caratteri utilizzato per la generazione comprende lettere minuscole (a-z) e numeri (0-9).
 *
 * @author Martino (Hallo5685)
 * @version 1
 */
public class RandomStringGenerator
{

    /**
     * Genera una stringa casuale di una lunghezza specificata utilizzando un insieme di caratteri predefinito.
     * L'insieme dei caratteri comprende lettere minuscole (a-z) e numeri (0-9).
     *
     * @param length La lunghezza della stringa casuale da generare
     *
     * @return Una stringa casuale composta da caratteri dell'insieme predefinito.
     *
     * @throws IllegalArgumentException Se {@code length} è negativo.
     */
    public static String generateRandomString(int length)
    {

        //altre stringhe possibili: ABCDEFGHIJKLMNOPQRSTUVWXYZ
        // Definisci l'insieme di caratteri
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        // Genera una stringa casuale
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
