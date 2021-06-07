package sample.database;

public class Products {
    private int id;
    private String name;
    private String quantity;
    private  String expiryDate;
    public Products(int id, String name, String quantity, String expiryDate){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getExpiryDate(){
        return expiryDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
