package problem1;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageDrawerDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private final String REF1 = "https://www.dailymoss.com/wp-content/uploads/2018/01/99-little-bugs-in-the-code-99-little-bugs-in-30065379.png";
    private final String REF2 = "https://www.dailymoss.com/wp-content/uploads/2018/01/b85f9841e30fa1bfafe1626efd41d3cc.jpg";

    @Override
    public void start(Stage primaryStage) {
        // Uncomment these lines after Raster and Pixel are done/correct.
        Raster raster1 = createRaster(REF1);
        Raster raster2 = createRaster(REF2);
        ImageView view = new ImageView(raster1.drawImage());
        ImageView view2 = new ImageView(raster2.drawImage());
        showImages(primaryStage, view, view2);
    }

    private void showImages(Stage primaryStage, ImageView view, ImageView view2) {
        Group root = new Group();
        addToLayout(view, root, 50);
        addToLayout(view2, root, 600);
        Scene scene = new Scene(root, 1200, 700);
        primaryStage.setTitle("Image!!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addToLayout(ImageView view, Group root, int i) {
        view.setLayoutX(i);
        view.setLayoutY(100);
        root.getChildren().add(view);
    }

    // Uncomment this method after Raster and Pixel are done/correct
    private Raster createRaster(String url) {
        Image image = new Image(url);
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();
        Raster raster = new Raster(height, width);
        PixelReader reader = image.getPixelReader();
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color = reader.getColor(i, j);
                Point2D point = new Point2D(i, j);
                raster.addPixel(new Pixel(point, color));
            }
        }
        return raster;
    }
}
