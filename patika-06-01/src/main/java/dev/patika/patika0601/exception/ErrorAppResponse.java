package dev.patika.patika0601.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorAppResponse {
    private int status;
    private String message;
    private long timestamp;
}