package techquestions;

import java.util.ArrayList;
import java.util.List;

public class UndergroundSystem {
	int id;
    String stationName;
    int t;
    String startStation;
    String endStation;
    List<String> concat = new ArrayList<>();
    List<String> concatEnd = new ArrayList<>();

	public UndergroundSystem() {
    
    }
    
    public void checkIn(int id, String stationName, int t) {
        this.id = id;
        this.stationName = stationName;
        this.t = t;
        
        concat.add(id + " " + stationName + " " + t);
    }
    
    public void checkOut(int id, String stationName, int t) {
    	this.id = id;
        this.stationName = stationName;
        this.t = t;
        
        concatEnd.add(id + " " + stationName + " " + t);
    }
    
    public double getAverageTime(String startStation, String endStation) {
    	List<Integer> startTimes = new ArrayList<>();
        for (String start : concat) {
        	if (start.split(" ")[1] == startStation) {
        		startTimes.add(Integer.parseInt(start.split(" ")[2]));
        	}
        }
        List<Integer> endTimes = new ArrayList<>();
        for (String end : concatEnd) {
        	if (end.split(" ")[1] == startStation) {
        		endTimes.add(Integer.parseInt(end.split(" ")[2]));
        	}
        }
        double test = 22.0;
        return test;
    }
}
