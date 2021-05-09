package persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dragRaceAPI.DragQueensItem;
import entity.DragQueen;
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
    //TODO make this part of properties file
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

    public DragQueensItem getDragQueen(int id) throws Exception {

        Client client = ClientBuilder.newClient();
        String apiBase = "http://www.nokeynoshade.party/api/queens/";
        String targetQueen = Integer.toString(id);
        String clientTarget = apiBase.concat(targetQueen);
        WebTarget target = client.target(clientTarget);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        DragQueensItem dragQueen = mapper.readValue(response, DragQueensItem.class);
        return dragQueen;
    }
}
