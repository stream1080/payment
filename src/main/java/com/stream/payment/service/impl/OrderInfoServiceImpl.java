package com.stream.payment.service.impl;

import com.stream.payment.entity.OrderInfo;
import com.stream.payment.mapper.OrderInfoMapper;
import com.stream.payment.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stream
 * @since 2021-12-26
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
