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

    @GetMapping("/commons/players")
    public Player findPlayerFromCommons(@RequestParam String name) {
        return service.findPlayerFromCommons(name);
    }

    @GetMapping("/hikari/players")
    public Player findPlayerFromHikari(@RequestParam String name) {
        return service.findPlayerFromHikari(name);
    }
}
