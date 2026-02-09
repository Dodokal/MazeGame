package mazegame;
import java.util.Random;

// Maze class - builds the grid and places walls + exit randomly

public class Maze {

    private Tile[][] grid;
    private int size;

    public Maze(int size) {
        this.size = size;
        this.grid = new Tile[size][size];

        Random rand = new Random();

        // fill grid with tiles, some of them are walls (roughly 20% chance)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean wall = rand.nextInt(5) == 0; // 1 in 5 chance = ~20%
                grid[i][j] = new Tile(wall, false);
            }
        }

        // starting tile at (0,0) should not be a wall
        grid[0][0] = new Tile(false, false);

        // pick a random spot for the exit, but not at (0,0) where the player starts
        int ex = 0, ey = 0;
        while (ex == 0 && ey == 0) {
            ex = rand.nextInt(size);
            ey = rand.nextInt(size);
        }
        // place the exit tile there (overwrite whatever was there before)
        grid[ex][ey] = new Tile(false, true);
    }

    public Tile getTile(int x, int y) {
        return grid[x][y];
    }

    public int getSize() {
        return size;
    }
}