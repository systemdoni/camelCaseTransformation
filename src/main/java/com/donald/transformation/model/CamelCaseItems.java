package com.donald.transformation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CamelCaseItems {

    private String name;
    private List<String> items;
    private Long timestamp;

}
