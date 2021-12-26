package com.stream.payment.controller;


import com.stream.payment.entity.OrderInfo;
import com.stream.payment.enums.OrderStatus;
import com.stream.payment.service.OrderInfoService;
import com.stream.payment.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author stream
 * @since 2021-12-26
 */
@CrossOrigin
@Api(tags = "商品订单管理")
@RestController
@RequestMapping("/api/order-info")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation("订单列表")
    @GetMapping("/list")
    public R list(){

        List<OrderInfo> list = orderInfoService.listOrderByCreateTimeDesc();
        return R.ok().data("list", list);
    }

    /**
     * 查询本地订单状态
     * @param orderNo
     * @return
     */
    @ApiOperation("查询本地订单状态")
    @GetMapping("/query-order-status/{orderNo}")
    public R queryOrderStatus(@PathVariable String orderNo){

        String orderStatus = orderInfoService.getOrderStatus(orderNo);
        if(OrderStatus.SUCCESS.getType().equals(orderStatus)){
            return R.ok().setMessage("支付成功"); //支付成功
        }

        return R.ok().setCode(101).setMessage("支付中......");
    }

}

