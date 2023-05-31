package utils;

public class Product {
    private int id;
    private String productName;
    private int productPrice;

    public void setID(int id){
        this.id = id;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice){
        this.productPrice = productPrice;
    }

    public int getId(){
        return id;
    }

    public String getProductName(){
        return this.productName;
    }

    public int getProductPrice(){
        return this.productPrice;
    }

}
