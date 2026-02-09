package mazegame;
import java.util.Scanner;

//Main class - handles the game loop, user input, and checking win/lose

public class Main {

 public static void main(String[] args) {

     int mazeSize = 8;
     int startEnergy = 20;

     Maze maze = new Maze(mazeSize);
     Player player = new Player(0, 0, startEnergy);
     Scanner sc = new Scanner(System.in);

     boolean running = true;

     System.out.println("=== MAZE ESCAPE ===");
     System.out.println("Find the exit (E) before you run out of energy!");
     System.out.println("W=Up, S=Down, A=Left, D=Right, Q=Quit\n");
     showMaze(maze, player);

     while (running) {

         System.out.println("Position: (" + player.getX() + ", " + player.getY() + ")");
         System.out.println("Energy: " + player.getEnergy());
         System.out.print("Move (W/A/S/D/Q): ");

         String input = sc.nextLine().trim().toUpperCase();

         // figure out where the player wants to go
         int nextX = player.getX();
         int nextY = player.getY();
         boolean validKey = true;

         if (input.equals("W")) {
             nextY = nextY + 1;
         } else if (input.equals("S")) {
             nextY = nextY - 1;
         } else if (input.equals("A")) {
             nextX = nextX - 1;
         } else if (input.equals("D")) {
             nextX = nextX + 1;
         } else if (input.equals("Q")) {
             System.out.println("Quitting. Bye!");
             running = false;
             continue;
         } else {
             System.out.println("Invalid key! Use W, A, S, D or Q.\n");
             validKey = false;
         }

         if (!validKey) continue;

         // check if the move would go outside the grid
         if (nextX < 0 || nextX >= mazeSize || nextY < 0 || nextY >= mazeSize) {
             System.out.println("Can't go outside the maze!\n");
             continue;
         }

         // check for wall
         if (maze.getTile(nextX, nextY).isWall()) {
             System.out.println("You hit a wall!\n");
             continue;
         }

         // move is valid so actually move the player
         if (input.equals("W")) player.moveUp();
         else if (input.equals("S")) player.moveDown();
         else if (input.equals("A")) player.moveLeft();
         else if (input.equals("D")) player.moveRight();

         showMaze(maze, player);

         // did the player reach the exit?
         if (maze.getTile(player.getX(), player.getY()).isExit()) {
             System.out.println("You escaped the maze!");
             running = false;
         }
         // did the player run out of energy?
         else if (player.getEnergy() <= 0) {
             System.out.println("Out of energy! Game over.");
             running = false;
         } else {
             System.out.println(); // blank line before next turn
         }
     }

     sc.close();
 }

 // prints the maze to console. P = player, E = exit, # = wall, . = empty
 // we print top-to-bottom so that (0,0) ends up at bottom-left
 static void showMaze(Maze maze, Player p) {
     int s = maze.getSize();
     for (int row = s - 1; row >= 0; row--) {
         for (int col = 0; col < s; col++) {
             if (col == p.getX() && row == p.getY()) {
                 System.out.print("P ");
             } else if (maze.getTile(col, row).isExit()) {
                 System.out.print("E ");
             } else if (maze.getTile(col, row).isWall()) {
                 System.out.print("# ");
             } else {
                 System.out.print(". ");
             }
         }
         System.out.println();
     }
     System.out.println();
 }
}

