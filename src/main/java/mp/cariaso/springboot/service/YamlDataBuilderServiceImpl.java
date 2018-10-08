package mp.cariaso.springboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import mp.cariaso.springboot.model.VehicleDataJsonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service("yamlDataBuilderService")
@Slf4j
public class YamlDataBuilderServiceImpl implements DataBuilderService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    @Qualifier("yamlObjectMapper")
    private ObjectMapper yamlObjectMapper;

    @Value("${vehicle.dealer.data.file}")
    private String vehicleDealerDataFile;


    @Override
    public VehicleDataJsonList getJsonData() throws IOException {


        VehicleDataJsonList vehicleDataJsonList;

        Resource dataResource = resourceLoader.getResource(vehicleDealerDataFile);

        if (dataResource.exists()) {
            vehicleDataJsonList = yamlObjectMapper.readValue(dataResource.getInputStream(), VehicleDataJsonList.class);
        }
        else {
            throw new FileNotFoundException("Yaml data file not found: " + vehicleDealerDataFile);
        }

        return vehicleDataJsonList;
    }

}
