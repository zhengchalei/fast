package io.github.zhengchalei.fast.web.wrapper;

import org.springframework.stereotype.Component;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * AthenaHttpRequestWrapper
 *
 * @author zhengchalei
 */
@Component
public class AthenaHttpRequestWrapper extends HttpServletRequestWrapper {

    private ByteArrayInputStream bodyInputStream;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public AthenaHttpRequestWrapper(final HttpServletRequest request) {
        super(request);
    }

    /**
     * 获取输入流
     *
     * @return {@link ServletInputStream}
     * @throws IOException ioexception
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (bodyInputStream == null) {
            this.bodyInputStream = new ByteArrayInputStream(super.getInputStream().readAllBytes());
        }
        return new ServletInputStream() {

            @Override
            public int read() {
                return bodyInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return true;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(final ReadListener listener) {
                throw new UnsupportedOperationException();
            }
        };
    }

}
