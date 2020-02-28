import java.util.*;
import java.awt.*;

public abstract class GameObject{
  protected int x,y,w,h;
  protected ID id;
  public boolean solid;

  public GameObject(int x, int y, int w, int h, boolean s){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.solid = s;
  }

  public GameObject(int x, int y, boolean s){
    this.x = x;
    this.y = y;
    this.solid = s;
  }

  public GameObject(int x, int y){
    this.x = x;
    this.y = y;
  }

  public abstract void tick();
  public abstract void render(Graphics g);

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

  public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

  public ID getID(){
    return id;
  }

  public void setID(ID id){
    this.id = id;
  }

  public Rectangle getBounds(){
    return new Rectangle(getX(), getY(), getW(), getH());
  }
}
