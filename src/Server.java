import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(4999);
        System.out.println("Waiting");

        Socket connection = serversocket.accept();
        System.out.println("connected");



        List<Sorted.Laptop> pc = new ArrayList<>();

        pc.add(new Sorted.Laptop("ROG", 100));
        pc.add(new Sorted.Laptop("MSI", 300));
        pc.add(new Sorted.Laptop("Dell", 400));
        pc.add(new Sorted.Laptop("Lenovo",600 ));
        pc.add(new Sorted.Laptop("Gigabyte", 1000));
        pc.add(new Sorted.Laptop("Asus",1100 ));
        pc.add(new Sorted.Laptop("Acer", 1200));

        while(true){

            InputStream inputstream = connection.getInputStream();
            Scanner scanner = new Scanner(inputstream);
            int option = scanner.nextInt();
            switch(option) {
                case 1:
                    List<Sorted.Laptop> hundredRange = pc.stream()
                            .filter(laptop -> laptop.price < 1000)
                            .collect(Collectors.toList());
//                    hundredRange.forEach(laptop -> System.out.println(laptop.brand));
                    String hundredRangeString = sortLaptopToString(hundredRange);
                    sendResponse(connection, hundredRangeString);
                    break;
                case 2:
                    List<Sorted.Laptop> thousandRange = pc.stream()
                            .filter(laptop -> laptop.price >= 1000)
                            .collect(Collectors.toList());
//                    thousandRange.forEach(laptop -> System.out.println(laptop.brand));
                    String thousandRangeString = sortLaptopToString(thousandRange);
                    sendResponse(connection, thousandRangeString);
                    break;
                case 3:
                    List<Sorted.Laptop>sortedList = pc.stream()
                            .sorted(Comparator.comparing(laptop -> laptop.brand))
                            .collect(Collectors.toList());
//                    sortedList.forEach(laptop -> System.out.println(laptop.brand));
                    String sortedListString = sortLaptopToString(sortedList);
                    sendResponse(connection, sortedListString);
                    break;
                case 4:
                    List<Sorted.Laptop> hundredSortedRange = pc.stream()
                            .filter(laptop -> laptop.price < 1000)
                            .sorted(Comparator.comparing(laptop -> laptop.brand))
                            .collect(Collectors.toList());
//                    hundredSortedRange.forEach(laptop -> System.out.println(laptop.brand));
                    String hundredSortedRangeString = sortLaptopToString(hundredSortedRange);
                    sendResponse(connection, hundredSortedRangeString);
                    break;
                case 5:
                    List<Sorted.Laptop> thousandSortedRange = pc.stream()
                            .filter(laptop -> laptop.price >= 1000)
                            .sorted(Comparator.comparing(laptop -> laptop.brand))
                            .collect(Collectors.toList());
//                    thousandSortedRange.forEach(laptop -> System.out.println(laptop.brand));
                    String thousandSortedRangeString = sortLaptopToString(thousandSortedRange);
                    sendResponse(connection, thousandSortedRangeString);
                    break;
                default:
                    System.out.println("No such an option!");
            }
        }



    }
    private static void sendResponse(Socket connection,String response) throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write(response+"\r\n");
        printWriter.flush();
        System.out.println(response);
    }
    private static String sortLaptopToString( List<Sorted.Laptop> listSortedLaptop){
        String listLaptop = null;
        List<String> list = new ArrayList<String>();
        listSortedLaptop.forEach(laptop -> list.add(laptop.brand));
        listLaptop = list.toString();
        return listLaptop;
    }
}
