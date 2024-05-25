package com.example.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Dies ist ein öffentlicher Endpunkt. Jeder kann darauf zugreifen.";
    }

    @GetMapping("/secured")
    @PreAuthorize("hasRole('USER')")
    public String securedEndpoint() {
        return "Dies ist ein gesicherter Endpunkt. Nur authentifizierte Benutzer mit der Rolle 'USER' können darauf zugreifen.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "Dies ist ein Admin-Endpunkt. Nur Benutzer mit der Rolle 'ADMIN' können darauf zugreifen.";
    }
}