package com.technology.edu.vdan.service;

import com.technology.edu.vdan.bean.VerifyCode;
import com.technology.edu.vdan.mapper.VerifyCodeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService, Serializable {

    @Autowired
    VerifyCodeMapper mapper;

    @Override
    public int add(VerifyCode verifyCode) {
        int ar = mapper.add(verifyCode);
        if (ar>0){
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    mapper.delete(verifyCode.getPhone());
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, (long)(10*60*1000));
        }
        return mapper.add(verifyCode);
    }
    @Override
    public VerifyCode query(String phone, int code){
        return mapper.query(phone, code);
    }
}
