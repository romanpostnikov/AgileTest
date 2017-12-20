package org.test.agileengine;

import org.test.agileengine.exception.ImagesWithDifferentSizeException;
import org.test.agileengine.imageparts.Area;
import org.test.agileengine.imageparts.Image;
import org.test.agileengine.imageparts.Pixel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagesProcessor {
    private BufferedImage bufferedImageOne;
    private BufferedImage bufferedImageTwo;
    private File fileImageResult;
    private int[][] imageOnePixels;
    private int[][] imageTwoPixels;
    private int[][] imageResultPixels;

    public ImagesProcessor(File fileImageOne, File fileImageTwo) {

        //read files to bufferedImages
        try {
            bufferedImageOne = ImageIO.read(fileImageOne);
            bufferedImageTwo = ImageIO.read(fileImageTwo);
        } catch (IOException ex) {
            System.out.println("Exception while reading images to BufferedImage");
        }

        //create new file for resulting image
        fileImageResult = new File("C:/resultImage.png");
        try {
            fileImageResult.createNewFile();
        } catch (IOException ex) {
            System.out.println("Exception while creating resultFile");
        }

        //check if images have the same size
        try {
            if (bufferedImageOne.getHeight() != bufferedImageTwo.getHeight() ||
                    bufferedImageOne.getWidth() != bufferedImageTwo.getWidth()) {
                throw new ImagesWithDifferentSizeException();
            }
        } catch (ImagesWithDifferentSizeException e) {
            System.out.println("Images have different sizes, impossible to process");
        }

        imageOnePixels = getIntArrayOfPixels(bufferedImageOne);
        imageTwoPixels = getIntArrayOfPixels(bufferedImageTwo);
        imageResultPixels = getIntArrayOfPixels(bufferedImageOne);

    }

    //get the array of integer values of RGB, where pixel corresponds to cell
    public int[][] getIntArrayOfPixels(BufferedImage bufferedImage) {
        int[][] result = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                result[i][j] = bufferedImage.getRGB(i, j);
            }
        }
        return result;
    }

    public int[][] setIntArrayOfResultImage(int[][] imageOnePixels, int[][] imageTwoPixels) {
        Area[] areas = new Area[30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < imageOnePixels.length; j++) {
                for (int k = 0; k < imageOnePixels[j].length; k++) {
                    if (imageOnePixels[j][k] != imageTwoPixels[j][k] || imageOnePixels[j][k+1] != imageTwoPixels[j][k+1] ||
                    imageOnePixels[j+1][k+1] != imageTwoPixels[j+1][k+1] || imageOnePixels[j+1][k] != imageTwoPixels[j+1][k] ||
                            imageOnePixels[j+1][k-1] != imageTwoPixels[j+1][k-1] || imageOnePixels[j][k] != imageTwoPixels[j][k])

                }
            }
        }
    }








    /* try {
            ImageIO.write(bufferedImageOne, "png", fileImageResult);
        } catch (IOException ex) {
            System.out.println("IOException while writing bufferedImage to File");
        }*/

}
