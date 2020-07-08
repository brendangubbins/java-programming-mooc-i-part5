
public class PaymentTerminal {
    
    private static final double AFF_PRICE = 2.5;
    private static final double HEA_PRICE = 4.3;

    private double money;  // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals


    public PaymentTerminal() {
        // register initially has 1000 euros of money
        this.money = 1000;
        this.affordableMeals = 0;
        this.heartyMeals = 0;
    }

    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        // increase the amount of cash by the price of an affordable mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        if (payment < AFF_PRICE) {
            return payment;
        }
        this.money += AFF_PRICE;
        this.affordableMeals++;
        return payment - AFF_PRICE;    
    }

    public double eatHeartily(double payment) {
        // a hearty meal costs 4.30 euros
        // increase the amount of cash by the price of a hearty mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        if (payment < HEA_PRICE) {
            return payment;
        } 
        this.money += HEA_PRICE;
        this.heartyMeals++;
        return payment - HEA_PRICE;
    }
    
    public boolean eatAffordably(PaymentCard card) {
        if (card.takeMoney(AFF_PRICE)) {
            this.affordableMeals++;
            return true;
        }
        return false;
    }
    
    public boolean eatHeartily(PaymentCard card) {
        if (card.takeMoney(HEA_PRICE)) {
            this.heartyMeals++;
            return true;
        }
        return false;
    }
    
    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum >= 0) {
            card.addMoney(sum);
            this.money += sum;
        }
    }

    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
