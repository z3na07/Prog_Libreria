import java.util.Random;

public class RandomStringGenerator {
    public static String generateRandomString(int length) {

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