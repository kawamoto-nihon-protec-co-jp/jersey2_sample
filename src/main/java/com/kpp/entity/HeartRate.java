package com.kpp.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = HeartRateListener.class)
@Table(name = "HEART_RATE")
public class HeartRate {

    /**  */
    @Column(name = "idHEART_RATE")
    Integer idheartRate;

    /** 
     * Returns the idheartRate.
     * 
     * @return the idheartRate
     */
    public Integer getIdheartRate() {
        return idheartRate;
    }

    /** 
     * Sets the idheartRate.
     * 
     * @param idheartRate the idheartRate
     */
    public void setIdheartRate(Integer idheartRate) {
        this.idheartRate = idheartRate;
    }
}