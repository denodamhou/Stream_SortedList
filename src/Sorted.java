import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sorted {
    public static void main(String[] args) {
        List<Laptop> pc = new ArrayList<>();

        pc.add(new Laptop("ROG", 120));
        pc.add(new Laptop("MSI", 150));
        pc.add(new Laptop("Dell", 100));
        pc.add(new Laptop("Lenovo", 1500));
        pc.add(new Laptop("Acer", 1070));
        pc.add(new Laptop("Asus", 50));
        pc.add(new Laptop("Gigabyte", 10));

    while (true){
        System.out.println("Select option by typing number:");
        System.out.println("1. View 100 Range Laptop");
        System.out.println("2. View 1000 Range Laptop");
        System.out.println("3. Sort alphabet Laptop name");


        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                List<Laptop> hundredRange = pc.stream()
                        .filter(laptop -> laptop.price>=100)
                        .collect(Collectors.toList());
                hundredRange.forEach(laptop -> System.out.println(laptop.brand));

                break;
            case 2:
                List<Laptop> thousandRange = pc.stream()
                        .filter(laptop -> laptop.price>=1000)
                        .collect(Collectors.toList());
                thousandRange.forEach(laptop -> System.out.println(laptop.brand));

                break;
            case 3:
                List<Laptop>sortedList = pc.stream()
                        .sorted(Comparator.comparing(laptop -> laptop.brand))
                        .collect(Collectors.toList());
                sortedList.forEach(laptop -> System.out.println(laptop.brand));
                break;
            default:
                System.out.println("No such an option!");
        }
    }


//        //stream for 100 price range pc
//        List<Laptop> hundredRange = pc.stream()
//                .filter(laptop -> laptop.price>=1000)
//                .collect(Collectors.toList());
//        //end of stream price range



        //for loop
//        List<Laptop> hundredRange = new ArrayList<>();
//
//        for(Laptop l : pc){
//            if (l.price >=1000){
//                hundredRange.add(l);
//            }
//        }
        //end for loop
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
