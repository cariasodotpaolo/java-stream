package mp.cariaso.springboot.service;


import java.io.IOException;
import mp.cariaso.springboot.model.VehicleDataJson;
import mp.cariaso.springboot.model.VehicleDataJsonList;

public interface DataBuilderService {

    VehicleDataJsonList getJsonData()throws IOException;

}
