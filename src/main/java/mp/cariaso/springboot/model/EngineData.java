package mp.cariaso.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;
import lombok.Getter;

@Getter
public class EngineData {

    @JsonProperty("manufacturers")
    private List<Manufacturer> manufacturers;

    @JsonProperty("engines")
    private List<Engine> engines;

    @JsonSetter("manufacturers")
    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    @JsonSetter("engines")
    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }

}
