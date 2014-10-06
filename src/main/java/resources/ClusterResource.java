package resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import core.Cluster;

@Path("/admin")
public class ClusterResource {

//    @GET
//    @Path("{data}")
//    public String getCluster(@PathParam("data") String data) {
//        System.out.println("kawamoto----"+ data);
//        Cluster c = new Cluster();
//        c.setId(Integer.valueOf(data));
//        c.setName("GF Cluster");
//        return "POST DATA RECEIVED. data[]";
//    }

	@POST
	@Path("/putMessage")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Cluster getCluster() {
        Cluster c = new Cluster();
        c.setId(Integer.valueOf("25"));
        c.setName("GF Cluster");
        return c;
    }
}
