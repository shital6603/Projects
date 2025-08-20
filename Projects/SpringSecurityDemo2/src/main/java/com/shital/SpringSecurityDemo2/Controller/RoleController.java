package com.shital.SpringSecurityDemo2.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminKaMethod()
    {
        return "Mein admin hoon !!";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/user")
    public String userKaMethod()
    {
        return "Mein User hoon !!!";
    }
}
