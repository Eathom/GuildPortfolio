/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public interface DvdDao {
    
    public Dvd addDvd(Dvd dvd);
    
    public void removeDvd(long dvdId);
    
    public void updateDvd(Dvd dvd);
    
    public List<Dvd> getAllDvds();
    
    public Dvd getDvdById(long dvdId);
    
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria);
}
