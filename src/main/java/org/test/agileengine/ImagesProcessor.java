package org.test.agileengine;

import org.test.agileengine.exception.ImagesWithDifferentSizeException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagesProcessor {
    public void highlightDifferenceBetweenImages(File fileImageOne, File fileImageTwo) {
        try {
            BufferedImage bufferedImageOne = ImageIO.read(fileImageOne);
            BufferedImage bufferedImageTwo = ImageIO.read(fileImageTwo);

            int imageOneHeight = bufferedImageOne.getHeight();
            int imageOneWidth = bufferedImageOne.getWidth();
            int imageTwoHeight = bufferedImageTwo.getHeight();
            int imageTwoWidth = bufferedImageTwo.getWidth();

            try {
                if (imageOneHeight != imageTwoHeight && imageOneWidth != imageTwoWidth) {
                    throw new ImagesWithDifferentSizeException();
                }
            } catch (ImagesWithDifferentSizeException e) {
                System.out.println("Images have different sizes, impossible to compare");
            }

            Graphics2D imageOneGraphics = bufferedImageOne.createGraphics();

            for (int i = 0; i < imageOneWidth; i++) {
                for (int j = 0; j < imageOneHeight; j++) {
                    if (bufferedImageOne.getRGB(i, j) != bufferedImageTwo.getRGB(i, j)) {
                        bufferedImageOne.setRGB(i, j, 0);
                        //imageOneGraphics.drawRect(i, j, 12, 12);
                    }
                }
                System.out.println();
            }

            ImageIO.write(bufferedImageOne, "png", fileImageOne);

        } catch (IOException e) {
            System.out.println("IOException caught in highlightDifferenceBetweenImages");
        }

    }

}
