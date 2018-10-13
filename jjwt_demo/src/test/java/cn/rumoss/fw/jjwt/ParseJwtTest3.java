package cn.rumoss.fw.jjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * 校验Token
 */
public class ParseJwtTest3 {

    public static void main(String[] args) {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJUYW5pamlhIiwiaWF0IjoxNTM5NDEyNDcxLCJleHAiOjE1Mzk0MTI1MzAsInJvbGUiOiJtYW5hZ2VyIiwibGFiZWwiOiJjb21ldCJ9.r41Ht_rkFyyaBB1kX8RykVmA01Up3zk6V695gOOR-Cs";
        Claims claims =
                Jwts.parser().setSigningKey("rumoss").parseClaimsJws(token).getBody();
        System.out.println("Parsed Id: " + claims.getId());// 经过测试,支持4位
        System.out.println("Parsed Subject: " + claims.getSubject());
        System.out.println("Parsed IssuedA: " + claims.getIssuedAt());
        System.out.println("Parsed Role: " + claims.get("role"));
        /**
         * Parsed Id: 666
         * Parsed Subject: Tanijia
         * Parsed IssuedA: Sat Oct 13 14:34:31 CST 2018
         * Parsed Role: manager
         */

    }

}
