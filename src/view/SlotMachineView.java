package view;

import data.Machine;
import data.Product;

import java.util.List;


public class SlotMachineView {

    public void printMessage(String mes) {
        System.out.print(mes);
    }

    public void hello() {
        System.out.println("Добро пожаловать!");
    }

    public void help() {
        System.out.println("1 - Список команд\n2 - Список автоматов и игрушек\n3 - Розыгрыш выбранной игрушки");
    }

    public void inputError() {
        System.out.println("Введено неккоректное значение!");
    }

    public void printMachines(List<Machine> list) {
        for (var machine:list) {
            System.out.println("Игровой автомат Id: " + machine.getId());
            for (var obj:machine.getLoadProducts()) {
                Product product = (Product) obj;
                System.out.println("Id: " + product.getId() + " Product: " + product.getName());
            }
        }
    }

    public void resultGame(Product prod) {
        String result = prod == null ? "Не получилось выйграть игрушку(" : "Ура! Вы выйграли " + prod.getName();
        System.out.println(result);
    }
}
