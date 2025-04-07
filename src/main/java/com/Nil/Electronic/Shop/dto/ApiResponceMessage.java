package com.Nil.Electronic.Shop.dto;

import lombok.*;
import org.springframework.http.HttpStatus;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ApiResponceMessage {
    private String massage;
    private boolean Success;
    private HttpStatus status;

}
