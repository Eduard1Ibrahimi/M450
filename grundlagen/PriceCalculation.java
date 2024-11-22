import java.util.Scanner;

public class PriceCalculation {
    public static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;

        // Determine the discount based on the number of extras
        if (extras >= 5) {
            addon_discount = 15;
        } else if (extras >= 3) {
            addon_discount = 10;
        } else {
            addon_discount = 0;
        }

        // Use the dealer discount if it is greater than the addon discount
        if (discount > addon_discount) {
            addon_discount = discount;
        }

        // Calculate the total price
        result = baseprice / 100.0 * (100 - discount) + specialprice
                + extraprice / 100.0 * (100 - addon_discount);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user inputs
        System.out.print("Enter base price: ");
        double baseprice = scanner.nextDouble();

        System.out.print("Enter special price: ");
        double specialprice = scanner.nextDouble();

        System.out.print("Enter extra price: ");
        double extraprice = scanner.nextDouble();

        System.out.print("Enter number of extras: ");
        int extras = scanner.nextInt();

        System.out.print("Enter dealer discount (in percentage): ");
        double discount = scanner.nextDouble();

        // Calculate the price
        double finalPrice = calculatePrice(baseprice, specialprice, extraprice, extras, discount);

        // Print the result
        System.out.println("The calculated total price is: " + finalPrice);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}

//Code umgebaut mit Benutzereingaben und Ausgabe zum Einsehen der Resultate