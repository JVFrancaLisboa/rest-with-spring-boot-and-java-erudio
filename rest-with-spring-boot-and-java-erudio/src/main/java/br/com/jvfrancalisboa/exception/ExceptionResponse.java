package br.com.jvfrancalisboa.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
