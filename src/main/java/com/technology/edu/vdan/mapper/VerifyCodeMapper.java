package com.technology.edu.vdan.mapper;

import com.technology.edu.vdan.bean.VerifyCode;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VerifyCodeMapper {
    @Insert("INSERT INTO verify_code(phone, code) VALUES(#{phone}, #{code}) ON DUPLICATE KEY UPDATE code=#{code}")
    int add(VerifyCode verifyCode);
    @Select(value = "SELECT * FROM verify_code WHERE phone=#{phone} AND  code = #{code}")
    VerifyCode query(@Param("phone")String phone, @Param("code")int code);
    @Delete(value = "DELETE FROM verify_code WHERE phone=#{phone}")
    int delete(String phone);
}
