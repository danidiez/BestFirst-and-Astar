package Algorithm;
import Variable.*;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BestFirst extends Algorithm {


    public BestFirst(String heuristic, int[][] map, Point start, Point end, int heigth, int width) {
        this.heuristic = heuristic;
        this.map = map;
        this.start = start;
        this.end = end;
        this.heigth = heigth;
        this.width = width;
        this.pendingPoints = new PriorityQueue<>();
        this.visitedPoints = new ArrayList<>();
        pendingPoints.add(start);

    }

    public Result execute() {
        while (!pendingPoints.isEmpty()) {
            Point actual = pendingPoints.poll();
            if (!wasVisited(actual)) visitedPoints.add(actual);
            if (actual.getX() == end.getX() && actual.getY() == end.getY()) {
                return new Result("BestFirst", this.heuristic, actual.getPath(), visitedPoints.size(), actual.getTime());
            }
            else {
                for (Point p : getAdjacent(actual)) {
                    if (!wasVisited(p)){
                        if(!isPending(p)) {
                        addToPath(actual, p);
                        calculateTime(actual, p);
                        calculateHeuristic(actual, p, heuristic);
                        pendingPoints.add(p);
                    }
                 }
                }
            }
        }
        return result;
    }


    private void calculateHeuristic(Point act, Point p, String heuristic) {
        float result;
        switch (heuristic) {
            case "cost":
                result = h1(act, p);
                p.addToHeuristicVal(result);
                break;
            case "time":
                result = h2(act, p);
                p.addToHeuristicVal(result);
                break;
            case "h3":
                result = h3(act, p);
                p.addToHeuristicVal(result);
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