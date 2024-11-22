public class PriceCalculationTest {
    public static boolean testCalculatePrice() {
        boolean test_ok = true;

        // Test Case 1
        double price1 = PriceCalculation.calculatePrice(1000, 200, 300, 3, 5);
        if (price1 != 1420.0) {
            System.out.println("Test Case 1 Failed: Expected 1425.0, Got " + price1);
            test_ok = false;
        }

        // Test Case 2
        double price2 = PriceCalculation.calculatePrice(1500, 300, 200, 5, 10);
        if (price2 != 1820.0) {
            System.out.println("Test Case 2 Failed: Expected 1800.0, Got " + price2);
            test_ok = false;
        }

    
        return test_ok;
    }

    public static void main(String[] args) {
        if (testCalculatePrice()) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}

/*2 Testfälle für drei+ und fünf+ Extras.

if (extras >= 3)
    addon_discount = 10;
else if (extras >= 5)
    addon_discount = 15;
else
    addon_discount = 0;
*/
