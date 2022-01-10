package com.example.dbcplab;

import com.example.dbcplab.commons.PlayerCommonV2Repository;
import com.example.dbcplab.commons.PlayerCommonsV1Repository;
import com.example.dbcplab.domain.Player;
import com.example.dbcplab.hikari.PlayerHikariRepository;
import com.example.dbcplab.tomcat.PlayerTomcatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final PlayerCommonsV1Repository commonsV1Repository;
    private final PlayerCommonV2Repository commonV2Repository;
    private final PlayerHikariRepository hikariRepository;
    private final PlayerTomcatRepository tomcatRepository;
    
    public Player findPlayerFromCommonsV1(String name) {
        return commonsV1Repository.findFirstPlayerWithName(name);
    }
    
    public Player findPlayerFromCommonsV2(String name) {
        return commonV2Repository.findFirstPlayerWithName(name);
    }

    public Player findPlayerFromHikari(String name) {
        return hikariRepository.findFirstPlayerWithName(name);
    }

    public Player findPlayerFromTomcat(String name) {
        return tomcatRepository.findFirstPlayerWithName(name);
    }
}
