package service;

import data.Product;
import data.Machine;

import java.util.ArrayList;
import java.util.List;

public class MachineService {
    private static List<Machine> machines = new ArrayList<>();

    public void create(int count) {
        for (int i = 0; i < count; i++) {
            machines.add(Machine.create());
        }
    }

    public boolean removeById(int machineId) {
        return machines.removeIf(o -> o.getId() == machineId);
    }

    public Machine getMachineById(int machineId) {
        for (var machine: machines) {
            if (machine.getId() == machineId) {
                return machine;
            }
        }
        return null;
    }

    public void loadProductToMachine(int machineId, List<Product> list) {
        Machine machine = getMachineById(machineId);
        machine.loadProducts(list);
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public boolean isMachineAvailable(int machineId) {
        for (var machine:machines) {
            if (machine.getId() == machineId)
                return true;
        }
        return false;
    }
    public boolean isMachineHaveProduct(int machineId,int productId) {
        if (!this.isMachineAvailable(machineId)) {
            return false;
        }
        List<Product> list = this.getMachineById(machineId).getLoadProducts();
        for (var prod:list) {
            if (prod.getId() == productId) {
                return true;
            }
        }
        return false;
    }
}
