package mp.cariaso.springboot.service;

import static java.util.Objects.isNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import mp.cariaso.springboot.model.Engine;
import mp.cariaso.springboot.model.Manufacturer;
import mp.cariaso.springboot.model.VehicleData;
import mp.cariaso.springboot.model.VehicleDataJson;
import mp.cariaso.springboot.model.VehicleDataJsonList;
import mp.cariaso.springboot.model.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    @Qualifier("vehicleDataJsonList")
    private VehicleDataJsonList vehicleDataJsonList;

    private Map<String, VehicleData> vehicleDataMap;
    private Map<String, List<String>> vehicleTypes;
    private Map<String, List<String>> engines;
    private Map<String, List<String>> manufacturers;
    private List<String> dealerIds;


    @Override
    public VehicleData get(String siteId) {
        return vehicleDataMap.get(siteId.toUpperCase());
    }

    @Override
    public List<String> getVehicleTypes(String siteId) {
        return vehicleTypes.get(siteId.toUpperCase());
    }

    @Override
    public List<String> getEngines(String siteId) {
        return engines.get(siteId.toUpperCase());
    }

    @Override
    public List<String> getManufacturers(String siteId) {
        return manufacturers.get(siteId.toUpperCase());
    }

    @Override
    public List<String> getDealerIds() {
        return dealerIds;
    }

    @Override
    public boolean isEngineDataAvailable(String siteId) {

        return !isNull(vehicleDataMap.get(siteId.toUpperCase()).getEngineData());
    }

    @Override
    public boolean isVehicleTypeDataEnabled(String siteId) {

        return !isNull(vehicleDataMap.get(siteId.toUpperCase()).getVehicleTypeData());
    }

    @Override
    public boolean dealerExists(String siteId) {

        VehicleData vehicleData = vehicleDataMap.get(siteId.toUpperCase());

        return !isNull(vehicleData);
    }

    @PostConstruct
    private void initialize() {

        List<VehicleDataJson> siteControllerConfigList = vehicleDataJsonList.getVehicleDataJsonList();

        List<VehicleData> vehicleDataList = siteControllerConfigList.stream()
                                                     .map(VehicleDataJson::getVehicleData)
                                                     .collect(Collectors.toList());

        vehicleDataMap = vehicleDataList.stream().collect(
                                Collectors.toMap(data -> data.getDealerId().toUpperCase(), data -> data));

        vehicleTypes = vehicleDataList.stream()
                                       .filter(data -> !isNull(data.getVehicleTypeData()))
                                       .collect(Collectors.toMap(sc -> sc.getDealerId().toUpperCase(),
                                                sc -> sc.getVehicleTypeData().getVehicleTypes()
                                                        .stream().map(VehicleType::getType)
                                       .collect(Collectors.toList())));

        engines = vehicleDataList.stream()
                                      .filter(data -> !isNull(data.getEngineData()))
                                      .collect(Collectors.toMap(data -> data.getDealerId().toUpperCase(),
                                                data -> data.getEngineData().getEngines()
                                                    .stream().map(Engine::getModel)
                                      .collect(Collectors.toList())));

        manufacturers = vehicleDataList.stream()
                                      .filter(data -> !isNull(data.getEngineData()))
                                      .collect(Collectors.toMap(sc -> sc.getDealerId().toUpperCase(),
                                                sc -> sc.getEngineData().getManufacturers()
                                                    .stream().map(Manufacturer::getName)
                                      .collect(Collectors.toList())));

        dealerIds = vehicleDataMap.keySet().stream().collect(Collectors.toList());
    }

}
