package com.young.notepad.web.controller;


import com.young.notepad.web.entity.ClientUser;
import com.young.notepad.web.service.IClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author young
 * @since 2020-12-22
 */
@RestController
@RequestMapping("/web/client-user")
public class ClientUserController {

    @Autowired
    IClientUserService iClientUserService;

    //    @Compensable(compensationMethod = "cancel")
    @Transactional
    @GetMapping("/get")
    public String get() throws InterruptedException {
        ClientUser clientUser = new ClientUser();
        clientUser.setName("young");
        clientUser.setEmail("young.yg@foxmail.com");

//        int i = 1 / 0;
//
//        System.err.println(i);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.err.println(
                    "run is : " + i
            );
        }

        iClientUserService.save(clientUser);

        System.err.println("run is");
        return "success";
    }

    @Transactional
    public void cancel() {
        System.err.println("事务失败，补偿方法");
    }

}
