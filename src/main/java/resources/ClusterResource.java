package resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import core.Cluster;

@Path("/admin")
public class ClusterResource {

    @POST
    @Path("{id}")
    public String getCluster(@PathParam("id") String id) {
        System.out.println("kawamoto----"+id);
        Cluster c = new Cluster();
        c.setId(Integer.valueOf(id));
        c.setName("GF Cluster");
        return "POST DATA RECEIVED. data[]";
    }

//    @GET
//    @Path("{id}")
//    public Cluster getCluster(@PathParam("id") String id) {
//        Cluster c = new Cluster();
//        c.setId(Integer.valueOf(id));
//        c.setName("GF Cluster");
//        return c;
//    }
}
