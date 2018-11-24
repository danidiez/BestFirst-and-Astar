package Variable;

import java.util.ArrayList;

public class Result{
    private String algorithm, heuristic;
    private ArrayList<Point> path;
    private int explored;
    private float time;

    public Result(String algorithm,String heurisic ,ArrayList<Point> path, int explored,float time) {
        this.algorithm = algorithm;
        this.heuristic = heurisic;
        this.path = path;
        this.explored = explored;
        this.time = time;
    }

    @Override
    public String toString() {
        return "algorithm='" + algorithm + '\n' +
                ", heuristic='" + heuristic + '\n' +
                ", path=" + path + '\n'+
                ", explored=" + explored +
                ", time=" + time
                ;
    }
}

