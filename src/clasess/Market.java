package clasess;

import enums.Products;

import java.time.LocalTime;
import java.util.List;

public class Market {
    private String MarketName;
    private List<Products> products;
    private String address;
    private Long marketAccount;

    public Market(String marketName, List<Products> products, String address,Long marketAccount) {
        MarketName = marketName;
        this.products = products;
        this.address = address;
        this.marketAccount = marketAccount;
    }

    public Long getMarketAccount() {
        return marketAccount;
    }

    public void setMarketAccount(Long marketAccount) {
        this.marketAccount = marketAccount;
    }

    public String getMarketName() {
        return MarketName;
    }

    public void setMarketName(String marketName) {
        MarketName = marketName;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Market{" +
                "MarketName='" + MarketName + '\'' +
                ", products=" + products +
                ", address='" + address + '\'' +
                ", marketAccount=" + marketAccount +
                '}';
    }
}
