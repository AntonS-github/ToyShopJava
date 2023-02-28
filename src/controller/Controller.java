package controller;

import fasade.IMachinesFasade;
import fasade.SlotMachinesFasade;
import view.SlotMachineView;

import java.util.Arrays;
import java.util.Scanner;


public class Controller {
    static Scanner scanner = new Scanner(System.in);
    private SlotMachineView slotMachineView = new SlotMachineView();

    public void start() {
        slotMachineView.hello();
        IMachinesFasade app = new SlotMachinesFasade();
        app.addMachines(this.requestCountMachines());
        app.loadToys();
        slotMachineView.help();
        while (true) {
            requestCommand(app);
        }
    }

    private void requestCommand(IMachinesFasade app) {
        slotMachineView.printMessage("Введите команду: ");
        switch (getNextInt()) {
            case 1 -> slotMachineView.help();
            case 2 -> slotMachineView.printMachines(app.getListMachine());
            case 3 -> requestProduct(app);
            default -> slotMachineView.inputError();
        }
    }

    public int requestCountMachines() {
        slotMachineView.printMessage("Введите кол-во игровых автоматов: ");
        int count = this.getNextInt();
        if ((count != 0)) {
            slotMachineView.printMessage("Созданно игровых автоматов: " + count + "\n");
        } else {
            slotMachineView.inputError();
        }
        return count;
    }

    public void requestProduct(IMachinesFasade app) {
        slotMachineView.printMessage("Введите Id автомата и игрушки (через пробел): ");
        int[] input = (Arrays.stream(scanner.nextLine().strip().split(" "))
                .filter(this::isInteger)
                .mapToInt(Integer::parseInt).toArray());
        if (input.length == 2) {
            if(app.isProductAvailable(input[0],input[1])) {
                slotMachineView.resultGame(app.getProduct(input[0], input[1]));
                return;
            }
        }
        slotMachineView.inputError();
    }

    public int getNextInt() {
        String str = scanner.nextLine();
        if (isInteger(str)) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    public boolean isInteger(String str) {
        return str.matches("^\\d+$");
    }
}
