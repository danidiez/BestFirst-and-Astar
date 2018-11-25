package Algorithm;

import Variable.Data;
import Variable.Point;
import Variable.Result;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Algorithm {
     String heuristic;
     Data map;
     ArrayList<Point> visitedPoints;
     PriorityQueue<Point> pendingPoints;
     int heigth, width;
     Point start;
     Point end;
     Result result;


    double h1(Point act,Point next){
        double nextDx = end.getX()-next.getX();
        double nextDy = end.getY()-next.getY();
        return act.getTime()+calculateThisTime(act,next)+(2*Math.sqrt(Math.pow(nextDx,2)+Math.pow(nextDy,2)));
    }

    double h2(Point act,Point next) {
        double nextDx = end.getX() - next.getX();
        double nextDy = end.getY() - next.getY();
        return act.getHeuristicVal()+ (Math.sqrt(Math.pow(nextDx,2)+Math.pow(nextDy,2)));
    }
    double h3(Point act,Point next){
        return act.getHeuristicVal()+calculateThisTime(act,next);
    }

    void addToPath(Point act,Point p){
        ArrayList<Point> tempPath= act.getPath();
        p.attachToPath(tempPath);
    }

    double calculateThisTime(Point act, Point next){
        if(next.getVal()-act.getVal()>=0) return 1+(next.getVal()-act.getVal());
        else return 0.5F;
    }
    void calculateTotalTime(Point act, Point next) {
        if(next.getVal()-act.getVal()>=0) next.SetTime(act.getTime()+1+(next.getVal()-act.getVal()));
        else next.SetTime(act.getTime()+0.5F);
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
        if ((actual.getX() - 1 >= 0) && (map.getData(x - 1,y) != -1)) adjacents.add(new Point(x - 1, y, map.getData(x - 1,y)));
        if ((actual.getX() + 1 < heigth) && (map.getData(x + 1,y) != -1)) adjacents.add(new Point(x + 1, y, map.getData(x + 1,y)));
        if ((actual.getY() + 1 < width) && (map.getData(x,y + 1) != -1)) adjacents.add(new Point(x, y + 1, map.getData(x,y + 1)));
        if ((actual.getY() - 1 >= 0) && (map.getData(x,y - 1) != -1)) adjacents.add(new Point(x, y - 1, map.getData(x,y - 1)));
        return adjacents;
    }

}
