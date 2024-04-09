public class Pizza {
    // declares variables
    private String crust;
    private String sauce;
    private int diameter;
    private int toppingAmount;


    // pizza constructor with crust, sauce, diameter, and topping amount defining it
    public Pizza(String crust, String sauce, int diameter, int toppingAmount) {
        this.crust = crust;
        this.sauce = sauce;
        this.diameter = diameter;
        this.toppingAmount = toppingAmount;
    }

    //toString to format the output
    @Override
    public String toString() {
        return "Pizza with " + crust +", " + sauce + " sauce, " +
                "diameter: " + diameter + " inches, topping amount: " + toppingAmount  + System.lineSeparator();
    }


    // getters and setters for crust, sauce, diameter, and topping amount
    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getToppingAmount() {
        return toppingAmount;
    }

    public void setToppingAmount(int toppingAmount) {
        this.toppingAmount = toppingAmount;
    }
}
