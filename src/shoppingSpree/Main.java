package shoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> p = new ArrayList<>();
        List<String> persons = new ArrayList<>();
        persons = Arrays.stream(sc.nextLine().split(";")).collect(Collectors.toList());
        for (int i = 0; i < persons.size(); i++) {
            List<String> person = new ArrayList<>();
            person = Arrays.stream(persons.get(i).split("=")).collect(Collectors.toList());
            p.add(new Person(person.get(0), Double.parseDouble(person.get(1))));
        }
        List<Product> prod = new ArrayList<>();
        List<String> products = new ArrayList<>();
        products = Arrays.stream(sc.nextLine().split(";")).collect(Collectors.toList());
        for (int i = 0; i < products.size(); i++) {
            List<String> product = new ArrayList<>();
            product = Arrays.stream(products.get(i).split("=")).collect(Collectors.toList());
            prod.add(new Product(product.get(0), Double.parseDouble(product.get(1))));
        }

        while (true){
            String[] input = sc.nextLine().split(" ");
            if(input[0].equals("END")){
                for (int i = 0; i < p.size(); i++) {
                    System.out.printf("%s - ", p.get(i).getName());
                    if (p.get(i).getProducts().isEmpty()){
                        System.out.printf("Nothing bought%n");
                    }else {
                        for (int j = 0; j < p.get(i).getProducts().size(); j++) {
                            if (j!=p.get(i).getProducts().size()-1){
                                System.out.printf("%s, ", p.get(i).getProducts().get(j).getName());
                            }else {
                                System.out.printf("%s", p.get(i).getProducts().get(j).getName());
                            }

                        }
                        System.out.println();
                    }
                }
                break;
            }
            String name = input[0];
            String productName = input[1];
            Person person = null;
            Product product = null;
            for (int i = 0; i < p.size(); i++) {
                if(p.get(i).getName().equals(name)){
                    person = p.get(i);
                }
            }
            for (int i = 0; i < prod.size(); i++) {
                if (prod.get(i).getName().equals(productName)){
                    product = prod.get(i);
                }
            }
            person.buyProduct(product);
        }

    }
}
