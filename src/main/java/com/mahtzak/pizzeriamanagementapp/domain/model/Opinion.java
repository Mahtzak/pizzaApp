package com.mahtzak.pizzeriamanagementapp.domain.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String message;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
