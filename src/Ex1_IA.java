import Algorithm.*;
import Variable.*;

import java.util.LinkedList;
import java.util.List;


public class Ex1_IA {
    private static int[][] map = {
                    {1, 0, -1, 1, 3, 2, 3, 4, 3, 1},
                    {2, 1, -1, 2, 4, 2, 2, 4, 2, 2},
                    {5, 3, -1, 2, 3, 2, -1, 3, 3, 3},
                    {3, 3, 1, 3, 4, 3, -1, 1, 2, 2},
                    {2, 2, 2, 3, 6, 4, -1, 1, 2, 1},
                    {-1, -1, -1, -1, 3, 3, -1, 0, 2, -1},
                    {-1, -1, -1, -1, 2, 4, -1, 2, 2, -1},
                    {2, 3, 4, 3, 1, 3, -1, 3, 2, -1},
                    {3, 5, 6, 5, 2, 3, -1, 5, 3, -1},
                    {5, 6, 7, 6, 4, 4, -1, 6, 4, 5},
            };
            /*
    private static int[][] map = {
                    {1, 0, -1, 1, 3, 2, 3, 4, 3, 1},
                    {2, 1, -1, 2, 4, 2, 2, 4, 2, 2},
                    {5, 3, -1, 2, 3, 2, x, 3, 3, 3},
                    {3, 3, 1, 3, 4, 3, -1, 1, 2, 2},
                    {2, 2, 2, 3, 6, 4, -1, 1, 2, 1},
                    {-1, -1, -1, -1, 3, 3, -1, 0, 2, -1},
                    {-1, -1, -1, -1, 2, 4, -1, 2, 2, -1},
                    {2, 3, 4, 3, 1, 3, -1, 3, 2, -1},
                    {3, 5, 6, 5, 2, 3, -1, 5, 3, -1},
                    {5, 6, 7, 6, 4, 4, -1, 6, 4, 5},
            };
            */


            public static void main(String[] args) {
                Point c1 = new Point(0, 0, map[0][0]);
                Point c2 = new Point(9, 9, map[9][9]);
                List<String> heuristics = new LinkedList<>();
                heuristics.add("time+distance");
                heuristics.add("distance");
                heuristics.add("time");

                Data data = new Data(map);
                for (String h : heuristics) {
                    BestFirst b = new BestFirst(h, data, c1, c2, map.length, map[0].length);
                    Result result = b.execute();
                    System.out.println(result);
/*
                    AStar a = new AStar(h, data, c1, c2, map.length, map[0].length);
                    result = a.execute();
                    System.out.println(result);
  */
                }

            }
        }
