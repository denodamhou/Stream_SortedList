import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sorted {
    public static void main(String[] args) {
        List<Laptop> pc = new ArrayList<>();

        pc.add(new Laptop("ROG", 100));
        pc.add(new Laptop("MSI", 300));
        pc.add(new Laptop("Dell", 400));
        pc.add(new Laptop("Lenovo",600 ));
        pc.add(new Laptop("Gigabyte", 1000));
        pc.add(new Laptop("Asus",1100 ));
        pc.add(new Laptop("Acer", 1200));

    while (true){
        System.out.println("Select option by typing number:");
        System.out.println("1. View 100 Range Laptop");
        System.out.println("2. View 1000 Range Laptop");
        System.out.println("3. Sort alphabet Laptop name");
        System.out.println("4. Sort alphabet Laptop name in 100 price range");
        System.out.println("5. Sort alphabet Laptop name in 1000 price range");


        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                List<Laptop> hundredRange = pc.stream()
                        .filter(laptop -> laptop.price < 1000)
                        .collect(Collectors.toList());
                hundredRange.forEach(laptop -> System.out.println(laptop.brand));

                break;
            case 2:
                List<Laptop> thousandRange = pc.stream()
                        .filter(laptop -> laptop.price >= 1000)
                        .collect(Collectors.toList());
                thousandRange.forEach(laptop -> System.out.println(laptop.brand));

                break;
            case 3:
                List<Laptop>sortedList = pc.stream()
                        .sorted(Comparator.comparing(laptop -> laptop.brand))
                        .collect(Collectors.toList());
                sortedList.forEach(laptop -> System.out.println(laptop.brand));
                break;
            case 4:
                List<Laptop> hundredSortedRange = pc.stream()
                        .filter(laptop -> laptop.price < 1000)
                        .sorted(Comparator.comparing(laptop -> laptop.brand))
                        .collect(Collectors.toList());
                hundredSortedRange.forEach(laptop -> System.out.println(laptop.brand));

                break;
            case 5:
                List<Laptop> thousandSortedRange = pc.stream()
                        .filter(laptop -> laptop.price >= 1000)
                        .sorted(Comparator.comparing(laptop -> laptop.brand))
                        .collect(Collectors.toList());
                thousandSortedRange.forEach(laptop -> System.out.println(laptop.brand));

                break;
            default:
                System.out.println("No such an option!");
        }
    }


    }
    static class Laptop{
        String brand;
        int price;
        public Laptop(String brand, int price){
            this.brand = brand;
            this.price = price;
        }

    }
}
