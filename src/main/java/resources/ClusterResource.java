package resources;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.util.convert.StringConversionUtil;

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
//    @Produces({"application/javascript",MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
    public JsonList getMessage(@Context HttpServletResponse res) {
        tx.begin();
        HealthInfoDao dao = new HealthInfoDaoImpl();
        List<HealthInfo> datas = dao.selectAll();
        tx.commit();
        List<JsonBean> beans = new ArrayList<JsonBean>();
        for (HealthInfo entity : datas) {
            JsonBean bean = new JsonBean();
            bean.userId = entity.getUserId();
            bean.heartRate = StringConversionUtil.toString(entity.getHeartRate());
            bean.assayDate = StringConversionUtil.toString(entity.getAssayDate());
            beans.add(bean);
        }
        JsonList json = new JsonList();
        json.data = beans;
        LinkedHashMap<String, JsonBean> m = new LinkedHashMap<String, JsonBean>();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
        return json;
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
