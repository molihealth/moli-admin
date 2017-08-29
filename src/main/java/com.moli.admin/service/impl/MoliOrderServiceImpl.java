package com.moli.admin.service.impl;

import com.moli.admin.domain.moli.SmsOrderUnicom;
import com.moli.admin.repository.moli.MoliOrderRepository;
import com.moli.admin.service.MoliOrderService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gary on 17/8/26.
 */
@Service
public class MoliOrderServiceImpl implements MoliOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoliOrderService.class);

    @Autowired
    private MoliOrderRepository moliOrderRepository;

    @Override
    public SmsOrderUnicom queryByMobile(String mobile) {
        LOGGER.info(">>>>>>begin queryByMobile, mobile is {}.", mobile);
        if (StringUtils.isBlank(mobile)) {
            return null;
        }
        return moliOrderRepository.findByUserNumber(mobile);
    }

}
