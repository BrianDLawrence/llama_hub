/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.llamaherder.llamahub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bobuk
 */
@RestController
public class HelloWorldController {
    
    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "Hello World!";
    }
    
}
