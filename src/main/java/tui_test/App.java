package tui_test;

import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        var graph = new ArrayList<Coordinate2D>();
        graph.add(new Coordinate2D(5, 1));
        graph.add(new Coordinate2D(7, 2));
        graph.add(new Coordinate2D(9, 5));
        graph.add(new Coordinate2D(17, 13));
        graph.add(new Coordinate2D(27, 13));
        graph.add(new Coordinate2D(37, 17));
        graph.add(new Coordinate2D(44, 7));
        var drawer = new Drawer();
        Coordinate2D pointOld = new Coordinate2D(1, 1);
        for (Coordinate2D pointNew : graph) {
            drawer.drawBetweenTwoPoints(pointNew, pointOld);
            pointOld.x = pointNew.x;
            pointOld.y = pointNew.y;

        }
        drawer.print();
    }
}
