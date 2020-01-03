package com.tensquare.qa.feign;

import com.tensquare.qa.feign.Impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liuhuan
 * @date
 * @描述 当有熔断器Hystrix时
 * fallback = BaseClientImpl.class
 */
@FeignClient(value = "tensquare-base",
            fallback = BaseClientImpl.class)
public interface BaseClient {
    @RequestMapping(value="/label/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId);
}
