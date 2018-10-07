package mp.cariaso.springboot.service;

import java.util.List;
import mp.cariaso.springboot.model.VehicleData;

public interface VehicleService {

    VehicleData get(String siteId);

    List<String> getVehicleTypes(String siteId);

    List<String> getEngines(String siteId);

    List<String> getManufacturers(String siteId);

    List<String> getDealerIds();

    boolean isEngineDataAvailable(String siteId);

    boolean isVehicleTypeDataEnabled(String siteId);

    boolean dealerExists(String siteId);
}
