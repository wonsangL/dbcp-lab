package com.example.dbcplab;

import com.example.dbcplab.domain.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {
    private final SampleService service;
    
    @GetMapping("/commons/v1/players")
    public Player findPlayerFromCommonsV1(@RequestParam String name) {
        return service.findPlayerFromCommonsV1(name);
    }
    
    @GetMapping("/commons/v2/players")
    public Player findPlayerFromCommonsV2(@RequestParam String name) {
        return service.findPlayerFromCommonsV2(name);
    }

    @GetMapping("/hikari/players")
    public Player findPlayerFromHikari(@RequestParam String name) {
        return service.findPlayerFromHikari(name);
    }

    @GetMapping("/tomcat/players")
    public Player findPlayerFromTomcat(@RequestParam String name) {
        return service.findPlayerFromTomcat(name);
    }
}
