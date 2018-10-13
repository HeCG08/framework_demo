package cn.rumoss.fw.jjwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * 生成Token,添加Token过期校验
 */
public class CreateJwtTest2 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();
        long exp = now + 1000*60;// 1分钟后过期
        JwtBuilder builder = Jwts.builder().setId("666").setSubject("Tanijia")
                .setIssuedAt(new Date())// 设置签发时间
                .signWith(SignatureAlgorithm.HS256,"rumoss")// 设置签名秘钥
                .setExpiration(new Date(exp)); // 设置过期时间

        // Created token: eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJUYW5pamlhIiwiaWF0IjoxNTM5NDEyMTI2LCJleHAiOjE1Mzk0MTIxODZ9.do53jqafCzCZYTcSnFMXECzkLn3Rgr2ZQSJg42GBfuU
        System.out.println("Created token: " + builder.compact());

    }

}
