package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Machine<P extends Product> {

    private long id;
    private List<P> loadProduct;
    private static long countMachine;

    static {
        countMachine = 0;
    }

    protected Machine(long id, List<P> loadProduct) {
        this.id = id;
        this.loadProduct = loadProduct;
        countMachine++;
    }

    public static <P extends Product> Machine create(List<P> loadToys, int springCompressionForce) {
        return new Machine<P>(countMachine + 1,loadToys);
    }

    public static <P extends Product> Machine create(int springCompressionForce) {
        List<Toy> list = Collections.emptyList();
        return Machine.create((List<P>) list,springCompressionForce);
    }

    public static <P extends Product> Machine create() {
        return Machine.create(5);
    }

    public Product getProduct(int productId) {
        for (var prod:loadProduct) {
            if (prod.getId() == productId) {
                return loadProduct.remove(loadProduct.indexOf(prod));
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        loadProduct.add((P) product);
    }

    public long getId() {
        return id;
    }

    public List<P> getLoadProducts() {
        return loadProduct;
    }

    public static long getCountMachine() {
        return countMachine;
    }

    public void loadProducts(List<P> toys) {
        this.loadProduct = toys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine<?> that = (Machine<?>) o;
        return id == that.id && loadProduct.equals(that.loadProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loadProduct);
    }

    @Override
    public String toString() {
        return "SlotMachine{" +
                "id=" + id +
                ", loadToys=" + loadProduct +
                '}';
    }
}
