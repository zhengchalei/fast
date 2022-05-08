package io.github.zhengchalei.fast.web.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;

import javax.validation.ValidationException;
import java.util.Map;


/**
 * 异常控制器
 *
 * @author zhengchalei
 * @since 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> exception(Exception e) {
        log.error("服务器异常", e);
        return Map.of("message", "服务器异常");
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotFoundException.class)
    public Map<String, String> exception(NotFoundException e) {
        log.error("查询结果不存在", e);
        return Map.of("message", "内容不存在");
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ValidationException.class)
    public Map<String, String> exception(ValidationException e) {
        log.error("参数校验异常", e);
        return Map.of("message", e.getMessage());
    }
}
