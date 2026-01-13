package gameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Object {
    Image img;
   // BufferedImage bufferedImg =BufferedImage



    int ziseX;
    int ziseY;
    public Object(Image img,int ziseX,int ziseY){
     this.img=img;
     this.ziseX=ziseX;
     this.ziseY=ziseY;
    }
}
