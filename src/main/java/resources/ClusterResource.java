package resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.seasar.doma.jdbc.tx.LocalTransaction;

import com.kpp.config.AppConfig;
import com.kpp.dao.HealthInfoDao;
import com.kpp.dao.HealthInfoDaoImpl;
import com.kpp.entity.HealthInfo;

import core.JsonBean;
import core.JsonList;
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
    @GET
    @Path("/getMessage")
//    @JSONP
    @Produces({"application/javascript",MediaType.APPLICATION_JSON})
//    @Produces(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        System.out.println("--------------getMessage");
//        ObjectMapper mapper = new ObjectMapper();
        HealthInfoDao dao = new HealthInfoDaoImpl();
        tx.begin();
        List<HealthInfo> list = dao.selectAll();
        tx.commit();
        List<String> li = new ArrayList<String>();
        li.add("80");
        li.add("90");
        JsonList json = new JsonList();
        json.list = li;
        JsonBean responseData = new JsonBean();
        responseData.foo = "kawamoto";
        responseData.bar = "80";
//        try {
//            String js = mapper.writeValueAsString(responseData);
//        } catch (IOException e) {
//            // TODO 自動生成された catch ブロック
//            e.printStackTrace();
//        }
        String response = "{\"data\":[{\"id\":\"kawamoto@nihon-protec.co.jp\",\"name\":\"kawamoto\"}]}";
        return response;
//        return new CurrentDate("kawamoto");
    }

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
        HealthInfoDao dao = new HealthInfoDaoImpl();
        HealthInfo entity = new HealthInfo();
        entity.setHeartRate(Integer.parseInt(data.getData()));
        dao.insert(entity);
        // コミット
        tx.commit();
        TransData responseData = new TransData();
        responseData.setData(data.getData());
        return responseData;
    }
}
