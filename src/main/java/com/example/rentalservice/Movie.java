package com.example.rentalservice;

import io.swagger.annotations.ApiModelProperty;

public class Movie {

    @ApiModelProperty(notes="This is id of the movie", required = true, value = "some id", example = "1")
    private Long id;

    @ApiModelProperty(notes="This is name of the movie", required = true, value = "name of movie", example = "Matrix")
    private String name;

    @ApiModelProperty(notes="This is category of the movie", required = true, value = "category enum", example = "SCI_FI")
    private MovieEnumCategory category;

    @ApiModelProperty(notes="This is availability of the movie", required = true, value = "boolean availability", example = "true")
    private Boolean isAvailable;

    public Movie() {

    }


    public Boolean getIsAvailable() {
        return isAvailable;
    }


    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieEnumCategory getCategory() {
        return category;
    }

    public void setCategory(MovieEnumCategory category) {
        this.category = category;
    }
}
