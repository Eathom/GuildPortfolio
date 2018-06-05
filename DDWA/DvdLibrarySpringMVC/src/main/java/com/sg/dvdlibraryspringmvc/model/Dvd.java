/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.model;


import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Dvd {
    
    private long dvdId;

    public long getDvdId() {
        return dvdId;
    }

    public void setDvdId(long dvdId) {
        this.dvdId = dvdId;
    }
    @NotEmpty(message="Title required")
    @Length(max=50, message="Title needs to be shorter")
    private String title;
    @NotEmpty(message="Year released required")
    @Length(min=4, max=4, message="Yr must be 4 digits")
    private String rlsDate;
     private String rating;
     @NotEmpty(message="Director required")
    @Length(max=50, message="Director needs to be shorter")
    private String director;
   

  

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRlsDate() {
        return rlsDate;
    }
      

    public void setRlsDate(String rlsDate) {
        this.rlsDate = rlsDate;
       
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

   
    
    
   
    @Override
    public String toString() {
        return "Title: " + title + " |Release Date: " + rlsDate 
                + " |Rated " + rating + " |Directed by: " + director;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.dvdId ^ (this.dvdId >>> 32));
        hash = 31 * hash + Objects.hashCode(this.title);
        hash = 31 * hash + Objects.hashCode(this.rlsDate);
        hash = 31 * hash + Objects.hashCode(this.rating);
        hash = 31 * hash + Objects.hashCode(this.director);
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
        final Dvd other = (Dvd) obj;
        if (this.dvdId != other.dvdId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.rlsDate, other.rlsDate)) {
            return false;
        }
        return true;
    }
  
}
