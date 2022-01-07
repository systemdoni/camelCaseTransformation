package com.donald.transformation.controller;

import com.donald.transformation.model.CamelCaseItems;
import com.donald.transformation.model.SnakeCaseItems;
import com.donald.transformation.service.TransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransformationController {

    private TransformationService transformationServiceImpl;

    @Autowired
    public TransformationController(TransformationService transformationServiceImpl){
        this.transformationServiceImpl = transformationServiceImpl;
    }

    @PostMapping("/transform")
    public CamelCaseItems transform(@RequestBody SnakeCaseItems snakeCaseItems){
        transformationServiceImpl.validateLettersOnly(snakeCaseItems);
        transformationServiceImpl.eliminateDuplicateItems(snakeCaseItems);
        return transformationServiceImpl.transformItems(snakeCaseItems);
    }

}
