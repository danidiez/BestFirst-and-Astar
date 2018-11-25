package Algorithm;

import Variable.Point;
import Variable.Result;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Algorithm {
     String heuristic;
     int[][] map;
     ArrayList<Point> visitedPoints;
     PriorityQueue<Point> pendingPoints;
     int heigth, width;
     Point start;
     Point end;
     Result result;


    float h1(Point act,Point p){
        //TODO: Estimate time

    }

    float h2(Point act,Point p){
        //TODO: Estimate Cost
    }

    float h3(Point act,Point p){
        //TODO: Estimate both
    }

    void addToPath(Point act,Point p){
        ArrayList<Point> tempPath= act.getPath();
        p.attachToPath(tempPath);
    }

    void calculateTime(Point act, Point p) {
        if(p.getVal()-act.getVal()>=0) p.setTime(act.getTime()+1+(p.getVal()-act.getVal()));
        else p.setTime(act.getTime()+0.5F);
    }

    boolean notVisited(Point p) {
        for (Point x : visitedPoints) {
            if (x.getX() == p.getX() && x.getY() == p.getY()) return false;
        }
        return true;
    }

    ArrayList<Point> getAdjacent(Point actual) {
        ArrayList<Point> adjacents = new ArrayList<>();
        int x = actual.getX();
        int y = actual.getY();
        if ((actual.getX() - 1 >= 0) && (map[x - 1][y]) != -1) adjacents.add(new Point(x - 1, y, map[x - 1][y]));
        if ((actual.getX() + 1 < heigth) && (map[x + 1][y]) != -1) adjacents.add(new Point(x + 1, y, map[x + 1][y]));
        if ((actual.getY() + 1 < width) && (map[x][y + 1]) != -1) adjacents.add(new Point(x, y + 1, map[x][y + 1]));
        if ((actual.getY() - 1 >= 0) && (map[x][y - 1]) != -1) adjacents.add(new Point(x, y - 1, map[x][y - 1]));
        return adjacents;
    }

}
