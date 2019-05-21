package com.wisdom.agriculture.controller;


import com.wisdom.agriculture.service.DataVisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DataVisualizationController {

    @Autowired
    private DataVisualizationService dataVisualizationService;
}
