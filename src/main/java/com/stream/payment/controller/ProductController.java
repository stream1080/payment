package com.stream.payment.controller;


import com.stream.payment.entity.Product;
import com.stream.payment.service.ProductService;
import com.stream.payment.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author stream
 * @since 2021-12-26
 */
@RestController
@Api(tags = "商品管理")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation("商品列表")
    @GetMapping("/list")
    public R list(){

        List<Product> list = productService.list(null);
        return R.ok().data("productList", list);
    }

}

