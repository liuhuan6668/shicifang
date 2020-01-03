package com.tensquare.qa.feign.Impl;

import com.tensquare.qa.feign.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author liuhuan
 * @date
 * @描述  当有熔断器Hystrix时需要
 */
@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR,"我是熔断器");
    }
}
