package org.test.agileengine;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fileImageOne = new File("src/main/resources/imageOne.png");
        File fileImageTwo = new File("src/main/resources/imageTwo.png");
        Drawing.highlightDifferenceBetweenImages(fileImageOne, fileImageTwo);
    }
}
