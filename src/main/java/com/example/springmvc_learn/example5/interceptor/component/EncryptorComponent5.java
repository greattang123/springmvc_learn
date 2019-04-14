package com.example.springmvc_learn.example5.interceptor.component;

import com.example.springmvc_learn.example5.interceptor.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EncryptorComponent5 {
    @Value("${my.secret_key}")
    private String secretKey;
    @Value("${my.salt}")
    private String salt;
    @Autowired
    private ObjectMapperComponent5 omc;
    // 加密
    public String encrypt(Map payload) {
        String json = omc.writeValueAsString(payload);
        /* Encryptors.text(secretKey, salt)，基于指定密钥和盐值创建文本加密器,
            encrypt()加密，decrypt()解密*/
        return Encryptors.text(secretKey, salt).encrypt(json);
    }
    // 解密
    public Map<String, Object> decrypt(String encryptString) {
        try {
            String json = Encryptors.text(secretKey, salt).decrypt(encryptString);
            return omc.readValue(json);
        } catch (Exception e) {
            throw new UnauthorizedException();
        }
    }
}
