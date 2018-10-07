package mp.cariaso.springboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDataJson {

    @JsonProperty("vehicleData")
    private VehicleData vehicleData;

    @JsonProperty("vehicleData")
    public VehicleData getVehicleData() {
        return vehicleData;
    }

    @JsonProperty("vehicleData")
    public void setVehicleData(VehicleData vehicleData) {
        this.vehicleData = vehicleData;
    }

}