package com.twrog.examples.stream.domainExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServerStreamDao {
    private Map<String, Server> serverMap = new HashMap<>();

    public void addServer(Server server) {
	serverMap.put(server.getName(), server);
    }

    public Server getServer(String name) {
	return serverMap.get(name);
    }

    public void removeServer(String name) {
	serverMap.remove(name);
    }

    public List<Server> getAllServers() {
	return new ArrayList<Server>(serverMap.values());
    }

    public Map<String, List<Server>> getAllServersGroupByManufacturer() {
	return serverMap.values().stream().collect(Collectors.groupingBy(Server::getManufacturer));
    }

    public List<Server> getServersByManufacturer(String manufacturer) {
	return serverMap.values().stream().filter(s -> s.getManufacturer().equalsIgnoreCase(manufacturer))
		.collect(Collectors.toList());
    }

    public List<Server> getServersOlderThan(int ageInYears) {
	return serverMap.values().stream().filter(s -> s.getServerAge() > ageInYears).collect(Collectors.toList());
    }

    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears) {
	return serverMap.values().stream().filter(s -> s.getServerAge() > ageInYears)
		.collect(Collectors.groupingBy(Server::getManufacturer));
    }

    public double getAverageServerAge() {
	return serverMap.values().stream().mapToLong(s -> s.getServerAge()).average().getAsDouble();
    }
}
