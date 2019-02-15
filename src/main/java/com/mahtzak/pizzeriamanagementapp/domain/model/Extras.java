package com.mahtzak.pizzeriamanagementapp.domain.model;

import javax.persistence.*;

@Entity
@Table(name="extras")
public class Extras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
}
