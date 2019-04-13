package com.example.springmvc_learn.example3.bean_validation.control;

import com.example.springmvc_learn.example1.entity.Address;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Digits;
import javax.xml.stream.events.Comment;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class Exception3Controller {
   @ExceptionHandler(MethodArgumentNotValidException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   /**
    *属性检验失败异常
    *@param[e]
    *@return java.util.Map
    */
    public Map handleValidException(MethodArgumentNotValidException e){
        StringBuilder stringBuilder=new StringBuilder();
        e.getBindingResult()
                .getFieldErrors()
                .forEach(a->{
                  stringBuilder.append(a.getField());
                  stringBuilder.append(": ");
                  stringBuilder.append(a.getDefaultMessage());
                  stringBuilder.append(": ");
                });
        return Map.of("message", stringBuilder.toString());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    /**
     *地址参数转换异常
     *@param[exception, request]
     *@return java.util.Map
     */
    public Map handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception,
            HttpServletRequest request){
        String msg=request.getRequestURI()+
                ": "+"请求地址参数"+exception.getValue()+"错误";
        return  Map.of("message", msg);
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    /**
     *属性类型转换异常
     *@param[exception]
     *@return java.util.Map
     */
    public Map handleInvalidFormatException(InvalidFormatException exception){
        StringBuilder stringBuilder=new StringBuilder();
        exception.getPath()
                .forEach(p->{
                    stringBuilder.append("属性");
                    stringBuilder.append(p.getFieldName());
                    stringBuilder.append(",您输入的值："+exception.getValue());
                    stringBuilder.append(",类型错误");
                });
        return Map.of("message", stringBuilder.toString());
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    /**
     *方法级参数检验失败异常
     *@param[exception]
     *@return java.util.Map
     */
    public Map handleConstraintViolationException(ConstraintViolationException exception){
        StringBuilder stringBuilder=new StringBuilder();
        Set<ConstraintViolation<?>> violations=exception.getConstraintViolations();
        violations.forEach(v->{
            stringBuilder.append(v.getMessage()+";");
        });
        return Map.of("message", stringBuilder.toString());
    }
}
