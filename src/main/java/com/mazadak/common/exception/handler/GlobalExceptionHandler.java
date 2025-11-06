package com.mazadak.common.exception.handler;


import com.mazadak.common.exception.base.MazadakException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

//@ConditionalOnProperty(
//        prefix = "mazadak.exception.handler",
//        name = "enabled",
//        havingValue = "true",
//        matchIfMissing = true
//)
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        log.info("Global Exception Handler Created");
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntime(RuntimeException ex, HttpServletRequest request) {
        log.error("Handling RuntimeException: {} at path: {} [{}]",
                ex.getClass().getSimpleName(), request.getRequestURI(), request.getMethod(), ex);

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problem.setTitle("Internal Server Error");
        problem.setDetail(ex.getMessage() != null ? ex.getMessage() : "Unexpected error occurred");

        log.debug("Created ProblemDetail with status: {} and title: {}",
                problem.getStatus(), problem.getTitle());

        enrich(problem, request);

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

        enrich(problemDetail, request);

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

        enrich(problemDetail, request);

        log.info("Returning validation error response with {} field errors for path: {}",
                fieldErrors.size(), request.getRequestURI());

        return problemDetail;
    }

    public void enrich(ProblemDetail problemDetail, HttpServletRequest request) {
        log.debug("Enriching ProblemDetail for request: {} {}", request.getMethod(), request.getRequestURI());

        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setProperty("path", request.getRequestURI());
        problemDetail.setProperty("method", request.getMethod());

        log.debug("ProblemDetail enriched with timestamp, path, and method");
    }
}

