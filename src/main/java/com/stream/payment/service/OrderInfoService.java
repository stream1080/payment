package com.stream.payment.service;

import com.stream.payment.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.payment.enums.OrderStatus;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stream
 * @since 2021-12-26
 */
public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 获取订单状态
     *
     * @param orderNo
     * @return
     */
    String getOrderStatus(String orderNo);

    List<OrderInfo> listOrderByCreateTimeDesc();

    OrderInfo createOrderByProductId(Long productId);

    void saveCodeUrl(String orderNo, String codeUrl);

    void updateStatusByOrderNo(String orderNo, OrderStatus orderStatus);

    List<OrderInfo> getNoPayOrderByDuration(int minutes);

    OrderInfo getOrderByOrderNo(String orderNo);
}
