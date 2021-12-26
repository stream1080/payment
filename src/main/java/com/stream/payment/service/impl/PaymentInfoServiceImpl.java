package com.stream.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.stream.payment.entity.PaymentInfo;
import com.stream.payment.enums.PayType;
import com.stream.payment.mapper.PaymentInfoMapper;
import com.stream.payment.service.PaymentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stream
 * @since 2021-12-26
 */
@Service
@Slf4j
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {

    /**
     * 记录支付日志
     * @param plainText
     */
    @Override
    public void createPaymentInfo(String plainText) {

        log.info("记录支付日志");

        Gson gson = new Gson();
        HashMap plainTextMap = gson.fromJson(plainText, HashMap.class);

        //订单号
        String orderNo = (String)plainTextMap.get("out_trade_no");
        //业务编号
        String transactionId = (String)plainTextMap.get("transaction_id");
        //支付类型
        String tradeType = (String)plainTextMap.get("trade_type");
        //交易状态
        String tradeState = (String)plainTextMap.get("trade_state");
        //用户实际支付金额
        Map<String, Object> amount = (Map)plainTextMap.get("amount");
        Integer payerTotal = ((Double) amount.get("payer_total")).intValue();

        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setOrderNo(orderNo);
        paymentInfo.setPaymentType(PayType.WXPAY.getType());
        paymentInfo.setTransactionId(transactionId);
        paymentInfo.setTradeType(tradeType);
        paymentInfo.setTradeState(tradeState);
        paymentInfo.setPayerTotal(payerTotal);
        paymentInfo.setContent(plainText);

        baseMapper.insert(paymentInfo);
    }
}
