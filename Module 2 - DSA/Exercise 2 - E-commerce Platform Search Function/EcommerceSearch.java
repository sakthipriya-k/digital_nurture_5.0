class Product {

    int productId;
    String productName;
    double price;

    Product(int id, String name, double price) {
        this.productId = id;
        this.productName = name;
        this.price = price;
    }

    void display() {
        System.out.println(
                productId + " | " +
                productName + " | ₹" +
                price);
    }
}

public class EcommerceSearch {

    public static Product searchProduct(
            Product[] products,
            String searchName) {

        for (Product product : products) {

            if (product.productName
                    .equalsIgnoreCase(searchName)) {

                return product;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101,"Laptop",50000),
                new Product(102,"Phone",25000),
                new Product(103,"Headset",3000),
                new Product(104,"Mouse",1000)
        };

        String search = "Phone";

        Product result =
                searchProduct(products, search);

        if(result != null){

            System.out.println("Product Found");
            result.display();

        } else {

            System.out.println("Product Not Found");
        }
    }
}