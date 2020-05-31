package techQuestions;

import java.util.*;

public class PrisonCells {

        public static void main(String[] args) {
            int[] states = {1, 1, 1, 0, 1, 1, 1, 1};
            int days = 2;
            System.out.println(cellCompete(states, days).toString());
        }

    public static List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        // just an edge case detection:
        if (states == null || states.length == 0) {
            List<Integer> output = new ArrayList<Integer>();
            for (int state: states) {
                output.add(state);
            }
            return output;
        }
        // making sure I understand question:
        // always eight houses in a straight line
        // 1 == active
        // 0 == inactive
        // if (neighbors both == 1 || neighbors both == 0) {
        //     current cell == 0
        // } else {
        //     current cell == 1
        // }
        // limit to integer array == 0 (inactive)

        // make sure to consider previous state when updating other
        // cells. state info updated simultaneously!

        // I understand that we must look for a cycle
        // and break out of some loop if we find this cycle
        // create and initalize a boolean variable to check if
        // we're in a cycle:
        boolean cycle = false;
        // we need a set to determine if the next day calculation
        // is in a cycle:
        Set<String> cycleSet = new HashSet<String>();
        // need an integer variable to know what cycle we're in
        int cycleIndex = 0;

        // I will create a helper function to find the cells states
        // for a day's iteration; we call this helper calculateDay()
        // helper takes integer list as an argument

        // for each day that runs, we must decrement the number of
        // days that we will run, i.e. days--
        for (int i = 0; i < days; i++) {
            // calculate the next day's cell values
            int[] calculateDay = calculateDay(states);
            // generate a string that is all the cell values at this day:
            String dayValues = Arrays.toString(calculateDay);
            System.out.println(dayValues);
            // if we've never seen these values before, increment the cycle
            if (!cycleSet.contains(dayValues)) {
                cycleSet.add(dayValues);
                cycleIndex++;
            } else {
                // we know we're in a cycle!
                cycle = true;
                // break out of this loop as explained above
                break;
            }
            states = calculateDay;
        }
        if (cycle) {
            days = days % cycleIndex;
            for (int j = 0; j < days; j++) {
                states = calculateDay(states);
            }
        }
        // compilation check:
        List<Integer> outputList = new ArrayList<Integer>(states.length);
        for (int i = 0; i < states.length; i++) {
            outputList.add(i, states[i]);
        };
        return outputList;
    }

    public static int[] calculateDay(int[] states) {
        // create temp variable that will be output of helper
        int[] helperOutput = new int[states.length];
        // bounds must not hit boundaries of integer list
        for (int i = 1; i < states.length - 1; i++) {
            // edge cases!
            if (i == 0) {
                if (states[2] == 0) {
                    helperOutput[i] = 0;
                } else {
                    helperOutput[i] = 1;
                }
                continue;
            }
            if (i == states.length - 1) {
                if (states[states.length - 2] == 0) {
                    helperOutput[i] = 0;
                } else {
                    helperOutput[i] = 1;
                }
                break;
            }
            if (states[i-1] == states[i+1]) {
                helperOutput[i] = 0;
            } else {
                helperOutput[i] = 1;
            }
        }
        return helperOutput;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        if(cells==null || cells.length==0 || N<=0) return cells;
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){ //store cell state
                set.add(key);
                cycle++;
            }
            else{ //hit a cycle
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            N%=cycle;
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }
        }
        List<Integer> outputList = new ArrayList<Integer>(cells.length);
        for (int i = 0; i < cells.length; i++) {
            outputList.add(i, cells[i]);
        };
        System.out.println(outputList.toString());
        return cells;
    }

    private static int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }
}
