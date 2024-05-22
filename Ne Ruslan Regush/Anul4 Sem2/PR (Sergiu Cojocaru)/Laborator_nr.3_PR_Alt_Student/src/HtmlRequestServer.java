import java.io.*;
import java.net.*;

public class HtmlRequestServer {
    private static final int PORT = 6000; // Schimbăm portul dacă este necesar

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serverul ascultă pe portul " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Eroare la pornirea serverului: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // Citește cererea clientului (presupunem că clientul trimite ceva)
            String clientRequest = in.readLine();

            // Conectează la serverul web fcim.utm.md și cere pagina HTML
            URL url = new URL("http://fcim.utm.md");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Citește răspunsul serverului web
            BufferedReader webIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = webIn.readLine()) != null) {
                content.append(inputLine).append("\n");
            }

            // Închide resursele
            webIn.close();

            // Trimite conținutul HTML înapoi clientului
            out.println(content.toString());

        } catch (IOException e) {
            System.out.println("Eroare în comunicarea cu clientul: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Eroare la închiderea conexiunii cu clientul: " + e.getMessage());
            }
        }
    }
}
