package io.github.zhengchalei.core.exception;

/**
 * 数据异常异常
 *
 * @author 郑查磊
 */
public class DataAnomaliesException extends RuntimeException {

    public DataAnomaliesException() {
        super();
    }


    public DataAnomaliesException(final String message) {
        super(message);
    }
}
