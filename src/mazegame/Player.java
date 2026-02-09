package mazegame;
import java.util.Random;
//Player class - keeps track of where the player is and how much energy they have left

public class Player {

 private int x;
 private int y;
 private int energy;

 public Player(int x, int y, int energy) {
     this.x = x;
     this.y = y;
     this.energy = energy;
 }

 // move in each direction and subtract energy
 public void moveUp() {
     this.y = y + 1;
     this.energy = energy - 1;
 }

 public void moveDown() {
     this.y = y - 1;
     this.energy = energy - 1;
 }

 public void moveLeft() {
     this.x = x - 1;
     this.energy = energy - 1;
 }

 public void moveRight() {
     this.x = x + 1;
     this.energy = energy - 1;
 }

 // getters
 public int getX() { return x; }
 public int getY() { return y; }
 public int getEnergy() { return energy; }
}
