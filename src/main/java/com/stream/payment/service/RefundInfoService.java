package com.stream.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.payment.entity.RefundInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stream
 * @since 2021-12-26
 */
public interface RefundInfoService extends IService<RefundInfo> {

    RefundInfo createRefundByOrderNo(String orderNo, String reason);

    void updateRefund(String content);

    List<RefundInfo> getNoRefundOrderByDuration(int minutes);

}
