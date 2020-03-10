package problem1;

import javafx.geometry.Point2D;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Pixel
{
private Point2D point;
private Color color;
public Pixel(Point2D point, Color color){
    if(point==null||color==null)
        throw new NullPointerException("Cannot be null");
this.point=point;
this.color=color;
}

  public Point2D getPoint() {
        return this.point;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
    double xcoordinate= point.getX();
    double ycoordinate= point.getY();
        return "<"+ xcoordinate + ", " + ycoordinate + ", " +  color +">";
    }

    @Override
    public boolean equals(Object obj) {
 if (! (obj instanceof Pixel))
     return false;
 Pixel p1= (Pixel) obj;
 return (this.point.equals(p1.point)) && (this.color==p1.color);
}

   @Override
    public int hashCode() {
     int res=13;
     res= 51*res + point.hashCode();
     res= 51*res + color.hashCode();
     return res;
}

    public void draw(PixelWriter writer) {
        writer.setColor((int) point.getX(), (int) point.getY(), color);
    }
}
