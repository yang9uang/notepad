package com.young.notepad.web.controller;

import com.young.notepad.web.entity.Offer;
import com.young.notepad.web.feign.service.AdminService;
import com.young.notepad.web.service.IOfferService;
import com.young.notepad.web.util.R;
import org.apache.servicecomb.pack.omega.context.annotations.SagaStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author young
 * @since 2020-12-10
 */
@RestController
@RequestMapping("/web/offer")
public class OfferController {

    @Autowired
    IOfferService iOfferService;

    @Autowired
    AdminService adminService;

    @SagaStart(timeout = 20)
    @Transactional
    @GetMapping("/get")
    public R get() {
        List<Offer> list = iOfferService.list();
        Offer offer = list.get(0);
        offer.setAppCaps("test app caps...");

        iOfferService.updateById(offer);

        adminService.get();

        return R.SUCCESS();
    }
}
