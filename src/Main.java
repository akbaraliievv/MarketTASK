import clasess.Market;
import clasess.Person;
import enums.Banks;
import enums.Country;
import enums.Products;
import interfaces.MarketImpl;
import interfaces.MarketInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MarketImpl markets = new MarketImpl();
        outerLoop:
        while(true){
            System.out.println("1.Create Person");
            System.out.println("2.Create Market");
            System.out.println("3.Get all Products");
            System.out.println("4.Search Product from Market");
            System.out.println("5.Get Market Address");
            System.out.println("6.Get Check");
            int option = new Scanner(System.in).nextInt();
            switch (option){
                case 0 -> {
                    break outerLoop;
                }
                case 1 -> System.out.println(markets.savedPerson());
                case 2-> System.out.println(markets.createMarket());
                case 3 -> System.out.println(markets.products());
                case 4 -> System.out.println(markets.searchProducts());
                case 5 -> System.out.println(markets.marketsAddress());
                case 6 -> System.out.println(markets.getCheck());

            }
        }


    }
}