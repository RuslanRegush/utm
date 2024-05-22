import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        String input = ""; // Intrarea utilizatorului

        // Verifică dacă utilizatorul a furnizat un argument
        if (args.length > 0) {
            input = args[0];
        } else {
            System.out.println("Introduceți un domeniu sau o adresă IP ca argument.");
            return;
        }

        try {
            InetAddress inetAddress = InetAddress.getByName(input);

            // Verifică dacă este o adresă IP
            if (inetAddress.getHostAddress().equals(input)) {
                // Returnează domeniul asociat cu adresa IP
                System.out.println("Domeniul asociat cu adresa IP '" + input + "': " + inetAddress.getHostName());
            } else {
                // Returnează adresa IP asociată cu domeniul
                System.out.println("Adresa IP asociată cu domeniul '" + input + "': " + inetAddress.getHostAddress());

                // Returnează înregistrările MX (Mail Exchange) dacă este un domeniu
                try {
                    InetAddress[] mxRecords = getMXRecords(input);
                    System.out.println("Inregistrari MX pentru domeniul '" + input + "':");
                    for (InetAddress mxRecord : mxRecords) {
                        System.out.println(mxRecord.getHostName());
                    }
                } catch (UnknownHostException e) {
                    System.out.println("Nu s-au găsit înregistrări MX pentru domeniul '" + input + "'.");
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Nu s-a putut găsi informația pentru '" + input + "': " + e.getMessage());
        }
    }

    // Metodă pentru a obține înregistrările MX (Mail Exchange) pentru un domeniu
    private static InetAddress[] getMXRecords(String domain) throws UnknownHostException {
        return InetAddress.getAllByName(domain);
    }
}