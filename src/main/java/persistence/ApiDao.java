package persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dragRaceAPI.DragQueensItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.PropertiesLoader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Properties;

public class ApiDao implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger();
    public static final String PROPERTIES_PATH = "/application.properties";
    public static final String PROPERTY_URL = "URL";

    private Properties properties;

    public ApiDao() {
        properties = loadProperties(PROPERTIES_PATH);
    }

    public List<DragQueensItem> getAllDragQueens() throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://www.nokeynoshade.party/api/queens/all");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<DragQueensItem> dragQueens = mapper.readValue(response, new TypeReference<List<DragQueensItem>>(){});
        return dragQueens;
    }
}
