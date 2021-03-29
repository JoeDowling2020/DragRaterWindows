package week9;

import entity.Role;
import persistence.GenericDao;
import util.Database;
import entity.Role;
import entity.User;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class Users {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getMessage() {
        // Return the users and roles
        GenericDao roleDao;
        GenericDao userDao;
        roleDao = new GenericDao(Role.class);
        userDao = new GenericDao(User.class);
        List<Role> roles = roleDao.getAll();
        List<User> users = userDao.getAll();
        StringBuilder output1 = new StringBuilder();
        StringBuilder output2 = new StringBuilder();


        for(int i = 0; i < roles.size(); i++) {
            output1.append(roles.get(i).getUser());
            output1.append(roles.get(i).getRoleTitle());
            output1.append("\n");
        }

        String output = output1.toString();
        return Response.status(200).entity(output).build();
    }
}
