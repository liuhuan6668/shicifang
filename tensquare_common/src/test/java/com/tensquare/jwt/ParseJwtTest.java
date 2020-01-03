package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @author liuhuan
 * @date
 * @描述
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        Claims test = Jwts.parser()
                .setSigningKey("test")
                .parseClaimsJws("")
                .getBody();
        System.out.println("id>>>>"+test.getId());
        System.out.println("用户名>>>>"+test.getSubject());
        System.out.println("时间>>>>"+ new SimpleDateFormat("yyyy-MM-dd").format(test.getIssuedAt()));
    }
}
