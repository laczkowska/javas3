package com.example.model;
import jakarta.persistence.*;

@Entity
@Table(name = "employment")
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "key_skills")
    private String keySkill;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
