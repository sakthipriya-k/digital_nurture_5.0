
/*
Exercise 1:
Mocking and Stubbing

Objective:
Demonstrate mocking and stubbing concepts.
*/

// Simulated service
class ProductService {

    public String getProductName() {

        return "Laptop";

    }

}

// Mock object
class MockProductService extends ProductService {

    @Override
    public String getProductName() {

        return "Mock Product";

    }

}

public class Exercise1MockingAndStubbing {

    public static void main(String[] args) {

        // Create mock object
        ProductService service =
                new MockProductService();

        // Stubbed response
        String result =
                service.getProductName();

        System.out.println(
                "Product: " + result
        );

    }

}