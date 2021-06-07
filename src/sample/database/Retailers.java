package sample.database;

public class Retailers {
    private int id;
    private String firstName;
    private String lastName;
    private String products;
    private String quantity;
    private  String expiryDate;
    private double price;

    public Retailers(int id, String fname, String lname, String products, String quantity, String expiryDate, double price){
        this.id = id;
        this.firstName = fname;
        this.lastName = lname;
        this.products = products;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProducts() {
        return products;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

