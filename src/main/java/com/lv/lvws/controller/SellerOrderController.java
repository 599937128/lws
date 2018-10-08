package com.lv.lvws.controller;

import com.lv.lvws.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @program: lvws
 * @Date: 2018/10/7 12:16
 * @Author: Mr.lv
 * @Description:
 */
@Controller
@RequestMapping("/order")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public ModelAndView create(Map<String, String> map) {
        String result = orderService.crete();
        map.put("crrateResult", result);
        return new ModelAndView("order/list", map);
    }

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("order/list");
    }
}
