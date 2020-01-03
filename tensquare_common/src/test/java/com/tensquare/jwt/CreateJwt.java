package com.tensquare.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author liuhuan
 * @date
 * @描述
 */
public class CreateJwt {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("111")
                .setSubject("小米")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"test")
                .setExpiration(new Date(new Date().getTime()+60000))
                .claim("role","admil");
        System.out.println(jwtBuilder.compact());
    }
}
