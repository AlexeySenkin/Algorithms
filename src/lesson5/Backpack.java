package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final double capacity;
    private final List<Thing> things;

    private List<Thing> bestCombination = null;
    private double bestCombinationPrice = 0;

    public Backpack(double capacity, List<Thing> things) {
        this.capacity = capacity;
        this.things = things;
    }

    private void checkCombination(List<Thing> things) {
        if (calcCombinationWeight(things) <= this.capacity
                && calcCombinationPrice(things) > this.bestCombinationPrice) {
            this.bestCombination = things;
            this.bestCombinationPrice = calcCombinationPrice(things);
        }
    }

    public void createCombinations(List<Thing> things) {
        checkCombination(things);
        for (int i = 0; i < things.size(); i++) {
            List<Thing> newCombination = new ArrayList<>(things);
            newCombination.remove(i);
            createCombinations(newCombination);
        }
    }

    public List<Thing> bestCombination() {
        if (calcCombinationWeight(this.things) <= this.capacity) {
            return this.things;
        } else {
            createCombinations(this.things);
        }
        return this.bestCombination;
    }

    private double calcCombinationPrice(List<Thing> things) {
        double price = 0;
        for (Thing thing : things) {
            price += thing.getPrice();
        }
        return price;
    }

    private double calcCombinationWeight(List<Thing> things) {
        double weight = 0;
        for (Thing thing : things) {
            weight += thing.getWeight();
        }
        return weight;
    }


}
