import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket connection = new Socket("localhost", 4999);
        while (true) {
            System.out.println("Select option by typing number:");
            System.out.println("1. View 100 Range Laptop");
            System.out.println("2. View 1000 Range Laptop");
            System.out.println("3. Sort alphabet Laptop name");
            System.out.println("4. Sort alphabet Laptop name in 100 price range");
            System.out.println("5. Sort alphabet Laptop name in 1000 price range");


            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            sendRequest(connection, Integer.toString(option));
            getResponse(connection);

        }
    }

    private static void sendRequest(Socket connection, String request) throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write(request+"\r\n");
        printWriter.flush();
        System.out.println(request);
    }

    private static void getResponse(Socket connection) throws IOException {
        // Read data from the server
        InputStream inputStream = connection.getInputStream();
        System.out.println("Receiving from server...");
        Scanner scanner = new Scanner(inputStream);
        String response = scanner.nextLine();
        System.out.println(response);
    }
}
