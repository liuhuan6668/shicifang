package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuhuan
 * @date
 * @描述
 */
@Component
public class ManagerFilter extends ZuulFilter {
    //过滤器类型
    //pre在执行之前post在执行之后
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 多个过滤器排序
     * 表示执行顺序,,数字越小,优先
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 当前过滤器是否开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内的操作
     * 返回任何object值都表示继续操作
     *setsendzullRespponse(false)表示不再继续执行
     */
    @Override
    public Object run() throws ZuulException {
       //得到request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到request域
        HttpServletRequest request = currentContext.getRequest();
        //得到头信息
        String kkk = request.getHeader("Authorization");
        //新用户登录放行
        if(request.getMethod().equals("OPTIONS")){
            return null;
        }
        String url=request.getRequestURL().toString();
        if(url.indexOf("/admin/login")>0){
            System.out.println("登陆页面"+url);
            return null;
        }
        //判断是否有头信息
        if (!StringUtils.isBlank(kkk)){
            //把头信息继续传下去
            currentContext.addZuulRequestHeader("Authorization",kkk);
        }
        return null;
    }
}
