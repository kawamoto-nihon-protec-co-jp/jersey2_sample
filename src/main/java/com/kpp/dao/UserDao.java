package com.kpp.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.kpp.config.AppConfig;
import com.kpp.entity.User;

/**
 */
@Dao(config = AppConfig.class)
public interface UserDao {

    /**
     * @param userId
     * @return the User entity
     */
    @Select
    User selectById(String userId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(User entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(User entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(User entity);
}