package com.example.rentalservice;

public class Movie {

    private Long id;
    private String name;
    private MovieEnumCategory category;

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
