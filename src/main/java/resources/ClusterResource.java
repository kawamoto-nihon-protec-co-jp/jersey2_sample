package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.seasar.doma.jdbc.tx.LocalTransaction;

import com.kpp.config.AppConfig;
import com.kpp.dao.HeartRateDao;
import com.kpp.dao.HeartRateDaoImpl;
import com.kpp.entity.HeartRate;

import core.TransData;

@Path("/admin")
public class ClusterResource {
    LocalTransaction tx = AppConfig.getLocalTransaction();

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
        // 開始
        tx.begin();
        HeartRateDao dao = new HeartRateDaoImpl();
        HeartRate entity = new HeartRate();
        entity.setIdheartRate(Integer.parseInt(data.getData()));
        dao.insert(entity);
        // コミット
        tx.commit();
        TransData responseData = new TransData();
        responseData.setData(data.getData());
        return responseData;
    }
}
