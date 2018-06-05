/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.serverinv.dao;

import com.sg.serverinv.dto.Server;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Lizz
 */
public class ServerDaoInMemImpl implements ServerDao {

    private Map<String, Server> serverMap = new HashMap<>();

    @Override
    public void addServer(Server server) {
        serverMap.put(server.getName(), server);
    }

    @Override
    public Server getServer(String name) {
        return serverMap.get(name);
    }

    @Override
    public void removeServer(String name) {
        serverMap.remove(name);
    }

    @Override
    public List<Server> getAllServers() {
        return new ArrayList<Server>(serverMap.values());
    }

    @Override
    public Map<String, List<Server>> getAllServersGroupByManufacturer() {

        return serverMap.values()
                .stream()
                //                              for each server, get the manufacturuer
                .collect(Collectors.groupingBy(Server::getManufacturer));
        //.collect(Collectors.groupingBy(s -> s.getManufacturer()));

    }

    @Override
    public List<Server> getServersByManufacturer(String manufacturer) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());

    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        return serverMap.values()
                .stream()
                //get Server Age will always be accurate due to Local Time, will age in program like real life
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears) {
       return serverMap.values()
                .stream()
                //get Server Age will always be accurate due to Local Time, will age in program like real life
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.groupingBy(Server::getManufacturer));
    }

    @Override
    public double getAverageServerAge() {
        return serverMap.values()
                .stream()
                .mapToLong(Server::getServerAge)
                .average()
                .getAsDouble();
    }

    
}
