package fasade;

import data.Machine;
import data.Product;


import java.util.List;

public interface IMachinesFasade<M extends Machine,P extends Product> {
    void addMachines(int count);
    void loadToys();
    P getProduct(int machineId, int productId) ;
    List<M> getListMachine();
    List<P> getListProduct(int machineId);
    boolean isProductAvailable(int machineId, int productId);
}
