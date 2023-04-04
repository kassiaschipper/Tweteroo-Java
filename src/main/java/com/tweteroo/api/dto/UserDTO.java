package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
    
    @NotNull(message = "Username cannot be null") @Size(min = 2, max = 20, message= "Username must be between 2 and 20 characters")
    String username,
    
    @NotNull (message = "Avatar cannot be null")
    String avatar
) {
    
}
