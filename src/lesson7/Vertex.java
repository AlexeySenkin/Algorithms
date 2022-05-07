package lesson7;

public class Vertex {
    public String label;
    public boolean wasVisited;
    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
    }

    public String getLabel() {
        return "{" + label + "} ";
    }

    public boolean isWasVisited() {
        return wasVisited;
    }
}
