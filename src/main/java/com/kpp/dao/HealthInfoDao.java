package com.kpp.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.kpp.config.AppConfig;
import com.kpp.entity.HealthInfo;

/**
 */
@Dao(config = AppConfig.class)
public interface HealthInfoDao {

    @Select
    List<HealthInfo> selectAll();

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(HealthInfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(HealthInfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(HealthInfo entity);
}