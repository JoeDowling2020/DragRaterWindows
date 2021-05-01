package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import nokeynoshade.DragQueen;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.nokeynoshade.party/api/queens/89");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        DragQueen dragQueen = mapper.readValue(response, DragQueen.class);
        String expectedQueenName = "Trixie Matel";
        String actualName = DragQueen.getName();
        assertEquals(expectedQueenName, actualName);
    }
}