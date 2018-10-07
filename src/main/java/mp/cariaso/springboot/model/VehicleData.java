package mp.cariaso.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehicleData {

    @JsonProperty("dealerName")
    private String dealerName;

    @JsonProperty("dealerId")
    private String dealerId;

    @JsonProperty("deliverySchedule")
    private String deliverySchedule;

    @JsonProperty("vehicleTypes")
    private VehicleTypeData vehicleTypeData;

    @JsonProperty("engines")
    private EngineData engineData;
}
