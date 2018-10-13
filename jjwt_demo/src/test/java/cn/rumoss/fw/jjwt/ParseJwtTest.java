package cn.rumoss.fw.jjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * 校验Token
 */
public class ParseJwtTest {

    public static void main(String[] args) {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJUYW5pamlhIiwiaWF0IjoxNTM5NDA5OTk2fQ.xWNql-Swrhxksz86G8Ie0nJ4041tIvtMhIUQM8Ma8as";
        token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJUYW5pamlhIiwiaWF0IjoxNTM5NDEyMTI2LCJleHAiOjE1Mzk0MTIxODZ9.do53jqafCzCZYTcSnFMXECzkLn3Rgr2ZQSJg42GBfuU";
        Claims claims =
                Jwts.parser().setSigningKey("rumoss").parseClaimsJws(token).getBody();
        System.out.println("Parsed Id: " + claims.getId());// 经过测试,支持4位
        System.out.println("Parsed Subject: " + claims.getSubject());
        System.out.println("Parsed IssuedA: " + claims.getIssuedAt());
        /**
         * Parsed Id: 666
         * Parsed Subject: Tanijia
         * Parsed IssuedA: Sat Oct 13 13:45:28 CST 2018
         */
    }

}
