package Variable;
import java.util.ArrayList;


public class Point implements Comparable<Point>{
    private int x;
    private int y;
    private int val;
    private float heuristicVal;
    private ArrayList<Point> path;
    private float time;

    public Point(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
        this.path = new ArrayList<>();
        this.path.add(this);
        this.time = 0;
        this.heuristicVal = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVal() {
        return val;
    }

    public ArrayList<Point> getPath() {
        return this.path;
    }

    public float getHeuristicVal() {
        return heuristicVal;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public void addToHeuristicVal(float heuristicVal) {
        this.heuristicVal += heuristicVal;
    }

    public void attachToPath(ArrayList<Point> pathList) {
            this.path.addAll(pathList);
        }

    @Override
    public String toString() {
        return  "("+x+","+y+")";
    }

    @Override
    public int compareTo(Point o) {
        if(this.heuristicVal>o.heuristicVal) return 1;
        else if(this.heuristicVal<=heuristicVal) return -1;
        return 0;
    }
}
