package lab6.apteka;

public class Medicine {
    public String name;
    public int positive;
    public int price;
    public int stock;

    public Medicine(String name, int positive, int price, int stock) {
        this.name = name;
        this.positive = positive;
        this.price = price;
        this.stock = stock;
    }

    public boolean order(int quantity) {
        if (quantity > stock) {
            return false;
        } else {
            this.stock -= quantity;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%d%n%d", name.toUpperCase(), positive == 1 ? "POZ" : "NEG", price, stock);
    }
}