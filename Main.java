import java.util.LinkedList;

public class Main {

    // creates two linked lists, the main one and the copy one
    static LinkedList<Pizza> pizzaList = new LinkedList<>();
    static LinkedList<Pizza> pizzaList2 = new LinkedList<>();

    // initializes all the pizza objects for the list
    static Pizza veggie = new Pizza("thin crust", "tomato", 12, 3);
    static Pizza meatLover = new Pizza("thick crust", "barbecue", 14, 5);
    static Pizza pepperoni = new Pizza("regular crust", "marinara", 10, 2);
    static Pizza hawaiian = new Pizza("thin crust", "pineapple", 12, 4);
    static Pizza meatLover2 = new Pizza("thick crust", "barbecue", 14, 5);
    static Pizza veggie2 = new Pizza("thin crust", "tomato", 12, 3);

    //this method takes the given node and removes the node after the give one else it does nothing
    public static void removeAfter(Pizza node) {
        // iterates through the linked list
        for (int i = 0; i < pizzaList.size(); i++) {
            Pizza pElement = pizzaList.get(i);
            // if the pizza equals the inputted pizza node the next node is removed and the loop ends
            if (pElement.equals(node)) {
                try {
                    pElement = pizzaList.get(i + 1);
                    pizzaList.remove(pElement);
                    break;
                    // if there's no node after the inputted node, the error runs and nothing happens
                } catch (Exception exception) {
                    break;
                }
            }
        }
    }

    // copies the pizza list starting from the specified node until the end of the list
    public static LinkedList<Pizza> copy(Pizza node) {
        // iterate through the list starting from the input node
        for (int count = pizzaList.indexOf(node); count < pizzaList.size(); count++) {
            // add each pizza to the copy list
            pizzaList2.add(pizzaList.get(count));
        }
        return pizzaList2;
    }

    // removes duplicate pizzas, keeping the node at the specified key
    public static void removeDuplicate(Pizza node, int key) {
        // iterates through the linked list
        for (int i = 0; i < pizzaList.size(); i++) {
            // if there's a pizza with the same attributes as the one inputted, that other pizza gets removed
            if (pizzaList.get(i).getCrust().equals(node.getCrust()) && pizzaList.get(i).getSauce().equals(node.getSauce()) && pizzaList.get(i).getDiameter() == node.getDiameter() && pizzaList.get(i).getToppingAmount() == node.getToppingAmount() && i != key) {
                Pizza pElement = pizzaList.get(i);
                pizzaList.remove(pElement);
            }
        }
    }

    // finds the pizza with the maximum diameter starting from the specified node
    public static String max(Pizza node) {
        // initialize variables
        String name = "";
        int maxDiameter = 0;
        // iterates through the list from the inputted node
        for (int count = pizzaList.indexOf(node); count < pizzaList.size(); count++) {
            // if the pizza's diameter is larger than the previous maximum, the max diameter and crust type is updated
            if (maxDiameter < pizzaList.get(count).getDiameter()) {
                name = pizzaList.get(count).getCrust();
                maxDiameter = pizzaList.get(count).getDiameter();
            }
        }
        // If no pizza is found, this message is displayed
        if (maxDiameter == 0) {
            return "No pizza found";
        }
        return "The largest pizza has a " + name + " crust and a diameter of " + maxDiameter + " inches.";
    }

    public static void main(String[] args) {
        System.out.println("WELCOME TO THE PIZZA SHOP!");

        // adds all pizza objects to the linked list
        pizzaList.add(veggie);
        pizzaList.add(meatLover);
        pizzaList.add(pepperoni);
        pizzaList.add(hawaiian);
        pizzaList.add(meatLover2);
        pizzaList.add(veggie2);

        // displays the type of crust for the first six pizzas in the list
        System.out.println("First: " + pizzaList.getFirst().getCrust() + " pizza");
        System.out.println("Second: " + pizzaList.get(1).getCrust() + " pizza");
        System.out.println("Third: " + pizzaList.get(2).getCrust() + " pizza");
        System.out.println("Fourth: " + pizzaList.get(3).getCrust() + " pizza");
        System.out.println("Fifth: " + pizzaList.get(4).getCrust() + " pizza");
        System.out.println("Sixth: " + pizzaList.getLast().getCrust() + " pizza");

        System.out.println();
        // Use the copy method and show that it creates a copy of the original list.
        System.out.println("copying the list");
        System.out.println("Copied: " + "\n" + copy(veggie)); // copied list
        System.out.println("Original: " + "\n" + pizzaList); // original list

        System.out.println();
        // Use the max method to find the pizza with the largest diameter.
        System.out.println("searching for pizza with max diameter");
        System.out.println(max(veggie));
        System.out.println(max(pepperoni));

        System.out.println();
        // Use the removeAfter method to remove a pizza after the specified node.
        System.out.println("usage of removeAfter");
        removeAfter(meatLover);
        System.out.println("No change: " + "\n" + pizzaList);

        System.out.println();
        // Use the removeDuplicate method to remove duplicate pizzas.
        System.out.println("usage of removeDuplicate");
        removeDuplicate(meatLover2, 4); // Keep the second meat pizza and remove the first one
        System.out.println("Duplicate pizzas removed: " + "\n" +  pizzaList);
    }
}