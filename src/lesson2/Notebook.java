package lesson2;

import java.util.Objects;

public class Notebook {
    protected final int price;
    protected final int ram;
    protected final String brand;
    protected final int brandId;

    public Notebook(int price, int ram, String brand, int vendorId) {
        this.price = price;
        this.ram = ram;
        this.brand = brand;
        this.brandId = vendorId;

    }

    public Notebook(int price, int ram, String brand) {
        this.price = price;
        this.ram = ram;
        this.brand = brand;
        this.brandId = 0;
    }

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public String getBrand() {
        return brand;
    }

    public int getBrandId() {
        return brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return price == notebook.price && ram == notebook.ram && brandId == notebook.brandId && Objects.equals(brand, notebook.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, ram, brand, brandId);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", ram=" + ram +
                ", brand='" + brand + '\'' +
                ", brandId=" + brandId +
                '}';
    }


}
