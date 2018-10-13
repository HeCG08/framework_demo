package cn.rumoss.fw.jjwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * 生成Token
 */
public class CreateJwtTest {

    public static void main(String[] args) {

        JwtBuilder builder = Jwts.builder().setId("666").setSubject("Tanijia")
                .setIssuedAt(new Date())// 设置签发时间
                .signWith(SignatureAlgorithm.HS256,"rumoss");// 设置签名秘钥

        // Created token: eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJUYW5pamlhIiwiaWF0IjoxNTM5NDA5NTI4fQ.AG6l4PXUN2H3uK_QwG8YKEgE65PyzkoZWzTOjL68PEA
        System.out.println("Created token: " + builder.compact());

    }

}
