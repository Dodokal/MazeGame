package mazegame;

// each tile in the grid is either empty, a wall, or the exit

public class Tile {

    private boolean wall;
    private boolean exit;

    public Tile(boolean wall, boolean exit) {
        this.wall = wall;
        this.exit = exit;
    }

    public boolean isWall() {
        return wall;
    }

    public boolean isExit() {
        return exit;
    }

    // useful for debugging - prints what type of tile this is
    public String toString() {
        if (wall) return "WALL";
        if (exit) return "EXIT";
        return "EMPTY";
    }
}