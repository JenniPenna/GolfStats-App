package com.golfstats.backend.course;   // mihin pakettiin (kansioon) luokka kuuluu

import jakarta.persistence.*;            // JPA:n annotaatiot (@Entity, @Id jne.)
import jakarta.validation.constraints.NotBlank;   // validointi: kenttä ei saa olla tyhjä

@Entity                      // kertoo JPA:lle: tämä luokka vastaa tietokantataulua
@Table(name = "course")      // taulun nimi tietokannassa (sama kuin V1__init.sql:ssä)
public class Course {

    @Id                                                   // tämä kenttä on pääavain (PRIMARY KEY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // tietokanta luo id:n itse (BIGSERIAL)
    private Long id;

    @NotBlank            // nimi ei saa olla null, tyhjä tai pelkkiä välilyöntejä
    private String name;

    private String location;   // sijainti, sallittu tyhjäksi (ei @NotBlank)

    @Column(name = "holes_count")   // Java-kentän nimi on holesCount, mutta sarake on holes_count
    private int holesCount = 18;    // oletusarvo 18, jos arvoa ei anneta

    // Getterit ja setterit: tapa lukea ja muuttaa yksityisiä kenttiä
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getHolesCount() { return holesCount; }
    public void setHolesCount(int holesCount) { this.holesCount = holesCount; }
}