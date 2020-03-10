package problem1;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.util.Arrays;

public class Raster
{
    private Pixel[][] raster;
public Raster(int rows,int columns){
    if(rows<1||columns<1)
        throw new IllegalArgumentException("Cannot be less than 1");
    raster = new Pixel[rows][columns];
}

    public int getRowSize() {
        return raster.length;
    }

    public int getColumnSize() {
        return raster[0].length;
    }
    @Override
    public String toString(){
        return new StringBuilder().append(this.getRowSize()).append(" rows by ").append(this.getColumnSize()).append(" columns").toString();
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Raster))
            return false;
        Raster r1= (Raster) obj;
        if(this.getRowSize()!=r1.getRowSize() || this.getColumnSize()!=r1.getColumnSize())
            return false;
        for (int i=0;i<getRowSize();i++)
            for (int j=0;j<getColumnSize();j++)
                if((raster[i][j].equals(r1.raster[i][j])))
                    return true;
                return false;
}
    public void addPixel(Pixel pixel) {
        int x = (int) pixel.getPoint().getX();
        int y = (int) pixel.getPoint().getY();
        raster[y][x] = pixel;
    }

    public WritableImage drawImage() {
        WritableImage image = new WritableImage(raster[0].length, raster.length);
        PixelWriter writer = image.getPixelWriter();
        for (int i = 0; i < raster.length; i++) {
            for (int j = 0; j < raster[i].length; j++) {
                raster[i][j].draw(writer);
            }
        }
        return image;
    }
}
