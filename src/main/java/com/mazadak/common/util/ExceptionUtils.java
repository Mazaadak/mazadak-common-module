package com.mazadak.common.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
public class ExceptionUtils {
    public static void enrichProblemDetail(ProblemDetail problemDetail, HttpServletRequest request) {
        log.debug("Enriching ProblemDetail for request: {} {}", request.getMethod(), request.getRequestURI());

        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setProperty("path", request.getRequestURI());
        problemDetail.setProperty("method", request.getMethod());

        log.debug("ProblemDetail enriched with timestamp, path, and method");
    }
}

