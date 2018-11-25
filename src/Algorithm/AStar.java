package Algorithm;

import Variable.Data;
import Variable.Point;
import Variable.Result;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class AStar extends Algorithm{

    public AStar(String heuristic, Data data, Point start, Point end, int heigth, int width) {
        this.heuristic = heuristic;
        this.map = data;
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
            if (notVisited(actual)) visitedPoints.add(actual);
            if (actual.getX() == end.getX() && actual.getY() == end.getY()) {
                return new Result(map,"A*", this.heuristic, actual.getPath(), visitedPoints, actual.getTime());
            } else {
                for (Point p : getAdjacent(actual)) {
                    if (notVisited(p)){
                            calculateTotalTime(actual, p);
                            calculateHeuristic(actual, p, heuristic);
                            addToPath(actual, p);
                            pendingPoints.add(p);
                        }
                    }
                }
            }
        return result;
        }
    private void calculateHeuristic(Point act, Point p, String heuristic) {
        double result;
        switch (heuristic) {
            case "h1":
                result = h1(act, p);
                result += p.getTime();
                p.setHeuristicVal(result);
                break;
            case "h2":
                result = h2(act, p);
                result +=  p.getTime();
                p.setHeuristicVal(result);
                break;
            case "h3":
                result = h3(act, p);
                result +=  p.getTime();
                p.setHeuristicVal(result);
                break;
        }
    }
}


