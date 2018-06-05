/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 *
 * @author Lizz
 */
public class DVD {
    private String title;
    private LocalDate releaseDate;
    private String rating;
    private String director;
    private String studio;
    private int userReview;
    
    //
    //modified constructor to add new DVD object with title already set, helps
    // deal with HashMap key values since title is key. 
    //title will be read - only.
    //
    
    public DVD (String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setMpaaRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getUserReview() {
        return userReview;
    }

    public void setUserReview(int userReview) {
        this.userReview = userReview;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + Objects.hashCode(this.releaseDate);
        hash = 59 * hash + Objects.hashCode(this.rating);
        hash = 59 * hash + Objects.hashCode(this.director);
        hash = 59 * hash + Objects.hashCode(this.studio);
        hash = 59 * hash + Objects.hashCode(this.userReview);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userReview, other.userReview)) {
            return false;
        }
        return true;
    }
    
    public int getAge(){
         Period p = getReleaseDate().until(LocalDate.now());
         return p.getYears();
    }
   
    @Override
    public String toString() {
        return "Title: " + title + " |Release Date: " + releaseDate 
                + " |Rated " + rating + " |Directed by: " + director
                + " |Studio: " + studio + " |Review: " + userReview;
    }
  
    
}
