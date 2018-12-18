package Algorithm;

import Variable.Data;
import Variable.Point;
import Variable.Result;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class AStar extends Algorithm{

    public AStar(String heuristic, Data data, Point start, Point end, int height, int width) {
        this.heuristic = heuristic;
        this.map = data;
        this.start = start;
        this.end = end;
        this.height = height;
        this.width = width;
        this.pendingPoints = new PriorityQueue<>();
        this.visitedPoints = new ArrayList<>();
        pendingPoints.add(start);

}

    public Result execute() {
        int numVisited = 0;
        while (!pendingPoints.isEmpty()) {
            Point actual = pendingPoints.poll();
            numVisited++;
            if (notVisited(actual)) visitedPoints.add(actual);
            if (actual.getX() == end.getX() && actual.getY() == end.getY()) {
                return new Result(map, "A*", this.heuristic, actual.getPath(), visitedPoints, numVisited, actual.getTime());
            }
            else {
                for (Point p : getAdjacent(actual)) {
                    if (notVisited(p)) {
                        calculateTotalTime(actual, p);
                        calculateHeuristic(actual, p, heuristic);
                        addToPath(actual, p);
                        pendingPoints.add(p);
                    }
                }
            }
            visitedPoints.add(actual);
        }
        return result;
    }
    private void calculateHeuristic(Point act ,Point next, String heuristic) {
        double result;
        switch (heuristic) {
            case "diference+distance":
                result = act.getCost()+ h1(act,next);
                next.setCost(result);
                result =+ h1(next,end);
                next.setHeuristicVal(result);
                break;
            case "distance":
                result = act.getCost()+ h2(act,next);
                next.setCost(result);
                result =+ h2(next,end);
                next.setHeuristicVal(result);
                break;
            case "time":
                result = act.getCost()+ h3(act,next);
                next.setCost(result);
                result =+ h3(next,end);
                next.setHeuristicVal(result);
                break;
        }
    }
}


