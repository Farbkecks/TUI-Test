package tui_test;

import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        var graph = new ArrayList<Coordinate2D>();
        graph.add(new Coordinate2D(1, 2));
        graph.add(new Coordinate2D(2, 4));
        graph.add(new Coordinate2D(3, 8));
        graph.add(new Coordinate2D(4, 16));
        var drawer = new Drawer();
        Coordinate2D oldPoint = new Coordinate2D(1, 1);
        for (Coordinate2D point : graph) {
            drawer.setPoint(point, oldPoint);
            oldPoint.x = point.x;
            oldPoint.y = point.y;

        }
        drawer.print();
    }
}
