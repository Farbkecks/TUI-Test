package tui_test;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        var drawer = new Drawer();
        boolean sleep = false;
        for (int i = 0; i < 50; i++) {
            sleep = drawer.setPoint(i, i, sleep);
        }
        drawer.print();
    }
}
