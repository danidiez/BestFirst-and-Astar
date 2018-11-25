package Variable;

import java.util.ArrayList;
import java.util.Arrays;

public class Result{
    private String algorithm, heuristic;
    private ArrayList<Point> path;
    private ArrayList<Point> explored;
    private double time;
    private Data data;

    public Result(Data data,String algorithm,String heurisic ,ArrayList<Point> path, ArrayList<Point> explored,double time) {
        this.data = data;
        this.algorithm = algorithm;
        this.heuristic = heurisic;
        this.path = path;
        this.explored = explored;
        this.time = time;
    }

    @Override
    public String toString() {
        char[][] resultPath =data.getCharMap();
        StringBuilder resultMap = new StringBuilder();
        for(Point exp:explored){
            resultPath[exp.getX()][exp.getY()]='*';
        }
        for(Point p:path){
                resultPath[p.getX()][p.getY()]='o';
        }
        for(int x=0; x<data.getHeight();x++){
            resultMap.append(Arrays.toString(resultPath[x])).append("\n");
        }
        return "algorithm: " + algorithm + '\n' +
                "heuristic: " + heuristic + '\n' +
                resultMap +
                "num of explored: " + explored.size() +
                ", time=" + time+"\n"
                ;

    }
}

