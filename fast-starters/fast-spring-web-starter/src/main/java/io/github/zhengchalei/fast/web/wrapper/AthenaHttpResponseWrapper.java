package io.github.zhengchalei.fast.web.wrapper;


import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * AthenaHttpRequestWrapper
 *
 * @author zhengchalei
 */
@Component
public class AthenaHttpResponseWrapper extends HttpServletResponseWrapper {

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response The response to be wrapped
     * @throws IllegalArgumentException if the response is null
     */
    public AthenaHttpResponseWrapper(final HttpServletResponse response) {
        super(response);
    }
}
