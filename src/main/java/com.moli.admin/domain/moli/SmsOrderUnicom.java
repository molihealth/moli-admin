package com.moli.admin.domain.moli;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by gary on 17/8/26.
 */
@Entity
@Table(name = "smsorder_unicom")
public class SmsOrderUnicom implements Serializable {

    private static final long serialVersionUID = 6228626448546698549L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected  Integer id;

    @Column(name = "Sequence")
    protected String sequence;

    @Column(name = "UserNumber")
    protected String userNumber;

    @Column(name = "SpNumber")
    protected String spNumber;

    @Column(name = "SpId")
    protected String spId;

    @Column(name = "OrderTime")
    protected Date orderTime;

    @Column(name = "EffectiveTime")
    protected Date effectiveTime;

    @Column(name = "ExpireTime")
    protected Date expireTime;

    @Column(name = "ServiceId")
    protected String serviceId;

    @Column(name = "ServiceName")
    protected String serviceName;

    @Column(name = "Content")
    protected String content;

    @Column(name = "EncodeStr")
    protected String encodeStr;

    /**
     * 手机归属地
     */
    @Column(name = "MobileCity")
    protected String mobileCity;

    /**
     * 当月流量赠送状态(1成功  2失败)
     */
    @Column(name = "FlowState")
    protected Integer flowState;

    /**
     * 退订时间
     */
    @Column(name = "UnsubscribeTime")
    protected Date unsubscribeTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getSpNumber() {
        return spNumber;
    }

    public void setSpNumber(String spNumber) {
        this.spNumber = spNumber;
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEncodeStr() {
        return encodeStr;
    }

    public void setEncodeStr(String encodeStr) {
        this.encodeStr = encodeStr;
    }

    public String getMobileCity() {
        return mobileCity;
    }

    public void setMobileCity(String mobileCity) {
        this.mobileCity = mobileCity;
    }

    public Integer getFlowState() {
        return flowState;
    }

    public void setFlowState(Integer flowState) {
        this.flowState = flowState;
    }

    public Date getUnsubscribeTime() {
        return unsubscribeTime;
    }

    public void setUnsubscribeTime(Date unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }

    @Override
    public String toString() {
        return "SmsOrderUnicom{" +
                "id=" + id +
                ", sequence='" + sequence + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", spNumber='" + spNumber + '\'' +
                ", spId='" + spId + '\'' +
                ", orderTime=" + orderTime +
                ", effectiveTime=" + effectiveTime +
                ", expireTime=" + expireTime +
                ", serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", content='" + content + '\'' +
                ", encodeStr='" + encodeStr + '\'' +
                ", mobileCity='" + mobileCity + '\'' +
                ", flowState=" + flowState +
                ", unsubscribeTime=" + unsubscribeTime +
                '}';
    }
}
