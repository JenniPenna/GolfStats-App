package com.golfstats.backend.course;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                    // tämä luokka vastaanottaa HTTP-pyyntöjä ja palauttaa JSONia
@RequestMapping("/api/courses")    // kaikkien tämän luokan endpointtien osoite alkaa /api/courses
public class CourseController {

    private final CourseRepository courseRepository;   // repository, jonka kautta puhutaan tietokannalle

    // Konstruktori: Spring "injektoi" (antaa) tähän valmiin CourseRepository-olion
    // Tätä kutsutaan riippuvuuksien injektioksi (dependency injection)
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping                       // reagoi GET-pyyntöön osoitteessa /api/courses
    public List<Course> getAll() {
        return courseRepository.findAll();   // hakee kaikki kentät, Spring muuttaa listan JSONiksi
    }

    @PostMapping                            // reagoi POST-pyyntöön osoitteessa /api/courses
    @ResponseStatus(HttpStatus.CREATED)     // palauttaa statuskoodin 201 (Created) eikä 200
    public Course create(@Valid @RequestBody Course course) {
        // @RequestBody: muuttaa pyynnön mukana tulevan JSONin Course-olioksi
        // @Valid: tarkistaa validoinnit (esim. @NotBlank) ennen kuin metodi ajetaan
        return courseRepository.save(course);   // tallentaa tietokantaan ja palauttaa tallennetun kentän id:n kanssa
    }
}