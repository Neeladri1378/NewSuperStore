import java.util.ArrayList;
import java.util.Scanner;

//import Store.Player;
//import Store.Product;

public class Game {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store("Pokemon Trading Cards");

        // Create a new player
        Player player = Player.getPlayer();
    
        Scanner scanner = new Scanner(System.in);

        // Print the store inventory
        System.out.println("Welcome to " + store.getName() + "!");
        System.out.println("Here's what we have in stock:");
        ArrayList<Product> products = store.getProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println(i + ". " + product.getName() + " (" + product.getRarity() + ") - " + product.getCost() + " dollars");
        }

        // Player buys a card
        System.out.print("Enter the number of the product you want to buy: ");
        int productIndex = scanner.nextInt();
        player.buyProduct(store, productIndex);
        System.out.println("You now have " + player.getMoney() + " dollars and the following items in your inventory:");
        ArrayList<Product> inventory = player.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Product product = inventory.get(i);
            System.out.println(i + ". " + product.getName() + " (" + product.getRarity() + ") - " + product.getCost() + " dollars");
        }

        // Player sells a card
        System.out.print("Enter the number of the product you want to sell: ");
        int inventoryIndex = scanner.nextInt();
        player.sellProduct(store, inventoryIndex);
        System.out.println("You now have " + player.getMoney() + " dollars and the following items in your inventory:");
        for (int i = 0; i < planyer.getInventory().size(); i++) {
            Product product = player.getInventory().get(i);
            System.out.println(i + ". " + product.getName() + " (" + product.getRarity() + ") - " + product.getCost() + " dollars");
        }
    }
}
