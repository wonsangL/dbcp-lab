package com.example.dbcplab;

import com.example.dbcplab.commons.PlayerCommonRepository;
import com.example.dbcplab.domain.Player;
import com.example.dbcplab.hikari.PlayerHikariRepository;
import com.example.dbcplab.tomcat.PlayerTomcatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final PlayerCommonRepository commonRepository;
    private final PlayerHikariRepository hikariRepository;
    private final PlayerTomcatRepository tomcatRepository;

    public Player findPlayerFromCommons(String name) {
        return commonRepository.findFirstPlayerWithName(name);
    }

    public Player findPlayerFromHikari(String name) {
        return hikariRepository.findFirstPlayerWithName(name);
    }

    public Player findPlayerFromTomcat(String name) {
        return tomcatRepository.findFirstPlayerWithName(name);
    }
}
