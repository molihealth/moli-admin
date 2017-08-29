package com.moli.admin.repository.moli;

import com.moli.admin.domain.moli.SmsOrderUnicom;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by gary on 17/8/26.
 */
public interface MoliOrderRepository extends PagingAndSortingRepository<SmsOrderUnicom, Integer>, JpaSpecificationExecutor<SmsOrderUnicom> {

    SmsOrderUnicom findByUserNumber(String userNumber);

}
