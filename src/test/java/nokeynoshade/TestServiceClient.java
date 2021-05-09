package nokeynoshade;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dragRaceAPI.DragQueensItem;
import entity.DragQueen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testDragQueenAPI() throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://www.nokeynoshade.party/api/queens/89");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        DragQueensItem dragQueen = mapper.readValue(response, DragQueensItem.class);
        String expectedName = "Trixie Mattel";
        assertEquals(expectedName, dragQueen.getName());
    }



}