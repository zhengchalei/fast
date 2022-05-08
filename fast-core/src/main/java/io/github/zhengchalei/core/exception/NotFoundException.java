package io.github.zhengchalei.core.exception;

/**
 * @author 郑查磊
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }


    public NotFoundException(final String message) {
        super(message);
    }
}
