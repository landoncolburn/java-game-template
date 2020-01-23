import java.awt.*;
import java.awt.image.*;

public class Splashscreen extends GameObject{

  private BufferedImage[] studioLogo = new BufferedImage[10];

  public Splashscreen(){
    super(0, 0);
    for(int i = 0; i<10; i++){
      studioLogo[i] = Game.gameInstance.bil.loadImage("assets/studio/GameDesignLogo"+i);
    }
  }

  public void tick(){}
  public Rectangle getBounds(){return null;}

  public void render(Graphics g){
    g.drawImage(studioLogo[0], Game.gameInstance.size.width/2-150, Game.gameInstance.size.height/2-45, null);
  }

}
