class Drink {

    private String name;
    private int price;

    /* (コンストラクタ)nameで名前を指定し，priceで値段を指定する */
    public Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /* 飲み物の名前を返す */
    public String getName() {
        return this.name;
    }

    /* 飲み物の値段を返す */
    public int getPrice() {
        return this.price;
    }
}