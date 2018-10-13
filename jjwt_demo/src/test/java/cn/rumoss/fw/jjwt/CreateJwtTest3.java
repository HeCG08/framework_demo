package cn.rumoss.fw.jjwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * 生成Token,添加Token过期校验和自定义Claims
 */
public class CreateJwtTest3 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();
        long exp = now + 1000*60;// 1分钟后过期
        JwtBuilder builder = Jwts.builder().setId("666").setSubject("Tanijia")
                .setIssuedAt(new Date())// 设置签发时间
                .signWith(SignatureAlgorithm.HS256,"rumoss")// 设置签名秘钥
                .setExpiration(new Date(exp))// 设置过期时间
                .claim("role","manager")// 自定义Claim
                .claim("label","comet");

        // Created token: eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJUYW5pamlhIiwiaWF0IjoxNTM5NDEyMzg2LCJleHAiOjE1Mzk0MTI0NDUsInJvbGUiOiJtYW5hZ2VyIiwibGFiZWwiOiJjb21ldCJ9.QXw4MpAd-ecraul55C0CpB0opN4yEngVIs-e6URxk3A
        System.out.println("Created token: " + builder.compact());

    }

}
