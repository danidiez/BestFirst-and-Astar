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
     int height, width;
     Point start;
     Point end;
     Result result;

    double h1(Point p1,Point p2){
        double nextDx = p2.getX()-p1.getX();
        double nextDy = p2.getY()-p1.getY();
        return (p2.getVal()-p1.getVal())+Math.sqrt(Math.pow(nextDx,2)+Math.pow(nextDy,2));
}
    double h2(Point p1,Point p2){
        double nextDx = p2.getX() - p1.getX();
        double nextDy = p2.getY() - p1.getY();
        return (Math.sqrt(Math.pow(nextDx,2)+Math.pow(nextDy,2)));
    }
    double h3(Point p1,Point p2){
        return calculateTime(p1,p2);
    }

    void addToPath(Point act,Point p){
        ArrayList<Point> tempPath= act.getPath();
        p.attachToPath(tempPath);
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
        if ((actual.getX() + 1 < height) && (map.getData(x + 1,y) != -1)) adjacents.add(new Point(x + 1, y, map.getData(x + 1,y)));
        if ((actual.getY() + 1 < width) && (map.getData(x,y + 1) != -1)) adjacents.add(new Point(x, y + 1, map.getData(x,y + 1)));
        if ((actual.getY() - 1 >= 0) && (map.getData(x,y - 1) != -1)) adjacents.add(new Point(x, y - 1, map.getData(x,y - 1)));
        return adjacents;
    }
    private double calculateTime(Point act, Point next){
        if(next.getVal()-act.getVal()>=0) return 1+(next.getVal()-act.getVal());
        else return 0.5F;
    }

}
