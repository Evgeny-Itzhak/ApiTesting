package project.apitests.dto;

import lombok.Data;

@Data
public class LoginResponse implements JsonConvertible {
    private boolean success;
    private Error errors;
}
