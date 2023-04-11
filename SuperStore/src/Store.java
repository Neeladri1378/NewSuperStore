import java.util.ArrayList;

//Store Class
public class Store {
    private String name;
    private ArrayList<Product> products;

    public Store(String name) {
        this.name = name;
        this.products = new ArrayList<Product>();

       

        products.add(new Product("Flareon Base 1st Edition", "Old", 2000));
        products.add (new Product("Aerodactyl", "Old", 40));
        products.add (new Product("Vaporeon", "Old", 4));
        products.add (new Product("Pikachu Base Edition", "Old", 1000));
        products.add ( new Product("Base Edition Mewtoo", "Old", 1500));
        products.add (new Product("Zenith Pikachu", "Fullart", 100));
        products.add ( new Product("Brilliant Stars Charizard", "Fullart", 100));
        products.add ( new Product("PSA 10 Rosa", "Fullart", 1000));
        products.add ( new Product("Pop 1 Misty", "Fullart", 10000));
        products.add ( new Product("Giovanni Scheme", "Fullart", 100));
        products.add ( new Product("Voltarion", "Holo Rare", 5000));
        products.add ( new Product("Xyerneus", "Holo Rare", 1000));
        products.add ( new Product("White Kyrius", "Holo Rare", 3500));
        
    }

//   // Method to sell a product at a specific index to the player
    public void sellProduct(int product2) {
        //Get product from store
        Product product = this.products.get(product2);
       //Remove the product from the store
        this.products.remove(product2);
        
        Player.getPlayer().addToInventory(product);
    }

    //Method to get list of products from the storee
    public ArrayList<Product> getProducts() {
        return this.products;
    }


 public String getName() {
        return this.name;
    }


}

//Player class
class Player {
    private int money;
    private ArrayList<Product> inventory;
    private static Player player;
//Constructor for player
    private Player(int money) {
    //initializes money and inventory
        this.money = money;
        this.inventory = new ArrayList<Product>();
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player(10000);
        }
        return player;
    }
//Method to get the money of the player
    public int getMoney() {
        return this.money;
    }

    
//Method to set money for player
    public void setMoney(int money) {
        this.money = money;
    }
//method to add product to inventory
    public void addToInventory(Product product) {
        this.inventory.add(product);
    }
//method to remove product from inventroy
    public void removeFromInventory(int index) {
        this.inventory.remove(index);
    }
//method to get inventory
    public ArrayList<Product> getInventory() {
        return this.inventory;
    }
 
//Buy Product
    public void buyProduct(Store store, int index) {
        Product product = store.getProducts().get(index);
        int cost = product.getCost();
        if (cost > this.money) {
            System.out.println("You don't have enough money to buy this product.");
            return;
        }
        this.money -= cost;
        store.sellProduct(index);
        System.out.println("You bought " + product.getName() + " for " + cost + " dollars.");
    }
//Sell Product 
    public void sellProduct(Store store, int index) {
        Product product = this.inventory.get(index);
        String rarity = product.getRarity();
        int cost;
        if (rarity.equals("Old")) {
            cost = product.getCost() * 2;
        } else if (rarity.equals("Fullart")) {
            cost = product.getCost() * 5;
        } else {
            cost = product.getCost() * 10;
        }
        this.removeFromInventory(index);
        this.money += cost;
        System.out.println("You sold " + product.getName() + " for " + cost + " dollars.");
    }
}

class Product {
    private String name;
    private String rarity;
    private int cost;

    public Product(String name, String rarity, int cost) {
        this.name = name;
        this.rarity = rarity;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public String getRarity() {
        return this.rarity;
    }

    public int getCost() {
        return this.cost;
    }


{
}
}
// I used many short methods so it was easier for me to break down the code
//Many short methods are also good for this code as there are many actions that the player will be able to do 