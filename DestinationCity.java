package techQuestions;

/*
Purpose: You are given the array paths, where paths[i] = [cityAi, cityBi]
means there exists a direct path from cityAi to cityBi. Return the destination
city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop,
therefore, there will be exactly one destination city.

Author: Erich Meissner
Date: 5/2/2020
Time: 10:33 PM
*/


import java.util.*;

public class DestinationCity {
    public static void main(String[] args) {
        List<String> cities1 = new ArrayList<String>();
        cities1.add("London");
        cities1.add("New York");
        List<String> cities2 = new ArrayList<String>();
        cities2.add("New York");
        cities2.add("Lima");
        List<String> cities3 = new ArrayList<String>();
        cities3.add("Lima");
        cities3.add("Sao Paulo");

        List<List<String>> paths = new ArrayList<List<String>>();
        paths.add(cities1);
        paths.add(cities2);
        paths.add(cities3);

        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<String, String>();
        for (List trip: paths) {
            map.put(trip.get(0).toString(), trip.get(1).toString());
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
//            System.out.println(pair.getValue());
            if (!map.containsKey(pair.getValue())) {
//                System.out.println("hi");
                return pair.getValue().toString();
            };
        }
        return "";
    }
}
