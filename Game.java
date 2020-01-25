import java.awt.*;
import java.awt.image.*;
import java.awt.Event;

public class Game extends Canvas implements Runnable {

  private static final long serialVersionUID = 42l;

  public static Game gameInstance;
  public Handler handler;
  private boolean isRunning = false;
  private Thread thread;
  public Dimension size = new Dimension(1000, 600);
  private BufferedImage studioLogo;
  public BufferedImageLoader bil = new BufferedImageLoader();
  public MouseMotionInput mmi;
  public MouseInput mi;

  public Game(){
    new Window("Game", size, this);
    start();

    handler = new Handler();
    gameInstance = this;

    mmi = new MouseMotionInput(handler);
    mi = new MouseInput(handler);

    handler.addObject(new Splashscreen());

    this.addMouseListener(mi);
    this.addMouseMotionListener(mmi);
  }

  public void start(){
    isRunning = true;
    thread = new Thread(this);
    thread.start();
  }

  public void stop(){
    isRunning = false;
    try{
      thread.join();
    } catch(InterruptedException e){
      e.printStackTrace();
    }
  }

  @Override
  public void run(){
    this.requestFocus();
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    while (isRunning) {
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      while (delta >= 1) {
        tick();
        delta--;
      }
      render();
      frames++;
      if (System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        frames = 0;
      }
    }
    stop();
  }

  public void render(){
    BufferStrategy bs = this.getBufferStrategy();
    if(bs==null){
      this.createBufferStrategy(3);
      return;
    }
    Graphics g = bs.getDrawGraphics();
    //////////////////////////////////
    ///////----DRAW IN HERE----///////
    //////////////////////////////////

    g.setColor(new Color(50, 50, 50));
    g.fillRect(0, 0, size.width, size.height);

    handler.render(g);

    //////////////////////////////////
    g.dispose();
    bs.show();
  }

  public void tick(){
    handler.tick();
  }

  public static void main(String[] args) {
    new Game();
  }
}
