package com.kpp.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;

import com.kpp.config.AppConfig;
import com.kpp.entity.HeartRate;

/**
 */
@Dao(config = AppConfig.class)
public interface HeartRateDao {

   /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(HeartRate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(HeartRate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(HeartRate entity);
}