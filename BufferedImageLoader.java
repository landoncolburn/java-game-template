import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class BufferedImageLoader{

  private BufferedImage image;

  public BufferedImage loadImage(String path){
    try{
      image = ImageIO.read(new File(path));
    } catch(Exception e){
      e.printStackTrace();
    }
    return image;
  }

}
