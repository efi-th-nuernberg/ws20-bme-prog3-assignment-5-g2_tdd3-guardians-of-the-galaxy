public class Life implements ILife {
  
   boolean[][] generations = null;

  public static void main(String[] args) {
    Life l = new Life(new String[] {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " });
    l = (Life) l.nextGeneration();
  }


  public Life() {

    generations = new boolean[10][10];
    nukeAll();
  }

  public Life(String[] setup) {
    this();

    generations = new boolean[setup.length][setup[0].length()];
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != '.')
          setAlive(x, y);
        else
          setDead(x, y);

  }

  public Life(boolean[][] nextGeneration) {

    this();

    generations = nextGeneration;
  }

  @Override
  public void nukeAll() {
    // TODO Auto-generated method stub

if (generations == null)


      return;


    for (int i = 0; i < generations.length; i++) {
      int line = generations[i].length;
      for (int j = 0; j < line; j++) {

        generations[j][i] = false;
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
    
    
    return generations[x][y];
  }

  @Override
  public ILife nextGeneration() {
    boolean[][] nextGeneration = new boolean[generations.length][generations[0].length];

    for (int y = 0; y < generations.length; y++) {

      int line = generations[y].length;

      for (int x = 0; x < line; x++) {


        int tmp = countNeighbours(x, y);
        if (isAlive(x, y)) {

          if (tmp == 2 || tmp == 3){
            nextGeneration[x][y] = true;
          }
          else{
            nextGeneration[x][y] = false;
          }
        } else {
          if (tmp == 3){
            nextGeneration[x][y] = true;
          }
          else
          {
            nextGeneration[x][y] = false;
          }
        }
      }
    }
    return new Life(nextGeneration);
  }




  public int countNeighbours(int x, int y) {
    int neighbours = 0;
    
    if (isAlive(x, y + 1)){
      neighbours++;}
      if (isAlive(x - 1, y + 1)){
      neighbours++;}
      if (isAlive(x - 1, y)){
      neighbours++;}
      if (isAlive(x - 1, y - 1)){
      neighbours++;}
      if (isAlive(x, y - 1)){
      neighbours++;}
    if (isAlive(x + 1, y - 1)){
      neighbours++;}
    if (isAlive(x + 1, y)){
      neighbours++;}
    if (isAlive(x + 1, y + 1)){
      neighbours++;}
    
    
    
    
    return neighbours;
  }




}