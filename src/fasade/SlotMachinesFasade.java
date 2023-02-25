package fasade;

import data.Machine;
import data.Product;
import service.MachineService;
import service.ToyFactory;
import util.UtilTxt;

import java.util.List;
import java.util.Random;

public class SlotMachinesFasade implements IMachinesFasade {
    private MachineService machineService = new MachineService();
    private ToyFactory toyFactory = new ToyFactory();
    private static Random random = new Random();


    public void addMachines(int count) {
        machineService.create(count);
    }

    public void loadToys() {
        machineService.getMachines().stream().forEach(o -> o.loadProducts(toyFactory.createToys(10)));
    }

    public Product getProduct(int machineId, int productId) {
        Machine machine = machineService.getMachineById(machineId);
        Product product = machine.getProduct(productId);
        int weightProd = product.getWeight();
        if (weightProd*1/(random.nextInt(4) + 1) >= weightProd) {
            String textToLog = "Machine ID:" + machineId + " " + product.getClass().getSimpleName() + " " + product;
            UtilTxt.write("src/resources/prizes.txt", textToLog);
            return product;
        }else {
            machine.addProduct(product);
            return null;
        }
    }

    public List<Machine> getListMachine() {
        return machineService.getMachines();
    }

    public List<Product> getListProduct(int machineId) {
        return machineService.getMachineById(machineId).getLoadProducts();
    }

    public boolean isProductAvailable(int machineId, int productId) {
        return machineService.isMachineHaveProduct(machineId,productId);
    }

}
