package service;

import data.Toy;

import java.util.*;


public class ToyFactory {
    private static Map<ToyType,Integer> toyWeight;
    private List<Toy> list = new ArrayList<>();


    public enum ToyType {
        DOLL, CAR, ROBOT, STUFFED, RANDOM
    }

    static {
    toyWeight = Map.of(ToyType.CAR,300,ToyType.DOLL,250,ToyType.ROBOT,350,ToyType.STUFFED,300);
    }

    private Toy createToy(ToyType type) {
        return switch (type) {
            case CAR -> Toy.create("Car",toyWeight.get(ToyType.CAR));
            case DOLL -> Toy.create("Doll",toyWeight.get(ToyType.DOLL));
            case ROBOT -> Toy.create("Robot",toyWeight.get(ToyType.ROBOT));
            case STUFFED -> Toy.create("Stuffed toy",toyWeight.get(ToyType.STUFFED));
            case RANDOM -> createToy(ToyType.values()[(int)(Math.random() * 4)]);
        };
    }

    public List<Toy> createToys(ToyType type, int count) {
        list.clear();
        if (type == ToyType.RANDOM) {
            return createToys(count);
        } else {
            for (int i = 0; i < count; i++) {
                list.add(createToy(type));
            }
        }
        return new ArrayList<>(list);
    }

    public List<Toy> createToys(int count) {
        list.clear();
        for (int i = 0; i < count; i++) {
            list.add(createToy(ToyType.RANDOM));
        }
        return new ArrayList<>(list);
    }


}
