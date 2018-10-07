package mp.cariaso.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;
import lombok.Getter;

@Getter
public class VehicleTypeData {

    @JsonProperty("vehicleTypes")
    private List<VehicleType> vehicleTypes;

    @JsonSetter("vehicleTypes")
    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

}
