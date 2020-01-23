import java.util.*;
import java.awt.*;

public abstract class GameObject{
  protected int x,y;

  public GameObject(int x, int y){
    this.x = x;
    this.y = y;
  }

  public abstract void tick();
  public abstract void render(Graphics g);
  public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
