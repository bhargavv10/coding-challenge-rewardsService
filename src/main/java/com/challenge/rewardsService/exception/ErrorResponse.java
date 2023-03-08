package com.challenge.rewardsService.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {
    private List<String> errors = new ArrayList<>();
    private String exception;
}
