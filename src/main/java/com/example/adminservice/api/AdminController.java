package com.example.adminservice.api;

import com.example.adminservice.dto.TokenResponse;
import com.example.adminservice.dto.UserDto;
import com.example.adminservice.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @PostMapping("/login")
    public TokenResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return adminService.getAuthToken(username, password);
    }

    @GetMapping
    public List<UserDto> findAll(@RequestHeader("Authorization") String auth) {
        return adminService.getUsersList(auth);
    }
}
