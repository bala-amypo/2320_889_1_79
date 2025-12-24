package com.example.demo.entity;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
}
