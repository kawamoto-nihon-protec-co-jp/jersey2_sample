package resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
//	@Produces(MediaType.APPLICATION_ATOM_XML)
    public Cluster getCluster(/*@PathParam("id") String id*/) {
        Cluster c = new Cluster();
        c.setId(Integer.valueOf("35"));
        c.setName("GF Cluster");
        return c;
    }
}
