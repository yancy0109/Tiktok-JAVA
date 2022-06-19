package com.tiktok.app.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginAndResgiterResponese {
    private Integer user_id;
    private String token;
}
