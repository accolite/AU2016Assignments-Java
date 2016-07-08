package chess_pac;

public class Board {
    private Tile[][] tile = new Tile[8][8];

    public Board() {
        super();
        for(int i=0; i<tile.length; i++){
            for(int j=0; j<tile.length; j++){
                this.tile[i][j] = new Tile(i, j);
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tile[x][y];
    }

}