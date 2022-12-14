package interfaces;

import clasess.Market;
import clasess.Person;
import enums.Products;

import java.util.List;

public interface MarketInterface {
      String savedPerson();
      String createMarket();
      List<Products>searchProducts();
      String marketsAddress();
      String getCheck();
      List<Products>products();


}
