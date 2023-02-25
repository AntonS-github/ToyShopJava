package data;

import java.util.Objects;

public class Toy extends Product {

    private static long countToys;

    static {
        countToys = 0;
    }

    protected Toy(long id, String name, int weight) {
        super(name,weight);
        super.setId(id);
        countToys++;
    }


    public static Toy create(String name, int probability) {
        return new Toy(countToys + 1,name,probability);
    }

    public static Toy create(String name) {
        return Toy.create(name,100);
    }

    public static Toy create() {
        return Toy.create("Toy");
    }

    public static long getCountToys() {
        return countToys;
    }



    @Override
    public String toString() {
        return "Toy{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", weight=" + super.getWeight() +
                '}';
    }
}
