package com.wale.TruckDriverApp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "trucks")
public class Trucks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String site;
    private String asset;
    private String registration;
    private double latitude;
    private double longitude;
    private String current;
    private String position;
    private String created;
    private String updated;

}
