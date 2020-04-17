package com.generation.code.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @Author xiongxiaofei
 * @Date 2019/1/17
 * @Desc HmacSHA256算法工具类
 */
public class HmacSHA256Utils {

    private static final String ALGORITHM = "HmacSHA256";

    private static Base64 base64 = new Base64();

    /**
     * @Author xiongxiaofei
     * @Date 2019/1/17
     * @Desc 生成密钥
     */
    public static String generateSecretKey() {
        try {
            SecretKey secretKey = KeyGenerator.getInstance(ALGORITHM).generateKey();
            return base64.encodeToString(secretKey.getEncoded());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    /**
     * @Author xiongxiaofei
     * @Date 2019/1/17
     * @Desc 生成消息摘要
     */
    public static String digest(String secretKey, String content) {
        try {
            // 还原密钥
            byte[] secretBytes = base64.decode(secretKey);
            SecretKey secret = new SecretKeySpec(secretBytes, ALGORITHM);

            // 为mac实例初始化密钥
            Mac mac = Mac.getInstance(ALGORITHM);
            mac.init(secret);

            // 内容加密
            byte[] dataBytes = content.getBytes(StandardCharsets.UTF_8);
            return base64.encodeToString(mac.doFinal(dataBytes));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public static void main(String[] args) {
        String content = "92938765423456674&POST&/getUserInfo&1462460837923";
        String secretKey = "PefxdBGn5kLckngPcU6pjtdMfIA7AIhfMW3NcCzNwmY=";
        System.out.println(digest(secretKey, content));
        // 2ihcQYctk+HxScHKV5rMltHUHl7Z3npWSZgQxq4z4AU=
    }
}
