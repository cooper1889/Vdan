package com.technology.edu.vdan.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 登录、注册等相关接口API，返回参数说明result=0返回正常结果
 *
 * @author Likang
 */
@RestController
@RequestMapping(value = "login")
public class Login {

    private static final int appId = 1400164787;
    private static final String appKey = "f94b0c09b0d28b67612be8065a457977";

    /**
     * 获取验证码接口
     *
     * @param phone:手机号码
     * @return 验证码
     */
    @GetMapping("verifyCode")
    public String verifyCode(@RequestParam String phone){
        int verifyCode = (int)((Math.random()*9+1)*1000);
        SmsSingleSender sender = new SmsSingleSender(appId, appKey);
        try {
            SmsSingleSenderResult result = sender.send(0, "86", phone, "【墨痕】"
                    +verifyCode+"为您的注册验证码，请于10分钟内填写。" +
                    "如非本人操作，请忽略本短信", "", "");
            if (result.result == 0){
                return "success";
            }
        } catch (HTTPException | IOException e) {
            e.printStackTrace();
        }
        return "error";
    }



}
