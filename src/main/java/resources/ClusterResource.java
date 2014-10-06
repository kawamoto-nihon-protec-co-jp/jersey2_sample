package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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

    @GET
    @Path("{id}")
    public Cluster getCluster(@PathParam("id") String id) {
        Cluster c = new Cluster();
        c.setId(Integer.valueOf(id));
        c.setName("GF Cluster");
        return c;
    }
}
