import java.awt.*;
import java.awt.image.*;

public class MainMenu extends GameObject{

  private BufferedImage logo;
  private BufferedImage button;

  public MainMenu(){
    super(0, 0);
    logo = Game.gameInstance.bil.loadImage("assets/GameLogo.png");
    button = Game.gameInstance.bil.loadImage("assets/button.png");
  }

  public void tick(){

  }

  public Rectangle getBounds(){return null;}

  public void render(Graphics g){
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, Game.gameInstance.size.width, Game.gameInstance.size.height);
    g.drawImage(logo, Game.gameInstance.size.width/2-200, 50, 400, 200, null);
    g.drawImage(button, Game.gameInstance.size.width/2-150, 400, 300, 150, null);
  }

}
