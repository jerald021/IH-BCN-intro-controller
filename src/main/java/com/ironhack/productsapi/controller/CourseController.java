package com.ironhack.productsapi.controller;

import com.ironhack.productsapi.model.Course;
import com.ironhack.productsapi.repository.CourseRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/cursos")
    public List<Course> mostrarTodosLosCursos() {
        return courseRepository.findAll();

    }

    @GetMapping("/cursos/by-name/{coursename}")
    public Course courseByName(@PathVariable String coursename) {
        if (courseRepository.findByCourseName(coursename).isPresent()) {
            return courseRepository.findByCourseName(coursename).get();
        } else {
            return null;
        }
    }

    @GetMapping("/cursos/by-name")
    public Course courseByNameParams(@RequestParam(defaultValue = "Java") String name) {
        if (courseRepository.findByCourseName(name).isPresent()) {
            return courseRepository.findByCourseName(name).get();
        } else {
            return null;
        }

    }

}
