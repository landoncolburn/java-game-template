import java.util.*;
import java.awt.*;

public class Handler {

  private LinkedList<GameObject> gameObjects;

  public Handler(){
    gameObjects = new LinkedList<GameObject>();
  }

  public void addObject(GameObject object){
    gameObjects.add(object);
  }

  public void removeObject(GameObject object){
    gameObjects.remove(object);
  }

  public void render(Graphics g){
    for(GameObject o : gameObjects){
      o.render(g);
    }
  }

  public void tick(){
    for(int i = 0; i<gameObjects.size(); i++){
      gameObjects.get(i).tick();
    }
  }

}
