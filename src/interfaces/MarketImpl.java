package interfaces;

import clasess.Market;
import clasess.Person;
import enums.Banks;
import enums.Country;
import enums.Products;

import java.util.*;

public class MarketImpl implements MarketInterface {
    List<Person> persons = new ArrayList<>();
    List<Market> markets = new ArrayList<>();

    @Override
    public String savedPerson() {
        try {

            System.out.println("Write your name :");
            String name = new Scanner(System.in).nextLine().toUpperCase();
            if (name.isEmpty()) throw new Exception("Names can't be null...");
            System.out.println("Write your age :");
            int age = new Scanner(System.in).nextInt();
            if (age < 0) throw new Exception("Age can't be less than 0...");
            System.out.println("Write bank account : ");
            long bankAccount = new Scanner(System.in).nextLong();
            if (bankAccount < 0 || bankAccount > 10000) throw new Exception("Bank Account can't be less than 0...");
            System.out.println("Write your password ");
            int password = new Scanner(System.in).nextInt();
            if (password > 0 || password < 6) throw new Exception("Password can't be lass 0 or greater than 4...");
            Person person = new Person("Dastan", 19, Country.KYRGYZSTAN, Banks.OPTIMA, 6000L);
            Person person2 = new Person("Ilim", 19, Country.KYRGYZSTAN, Banks.KYRGYZSTAN, 3000L);
            persons.add(person);
            persons.add(person2);
            return "Customer created successfully.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String createMarket() {
        try {
            System.out.print("Market Name : ");
            String marketName = new Scanner(System.in).nextLine();
            if (marketName.isEmpty()) throw new Exception("Market name can't be Empty.");

            System.out.print("Write a store address : ");
            String address = new Scanner(System.in).nextLine();
            if (address.isEmpty()) throw new Exception("Address can't be Empty.");

            System.out.print("Would you like include products (yes/no) : ");
            String includeProducts = new Scanner(System.in).next().toLowerCase();
            if (includeProducts.isEmpty()) throw new Exception("Answer can't be Empty.");

            List<Products> products;
            if (includeProducts.equals("yes")) products = new ArrayList<>(List.of(Products.values()));
            else products = new ArrayList<>();

            List<Products> newCart = new ArrayList<>();

            Market newMarket = new Market("Frunze", Arrays.asList(Products.CHOCOLATE, Products.BANANA, Products.BREAD, Products.MILK), "Vostok-5", 500000L);
            Market newMarket2 = new Market("Globus", Arrays.asList(Products.CHOCOLATE, Products.BANANA, Products.BREAD, Products.MILK), "Tunguch", 6000000L);

            markets.add(newMarket);
            markets.add(newMarket2);

            return "Market created successfully.";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sorry. Something went wrong";
    }


    @Override
    public String marketsAddress() {
        System.out.print("Write a market name : ");
        String marketName = new Scanner(System.in).nextLine().toLowerCase();
        if (marketName.isEmpty()) {
        }
        for (Market market : markets) {
            if (market.getMarketName().toLowerCase().equals(marketName))
                return market.getAddress();
        }
        return null;
    }

    @Override
    public List<Products> products() {
        try {
            System.out.print("Write a market name : ");
            String marketName = new Scanner(System.in).nextLine().toLowerCase();
            if (marketName.isEmpty()) throw new Exception("Market name can't be Empty.");

            for (Market market : markets) {
                if (market.getMarketName().toLowerCase().equals(marketName))
                    return market.getProducts();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Products> searchProducts() {
        List<Products> productsList = new ArrayList<>();
        try {
            System.out.print("Write a market name : ");
            String marketName = new Scanner(System.in).nextLine().toLowerCase();
            if (marketName.isEmpty()) throw new Exception("Market name can't be Empty.");

            for (Market market : markets) {
                if (market.getMarketName().toLowerCase().equals(marketName)) {
                    System.out.print("Write a product name : ");
                    String productName = new Scanner(System.in).nextLine().toLowerCase();
                    if (productName.isEmpty()) throw new Exception("Product name can't be Empty.");
                    for (Products product : market.getProducts()) {
                        if (product.name().toLowerCase().contains(productName)) productsList.add(product);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productsList;
    }


    @Override
    public String getCheck() {
        List<Person> personList = new ArrayList<>();
        List<Market> markets1 = new ArrayList<>();
        try {
            ArrayList<Products> products1 = new ArrayList<>();
            products1.clear();

            Map<String, Double> productDiscount = new LinkedHashMap<>();
            productDiscount.clear();

            System.out.println("Your name : ");
            String yourName = new Scanner(System.in).nextLine();

            if (yourName.isEmpty()) return "Field cannot be empty";

            double totalPrice = 0;
            double priceAll = 0;

            for (Person person : personList) {
                if (person.getFullName().toLowerCase().equals(yourName.toLowerCase())) {

                    for (Market market : markets1) {
                        System.out.println(market.getMarketName() + " ");
                    }

                    System.out.println("\nSelect market : ");


                    String nameMarket = new Scanner(System.in).nextLine();

                    for (Market market : markets1) {
                        if (market.getMarketName().toLowerCase().equals(nameMarket.toLowerCase())) {

                            System.out.println("\n" + market.getMarketName() + "products : " + market.getProducts() + "\n");

                            while (true) {
                                System.out.println("Will you buy something? (yes/no) : ");
                                String yesOrNo = new Scanner(System.in).nextLine();

                                if (yesOrNo.equals("yes")) {

                                    System.out.println("What will you buy : ");
                                    System.out.println(market.getProducts());
                                    String nameProduct = new Scanner(System.in).nextLine();

                                    for (Products product : market.getProducts()) {
                                        if (product.getName().toUpperCase().equals(nameProduct.toUpperCase())) {

                                            products1.add(product);
                                            priceAll += product.getPrice();


                                            if (product.getDiscount() == 0) {
                                                totalPrice += product.getPrice();
                                            } else {
                                                totalPrice += product.getPrice() - product.getPrice() * product.getDiscount();
                                            }

                                            if (product.getDiscount() != 0) {
                                                productDiscount.put(product.getName(), product.getDiscount());
                                            }
                                        }
                                    }
                                } else {
                                    person.setBankAccount((long) (person.getBankAccount() - totalPrice));
                                    market.setMarketAccount((long) (market.getMarketAccount() + totalPrice));
                                    return "=====================================" +
                                            "\nBayer : " + person.getFullName() +
                                            "\nMarket : " + market.getMarketName() +
                                            "\nProducts : " + products1 +
                                            "\nTotal cost of goods : " + priceAll +
                                            "\nDiscount : " + productDiscount +
                                            "\nTotal price after discount : " + totalPrice +
                                            "\n=====================================" +
                                            "\nThank you for your purchase\n";

                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

