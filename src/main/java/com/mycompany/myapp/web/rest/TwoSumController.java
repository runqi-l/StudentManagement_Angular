package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.TwoSum;
import com.mycompany.myapp.domain.dto.CourseDto;
import com.mycompany.myapp.service.TwoSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TwoSumController {
    @Autowired
    private TwoSumService twoSumService;

    @GetMapping(path = "/twosum/{input}", produces = "application/json")
    public HttpEntity<List<Integer>> getans(@PathVariable("input") String input){
        List<Integer> ans = twoSumService.getNums(input);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
}
