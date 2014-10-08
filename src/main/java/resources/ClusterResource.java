package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import core.TransData;

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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public TransData getCluster(TransData data) {
//	//public Cluster getCluster() {
//        Cluster c = new Cluster();
//        c.setId(Integer.valueOf("30"));
//        c.setName("GF Cluster");
		TransData responseData = new TransData();
		responseData.setData(data.getData());
        return responseData;
    }
}
