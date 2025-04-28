package com.vik.cal.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class WelcomeController {

    @GetMapping
        ("/test")
    fun test() = ResponseEntity.ok("API is working!")
}
