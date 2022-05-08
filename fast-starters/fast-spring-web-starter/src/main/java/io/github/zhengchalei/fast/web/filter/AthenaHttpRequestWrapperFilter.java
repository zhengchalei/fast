package io.github.zhengchalei.fast.web.filter;

import io.github.zhengchalei.fast.web.wrapper.AthenaHttpRequestWrapper;
import io.github.zhengchalei.fast.web.wrapper.AthenaHttpResponseWrapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AthenaHttpRequestWrapperFilter
 *
 * @author zhengchalei
 */
@Component
@Order(Integer.MIN_VALUE)
public class AthenaHttpRequestWrapperFilter implements Filter {

    /**
     * 做过滤器
     *
     * @param request  请求
     * @param response 响应
     * @param chain    链
     * @throws IOException      io exception
     * @throws ServletException servlet异常
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        AthenaHttpRequestWrapper httpRequestWrapper = new AthenaHttpRequestWrapper((HttpServletRequest) request);
        AthenaHttpResponseWrapper httpResponseWrapper = new AthenaHttpResponseWrapper((HttpServletResponse) response);
        chain.doFilter(httpRequestWrapper, httpResponseWrapper);
    }

}
