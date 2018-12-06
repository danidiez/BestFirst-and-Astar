package Variable;

public class Data {
    private int[][] data;

    public Data(int[][] map){
        this.data = map;
    }

    public int getData(int x,int y){ return data[x][y];}

    char[][] getCharMap() {
        char[][]result = new char[this.getHeight()][this.getLength()];
        for (int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                if(data[x][y]!=-1) result[x][y]='-';
                else result[x][y]='X';
            }
        }
        return result;
    }
    int getHeight(){return data.length;}
    private int getLength(){return data[0].length;}

}
