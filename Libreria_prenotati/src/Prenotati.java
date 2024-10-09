public class Prenotati {
        private boolean prenotato;
        private String codiceFiscale;


    @Override
    public String toString() {
        return String.format(" prenotato: %b, codice fiscale: %s", prenotato, codiceFiscale);
    }
}