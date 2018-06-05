/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public class DvdView {

    UserIO io;

    public DvdView(UserIO io) {
        this.io = io;
    }

    public int printMenuGetSelection() {
        io.print("-~*´¨¯¨`*·~-.¸-(_DVD Library_)-,.-~*´¨¯¨`*·~-.¸ \n Main Menu:");
        io.print("1. ADD a DVD to library");
        io.print("2. REMOVE a DVD from library");
        io.print("3. EDIT a DVD");
        io.print("4. VIEW entire library");
        io.print("5. VIEW a DVD");
        io.print("6.VIEW all movies released how many years ago");
        io.print("7. VIEW all movies with rating");
        io.print("8. VIEW all movies by director");
        io.print("9. FIND average age of movies");
        io.print("10. VIEW newest movie");
        io.print("11. VIEW oldest movie");
        io.print("12. VIEW average size of user notes");
        io.print("13. EXIT the program");

        return io.getInt("Enter a number to make selection", 1, 13);

    }

    // ----------- GENERAL USE METHODS --------------------- //
    public String getTitle() {
        return io.getString("Enter title name");

    }

    public String enterToContinue() {
        return io.getString("Press ENTER to continue");
    }

    public void displayExit() {
        io.print("0.o.0.o.0.o Good BYE!!! o.0.o.0.0.o.0");
    }

    public void displayUnknown() {
        io.print("¯\\(°_o)/¯  Unknown Command  ¯\\(°_o)/¯ ");
    }

    public void displayError(String errorMsg) {
        io.print("{{{(>_<)}}} Error {{{(>_<)}}}");
        io.print(errorMsg);
    }

    // ------------------- ADD METHODS ----------------------//
    public void displayAddBanner() {
        io.print("Add a DVD menu: ");
    }

    public DVD addDVD() {
        String title = io.getString("Enter movie title.");
        DVD newDvd = new DVD(title);
        LocalDate releaseDate = io.getLD("Enter release date as: mm/dd/yyyy");
        String rating = io.getString("Enter MPAA rating:");
        String director = io.getString("Enter directors name:");
        String studio = io.getString("Enter studio");
        int userRating = io.getInt("Enter # of stars you'd rate it!");

      

        newDvd.setReleaseDate(releaseDate);
        newDvd.setMpaaRating(rating);
        newDvd.setDirector(director);
        newDvd.setDirector(director);
        newDvd.setStudio(studio);
        newDvd.setUserReview(userRating);
        return newDvd;
    }

    public void displayAddFailBanner() {
        io.print("¯\\(°_o)/¯     Title already exists, cannot add.     ¯\\(°_o)/¯");
        enterToContinue();
    }

    public void displayAddSuccess() {
        io.print("~~~ DVD successfully added ~~~");
        enterToContinue();
    }

    // ---------- Remove Methods --------- //
    public void displayRemoveBanner() {
        io.print("Remove DVD menu:");
    }

    public void displayRemoveFailBanner() {
        io.print("¯\\(°_o)/¯     Title doesn't exist, cannot remove.     ¯\\(°_o)/¯");
        enterToContinue();
    }

    public void displayRemoveSuccessBanner() {
        io.print("~~~ DVD successfully removed ~~~");
        enterToContinue();
    }

    // ------------ Edit methods ------------ return Strings and get converted in the service layer vs. conversion that happens right away in add method //
    
    // 
    public void displayEditBanner() {
        io.print("Edit DVD menu:");
    }

    public int getEditProp() {
        return io.getInt("What would you like to edit? \n 1. Release date 2. MPAA rating 3. Director 4. Studio 5. User review", 1, 5);
    }

    public String getDate() {
       return io.getString("Enter release date as mm/dd/yyyy");
       
    }

    public String getMPAA() {
        return io.getString("Enter MPAA rating");
    }

    public String getDirec() {
        return io.getString("Enter director");
    }

    public String getStudio() {
        return io.getString("Enter studio");
    }

    public String getReview() {
        return io.getString("Enter your star rating (#)");
    }

    public void displayEditSuccess() {
        io.print("~~~ DVD successfully edited ~~~");
        enterToContinue();
    }

    public void displayEditFail() {
        io.print("¯\\(°_o)/¯     Title doesn't exist, cannot edit.     ¯\\(°_o)/¯");
        enterToContinue();
    }

    //--------------------- List-all Methods ---------------------//
    public void listAll(Collection<DVD> library) {
        io.print("All DVD's in library: \n");
        for (DVD current : library) {

            io.print("Title: " + current.getTitle());
            io.print("Release date: " + current.getReleaseDate().getYear());
            io.print("MPAA rating: " + current.getRating());
            io.print("Director: " + current.getDirector());
            io.print("Studio: " + current.getStudio());
            io.print("User comment: " + current.getUserReview() + "\n");

        }
        enterToContinue();
    }

    // -----------------View-one Methods ---------------------------//
    public void listOne(DVD dvd) {
        io.print("DVD information: \n");
        io.print("Title: " + dvd.getTitle());
        io.print("Release date: " + dvd.getReleaseDate().getYear());
        io.print("MPAA rating: " + dvd.getRating());
        io.print("Director: " + dvd.getDirector());
        io.print("Studio: " + dvd.getStudio());
        io.print("User comment: " + dvd.getUserReview() + "\n");
        enterToContinue();
    }

    public void displayListOneFail() {
        io.print("¯\\(°_o)/¯     Title doesn't exist, cannot show.     ¯\\(°_o)/¯");
        enterToContinue();
    }

// --------     List<DVD> listInAgeRange(int min, int max) throws DvdDaoException; --//
    public void displayAgeRangeBanner(){
        io.print("Find movies within age range");
    }
    
    public int geYearsAgo(){
        return io.getInt("Enter number of years to get DVD's from.");
    }
    
    public void displayByYearsAgo(List<DVD> listResult){
        listResult.stream()
                .forEach(d -> System.out.println(d.getTitle()));       
        enterToContinue();
    }
        public void displayByDirectorBanner() {
        io.print("View DVD's by director");
    }
    
    public String getByDirector() {
       return io.getString("Enter director to find DVD's");
    }
    
    
    public void displayByDirector(Map<String, List<DVD>> mapResult){
     List<List<DVD>> listOfDvds = new ArrayList<>(mapResult.values());
     
     for (List<DVD> l : listOfDvds){
         for (DVD d : l) {
            io.print(d.getTitle() + " " + d.getRating() + " " + d.getDirector() + " " + d.getStudio());
         }
     }
     
  
        enterToContinue();
    }
    
// ----- List<DVD> listByMPAA(String mpaaRating) throws DvdDaoException; ------//

    public void displayByMPAABanner() {
        io.print("View DVD's by MPAA rating");
    }
    
    public String getByMPAA() {
       return io.getString("Enter MPAA to find DVD's with that rating");
    }
    
    public void displayByMPAA(List<DVD> listResult){
        listResult.stream()
                .forEach(d -> System.out.println(d.getTitle()));
        enterToContinue();
    }
    
    
// ----Map<String, List<DVD>> listByDirectorSortedByMPAA(String director) throws DvdDaoException; //

  
    public void displayByStudioBanner() {
        io.print("View DVD's by Studio ");
    }
    
    public String getByStudio() {
       return io.getString("Enter Studio to find DVD's.");
    }
    
    public void displayByStudio(List<DVD> listResult){
        listResult.stream()
                .forEach(d -> System.out.println(d.getTitle()));
        enterToContinue();
    }  
  
    public void displayAvgAge(double age){
        
        String strAge = Double.toString(age);
       io.print(strAge);
    }
   
    public void displayNewest(String title){
        io.print(title);
        enterToContinue();
    }
    
    public void displayOldest(String title) {
        io.print(title);
        enterToContinue();
    }
    
public void displayAvgNote(double avg){
    String strAvg = Double.toString(avg);
    io.print(strAvg);
    enterToContinue();
}

 

}
