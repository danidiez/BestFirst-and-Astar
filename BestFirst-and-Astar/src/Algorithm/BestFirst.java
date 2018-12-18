package Algorithm;
import Variable.*;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BestFirst extends Algorithm {


    public BestFirst(String heuristic, Data map, Point start, Point end, int height, int width) {
        this.heuristic = heuristic;
        this.map = map;
        this.start = start;
        this.end = end;
        this.height = height;
        this.width = width;
        this.pendingPoints = new PriorityQueue<>();
        this.visitedPoints = new ArrayList<>();
        pendingPoints.add(start);

    }

    public Result execute() {
        int numExplored = 0;
        while (!pendingPoints.isEmpty()) {
            Point actual = pendingPoints.poll();
            numExplored++;
            if (notVisited(actual)) visitedPoints.add(actual);
            if (actual.getX() == end.getX() && actual.getY() == end.getY()) {
                return new Result(map,"BestFirst", this.heuristic, actual.getPath(), visitedPoints, numExplored, actual.getTime());
            }
            else {
                for (Point p : getAdjacent(actual)) {
                    if (notVisited(p)){
                        if(!isPending(p)) {
                        addToPath(actual, p);
                        calculateTotalTime(actual,p);
                        calculateHeuristic(p, heuristic);
                        pendingPoints.add(p);
                    }
                 }
                }
            }
        }
        return result;
    }


    private void calculateHeuristic(Point next, String heuristic) {
        double result;
        switch (heuristic) {
            case "diference+distance":
                result = h1(next,end);
                next.setHeuristicVal(result);
                break;
            case "distance":
                result = h2(next,end);
                next.setHeuristicVal(result);
                break;
            case "time":
                result = h3(next, end);
                next.setHeuristicVal(result);
                break;
        }
    }

    private boolean isPending(Point p) {
        for (Point x : pendingPoints) {
            if (x.getX() == p.getX() && x.getY() == p.getY()) return true;
        }
        return false;
    }

}