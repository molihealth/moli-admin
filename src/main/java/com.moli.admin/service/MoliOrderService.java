package com.moli.admin.service;

import com.moli.admin.domain.moli.SmsOrderUnicom;

/**
 * Created by gary on 17/8/26.
 */
public interface MoliOrderService {

    /**
     * 根据手机好查找订单信息
     * @param mobile
     * @return
     */
    SmsOrderUnicom queryByMobile(String mobile);

}
