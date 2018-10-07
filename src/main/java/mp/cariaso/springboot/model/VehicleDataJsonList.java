package mp.cariaso.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class VehicleDataJsonList {

   @JsonProperty("vehicleDataJsonList")
   private List<VehicleDataJson> vehicleDataJsonList;

}
