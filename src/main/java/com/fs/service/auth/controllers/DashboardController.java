package com.fs.service.auth.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

  @GetMapping("/admin")
  @PreAuthorize("hasAuthority('ADMIN')")
  public String adminDashboard() {
    return "Admin Board.";
  }

  @GetMapping("/superadmin")
  @PreAuthorize("hasAuthority('SUPERADMIN')")
  public String superAdminDashboard() {
    return "Super Admin Dash Board.";
  }

}
