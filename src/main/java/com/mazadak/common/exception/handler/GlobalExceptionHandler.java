package com.mazadak.common.exception.handler;


import com.mazadak.common.exception.base.MazadakException;
import com.mazadak.common.util.ExceptionUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        log.debug("Global Exception Handler Created");
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        log.error("Handling RuntimeException: {} at path: {} [{}]",
                ex.getClass().getSimpleName(), request.getRequestURI(), request.getMethod(), ex);

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problem.setTitle("Internal Server Error");
        problem.setDetail(ex.getMessage() != null ? ex.getMessage() : "Unexpected error occurred");

        log.debug("Created ProblemDetail with status: {} and title: {}",
                problem.getStatus(), problem.getTitle());

        ExceptionUtils.enrichProblemDetail(problem, request);

        log.info("Returning RuntimeException response with status: {} for path: {}",
                problem.getStatus(), request.getRequestURI());

        return problem;
    }

    @ExceptionHandler(MazadakException.class)
    public ProblemDetail handleMazadakException(MazadakException ex, HttpServletRequest request) {
        log.warn("Handling MazadakException: {} with status: {} at path: {} [{}]",
                ex.getClass().getSimpleName(), ex.getStatus(), request.getRequestURI(), request.getMethod());
        log.debug("MazadakException details - Title: {}, Message: {}", ex.getTitle(), ex.getMessage(), ex);

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(ex.getStatus(), ex.getMessage());
        problemDetail.setTitle(ex.getTitle());

        log.debug("Created ProblemDetail for MazadakException with status: {} and title: {}",
                ex.getStatus(), ex.getTitle());

        ExceptionUtils.enrichProblemDetail(problemDetail, request);

        log.info("Returning MazadakException response with status: {} for path: {}",
                ex.getStatus(), request.getRequestURI());

        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        log.warn("Handling MethodArgumentNotValidException at path: {} [{}]",
                request.getRequestURI(), request.getMethod());
        log.debug("Validation errors count: {}", ex.getBindingResult().getErrorCount());

        Map<String, String> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(f -> f.getField(), f -> f.getDefaultMessage(), (a, b) -> a));

        log.debug("Field validation errors: {}", fieldErrors);

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Invalid Request");
        problemDetail.setTitle("Validation Failed");
        problemDetail.setProperty("errors", fieldErrors);

        log.debug("Created ProblemDetail for validation with status: BAD_REQUEST");

        ExceptionUtils.enrichProblemDetail(problemDetail, request);

        log.info("Returning validation error response with {} field errors for path: {}",
                fieldErrors.size(), request.getRequestURI());

        return problemDetail;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ProblemDetail handleMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.METHOD_NOT_ALLOWED,
                "HTTP method '" + ex.getMethod() + "' is not supported for this endpoint"
        );
        problemDetail.setTitle("Method Not Allowed");
        ExceptionUtils.enrichProblemDetail(problemDetail, request);
        problemDetail.setProperty("supportedMethods", ex.getSupportedMethods());
        return problemDetail;
    }
}

