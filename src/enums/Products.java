package enums;

public enum Products {
    MILK("MILK",100,0.2),
    BREAD("Bread",50),
    OIL("Oil",160),
    BANANA("Banana",120),
    CHOCOLATE("Chocolate",60,0.3),
    WATER("Legenda",80,0.4),
    SALT("Salt",95,0.5),
    YOGHURT("Yoghurt",150),
    PEPSI("Pepsi",70),
    MEAT("Meat",450);
    private String name;
    private int price;
    private double discount;

    Products(String name, int price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    Products(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
