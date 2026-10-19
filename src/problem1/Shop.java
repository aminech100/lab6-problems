package problem1;

import java.util.ArrayList;
import java.util.Scanner;
public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        double total = 0;

        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
            scan.nextLine();
// *** create a new item and add it to the cart
            // *** print the contents of the cart object using println
            cart.add(new Item(itemName, itemPrice, quantity));
            StringBuilder sb = new StringBuilder("\n--- Contenu du Panier ---\n");
            for (int i = 0; i < cart.size(); i++) {
                sb.append("Article : ").append(cart.get(i).getName())
                        .append(" | Prix : $").append(cart.get(i).getPrice())
                        .append(" | Quantité : ").append(cart.get(i).getQuantity())
                        .append("\n");
                total += (cart.get(i).getPrice() * cart.get(i).getQuantity());
            }
            sb.append("Total: $" + total);
            sb.append("\n--------------------------");
            System.out.println(sb);


            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equals("y"));
    }
}
