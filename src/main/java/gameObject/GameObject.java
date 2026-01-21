package gameObject;

import java.awt.*;

public abstract class GameObject {
    Image img;
    int positionX;
    int positionY;
    public int ziseX;
    public int ziseY;
    public GameObject(Image img,int positionX,int positionY ,int ziseX, int ziseY){
     this.img=img;
     this.positionX =positionX;
     this.positionY=positionY;
     this.ziseX=ziseX;
     this.ziseY=ziseY;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
