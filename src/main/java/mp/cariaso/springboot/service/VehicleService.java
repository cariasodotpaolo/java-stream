package mp.cariaso.springboot.service;

import java.util.List;
import mp.cariaso.springboot.model.VehicleData;

public interface VehicleService {

    VehicleData get(String dealerId);

    List<String> getVehicleTypes(String dealerId);

    List<String> getEngines(String dealerId);

    List<String> getManufacturers(String dealerId);

    List<String> getDealerIds();

    boolean isEngineDataAvailable(String dealerId);

    boolean isVehicleTypeDataEnabled(String dealerId);

    boolean dealerExists(String dealerId);
}
