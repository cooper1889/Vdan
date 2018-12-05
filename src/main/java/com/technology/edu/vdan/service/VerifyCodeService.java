package com.technology.edu.vdan.service;


import com.technology.edu.vdan.bean.VerifyCode;

public interface VerifyCodeService {

    int add(VerifyCode verifyCode);
    VerifyCode query(String phone, int code);

}
