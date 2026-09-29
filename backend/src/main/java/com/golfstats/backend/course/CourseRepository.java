package com.golfstats.backend.course;

import org.springframework.data.jpa.repository.JpaRepository;

// interface, ei class: emme kirjoita toteutusta itse, Spring luo sen automaattisesti
// JpaRepository<Course, Long>:
//   Course = minkä entiteetin tietoa käsitellään
//   Long   = entiteetin id-kentän tyyppi
public interface CourseRepository extends JpaRepository<Course, Long> {
}