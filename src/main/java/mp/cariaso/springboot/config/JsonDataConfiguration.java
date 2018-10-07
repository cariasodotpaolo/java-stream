package mp.cariaso.springboot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import mp.cariaso.springboot.model.VehicleDataJson;
import mp.cariaso.springboot.model.VehicleDataJsonList;
import mp.cariaso.springboot.service.DataBuilderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonDataConfiguration {

    @Bean(name = "yamlObjectMapper")
    public ObjectMapper yamlObjectMapper() {
        return new ObjectMapper(new YAMLFactory());
    }

    @Bean(name = "vehicleDataJsonList")
    public VehicleDataJsonList getVehicleData(DataBuilderService dataBuilderService) throws IOException {
        return dataBuilderService.getJsonData();
    }

}
