package lesson5;

import java.util.Objects;

public class Thing {
    private final String description;
    private final double weight;
    private final double price;

    public Thing(String description, double weight, double price) {
        this.description = description;
        this.weight = weight;
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Набор{" +
                "предмет='" + description + '\'' +
                ", вес=" + weight +
                ", цена=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return Double.compare(thing.weight, weight) == 0 && Double.compare(thing.price, price) == 0 && Objects.equals(description, thing.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, price);
    }
}
