package org.acme.spsp.controller.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private LocalDateTime timestamp;
    private String message;
    private int status;
}
