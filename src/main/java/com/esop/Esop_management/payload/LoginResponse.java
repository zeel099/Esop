package com.esop.Esop_management.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {
    String message ;
    Boolean status;

}
