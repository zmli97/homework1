package com.cet.homework.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;

//王嘉奇
//
@Component
public class EncryptorComponent {
    //密钥和盐值基于application配置文件注入，是提前写好的
    @Value("${my.secretkey}")
    private String secretKey;
    @Value("${my.salt}")
    private String salt;//盐值
    @Autowired
    private ObjectMapper mapper;
    // 加密指定字符串
    public String encrypt(Map payload) {
        try {
            String json = mapper.writeValueAsString(payload);
            return Encryptors.text(secretKey, salt).encrypt(json);//基于指定密钥和盐值创建文本加密器，将json加密
        } catch (JsonProcessingException e) {
        }
        return null;
    }
    // 解密指定字符串
    public Map<String, Object> decrypt(String encryptString) {
        try {
            String json = Encryptors.text(secretKey, salt).decrypt(encryptString);//基于指定密钥和盐值创建文本加密器
            return mapper.readValue(json, Map.class);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录");
        }
    }
}
