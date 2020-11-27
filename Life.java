public class Life implements ILife {

  boolean[][] generations = new boolean[15][15];

  public static void main(String[] args) {

    Life l = new Life(new String[] {
      "***  ",
      "     ",
      "     ",
      "     ",
      "     "
    });
    l = (Life) l.nextGeneration();
 
  }

  public Life() {
    nukeAll();
  }

  public Life(String[] setup) {
    this();
    for (int y = 0; y < setup.length; y++)
    for (int x = 0; x < setup[y].length(); x++)
    if (setup[y].charAt(x) != ' ') setAlive(x, y);
  }

  public int getDimX(int index) {
    return generations[index].length;

  }

  public int getDimY() {
    return generations.length;

  }@Override
  public void nukeAll() {

    for (int i = 0; i < getDimY(); i++) {
      for (int j = 0; j < getDimX(i); j++) {
        generations[i][j] = false;
      }
    }
  }

  @Override
  public void setAlive(int x, int y) {
    // TODO Auto-generated method stub
    generations[x][y] = true;
  }

  @Override
  public void setDead(int x, int y) {
    // TODO Auto-generated method stub
    generations[x][y] = false;
  }

  @Override
  public boolean isAlive(int x, int y) {

    if (x >= 0 && x < getDimY()) {
      if (y >= 0 && y < getDimX(x)) {
        return generations[x][y];
      }
    }
    return false;
  }
  
  @Override
  public ILife nextGeneration() {
    boolean[][] nextGeneration = new boolean[getDimY()][getDimX(0)];
  
    for (int y = 0; y < getDimY(); y++) {

      int line = getDimX(y);

      for (int x = 0; x < line; x++) {

        int tmp = countNeighbours(x, y);
        if (isAlive(x, y)) {

          if (tmp == 2 || tmp == 3) {
            nextGeneration[x][y] = true;
          } else {
            nextGeneration[x][y] = false;
          }
        } else {
          if (tmp == 3) {
            nextGeneration[x][y] = true;
          } else {
            nextGeneration[x][y] = false;
          }
        }
      }
    }
    generations= nextGeneration;
    return this;
  }

  public int countNeighbours(int x, int y) {
    int neighbours = 0;

    if (isAlive(x, y + 1)) {
      neighbours++;
    }
    if (isAlive(x - 1, y + 1)) {
      neighbours++;
    }
    if (isAlive(x - 1, y)) {
      neighbours++;
    }
    if (isAlive(x - 1, y - 1)) {
      neighbours++;
    }
    if (isAlive(x, y - 1)) {
      neighbours++;
    }
    if (isAlive(x + 1, y - 1)) {
      neighbours++;
    }
    if (isAlive(x + 1, y)) {
      neighbours++;
    }
    if (isAlive(x + 1, y + 1)) {
      neighbours++;
    }
    return neighbours;
  }

}