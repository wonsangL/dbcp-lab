package com.example.dbcplab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private BigInteger id;
    private String name;
    private Integer age;
    private LocalDateTime birthday;
}
