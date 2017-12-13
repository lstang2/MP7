/**
 * A class that runs implements several simple transformations on 2D image arrays.
 * <p>
 * This file contains stub code for your image transformation methods that are called by the main
 * class. You will do your work for this MP in this file.
 * <p>
 * Note that you can make several assumptions about the images passed to your functions, both by the
 * web front end and by our testing harness:
 * <ul>
 * <li>You will not be passed empty images.</li>
 * <li>All images will have even width and height.</li>
 * </ul>
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/4/">MP4 Documentation</a>
 */
public class Transform {

    /**
     * Default amount to shift an image's position. Not used by the testing suite, so feel free to
     * change this value.
     */
    public static final int DEFAULT_POSITION_SHIFT = 16;

    /**
     * Pixel value to use as filler when you don't have any valid data. All white with complete
     * transparency. DO NOT CHANGE THIS VALUE: the testing suite relies on it.
     */
    public static final int FILL_VALUE = 0x00FFFFFF;

    /**
     * Shift the image left by the specified amount.
     * <p>
     * Any pixels shifted in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to shift to the left
     * @param amount the amount to shift the image to the left
     * @return the shifted image
     */
    public static int[][] shiftLeft(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                int position = x + amount;
                if (position < xMax) {
                    outputImage[x][y] = originalImage[position][y];
                } else {
                    outputImage[x][y] = FILL_VALUE;
                }
            }
        }
        return outputImage;
    }

    /*
     * Shift right like above.
     */

    /**
     *
     * @param originalImage the image to shift to the right
     * @param amount the amount to shift the image to the right
     * @return the shifted image
     */
    public static int[][] shiftRight(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                int position = x - amount;
                if (position >= 0) {
                    outputImage[x][y] = originalImage[position][y];
                } else {
                    outputImage[x][y] = FILL_VALUE;
                }
            }
        }

        return outputImage;
    }

    /**
     * Shift up like above.
     */

    /**
     *
     * @param originalImage the image to shift up
     * @param amount the amount to shift the image up
     * @return the shifted image
     */
    public static int[][] shiftUp(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                int position = y + amount;
                if (position < yMax) {
                    outputImage[x][y] = originalImage[x][position];
                } else {
                    outputImage[x][y] = FILL_VALUE;
                }
            }
        }

        return outputImage;
    }

    /**
     * Shift down like above.
     */
    /**
     *
     * @param originalImage the image to shift down
     * @param amount the amount to shift the image down
     * @return the shifted image
     */
    public static int[][] shiftDown(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                int position = y - amount;
                if (position >= 0) {
                    outputImage[x][y] = originalImage[x][position];
                } else {
                    outputImage[x][y] = FILL_VALUE;
                }
            }
        }

        return outputImage;
    }

    /**
     * Rotate the image left by 90 degrees around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to rotate left 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateLeft(final int[][] originalImage) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[yMax][xMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                int position = xMax - x - 1;
                if (position >= 0 && position < xMax) {
                    outputImage[y][position] = originalImage[x][y];
                } else {
                    outputImage[y][position] = FILL_VALUE;
                }
            }
        }

        return outputImage;
    }

    /*
     * Rotate the image right like above.
     */

    /**
     *
     * @param originalImage the image to rotate right 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateRight(final int[][] originalImage) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                int xPosition = y;
                int yPosition = xMax - x - 1;
                if (xPosition >= 0 && xPosition < xMax && yPosition >= 0 && yPosition < yMax) {
                    outputImage[x][y] = originalImage[xPosition][yPosition];
                } else {
                    outputImage[x][y] = FILL_VALUE;
                }
            }
        }

        return outputImage;
    }

    /*
     * Flip the image on the vertical axis across its center.
     */

    /**
     *
     * @param originalImage the image to flip on vertical axis
     * @return the flipped image
     */
    public static int[][] flipVertical(final int[][] originalImage) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                int position = yMax - y - 1;
                outputImage[x][y] = originalImage[x][position];
            }
        }
        return outputImage;
    }

    /*
     * Flip the image on the horizontal axis across its center.
     */
    /**
     *
     * @param originalImage the image to flip on horizontal axis
     * @return the flipped image
     */
    public static int[][] flipHorizontal(final int[][] originalImage) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                int position = xMax - x - 1;
                outputImage[x][y] = originalImage[position][y];
            }
        }

        return outputImage;
    }

    /**
     * Default amount to shift colors by. Not used by the testing suite, so feel free to change this
     * value.
     */
    public static final int DEFAULT_COLOR_SHIFT = 32;

    /** RGBA green shift value. */
    public static final int GREEN_SHIFT = 8;

    /** RGBA blue shift value. */
    public static final int BLUE_SHIFT = 16;

    /** RGBA alpha shift value. */
    public static final int ALPHA_SHIFT = 24;

    /** Max Value of code. */
    public static final int MAX_HEX = 0xff;

    /**
     * Add red to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add red to
     * @param amount the amount of red to add
     * @return the recolored image
     */
    public static int[][] moreRed(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                if ((originalImage[x][y] + amount) < MAX_HEX) {
                    outputImage[x][y] = originalImage[x][y] + amount;
                } else {
                    outputImage[x][y] = MAX_HEX;
                }
            }
        }
        return outputImage;
    }

    /*
     * Remove red from the image.
     */
    /**
     *
     * @param originalImage the image to remove red from
     * @param amount the amount of red to remove
     * @return the recolored image
     */
    public static int[][] lessRed(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                if ((originalImage[x][y] - amount) > 0) {
                outputImage[x][y] = originalImage[x][y] - amount;
            } else {
                outputImage[x][y] = 0;
            }
                }
        }
        return outputImage;
    }

    /*
     * Add green to the image.
     */
    /**
     *
     * @param originalImage the image to add green to
     * @param amount the amount of green to add
     * @return the recolored image
     */
    public static int[][] moreGreen(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                outputImage[x][y] = originalImage[x][y] + (amount << GREEN_SHIFT);
            }
        }

        return outputImage;
    }

    /*
     * Remove green from the image.
     */
    /**
     *
     * @param originalImage the image to remove green from
     * @param amount the amount of green to remove
     * @return the recolored image
     */
    public static int[][] lessGreen(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                outputImage[x][y] = originalImage[x][y] - (amount << GREEN_SHIFT);
            }
        }

        return outputImage;
    }

    /*
     * Add blue to the image.
     */
    /**
     *
     * @param originalImage the image to add blue to
     * @param amount the amount of blue to add
     * @return the recolored image
     */
    public static int[][] moreBlue(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                outputImage[x][y] = originalImage[x][y] + (amount << BLUE_SHIFT);
            }
        }

        return outputImage;
    }

    /*
     * Remove blue from the image.
     */
    /**
     *
     * @param originalImage the image to remove blue from
     * @param amount the amount of blue to remove
     * @return the recolored image
     */
    public static int[][] lessBlue(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                outputImage[x][y] = originalImage[x][y] - (amount << BLUE_SHIFT);
            }
        }

        return outputImage;
    }

    /*
     * Increase the image alpha channel.
     */
    /**
     *
     * @param originalImage the image to increase the alpha channel
     * @param amount the amount to increase the alpha channel
     * @return the restructured image
     */
    public static int[][] moreAlpha(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                outputImage[x][y] = originalImage[x][y] + (amount << ALPHA_SHIFT);
            }
        }

        return outputImage;
    }

    /*
     * Decrease the image alpha channel.
     */
    /**
     *
     * @param originalImage the image to decrease the alpha channel
     * @param amount the amount to decrease the alpha channel
     * @return the restructured image
     */
    public static int[][] lessAlpha(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                outputImage[x][y] = originalImage[x][y] - (amount << ALPHA_SHIFT);
            }
        }

        return outputImage;
    }

    /**
     * The default resize factor. Not used by the testing suite, so feel free to change this value.
     */
    public static final int DEFAULT_RESIZE_AMOUNT = 2;

    /**
     * Shrink in the vertical axis around the image center.
     * <p>
     * An amount of 2 will result in an image that is half its original height. An amount of 3 will
     * result in an image that's a third of its original height. Any pixels shrunk in from off
     * screen should be filled with FILL_VALUE. This function <i>does not modify the original
     * image</i>.
     *
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's height is reduced
     * @return the shrunken image
     */
    public static int[][] shrinkVertical(final int[][] originalImage, final int amount) {
        int xMax = originalImage.length;
        int yMax = originalImage[0].length;
        int[][] outputImage = new int[xMax][yMax];
        for (int y = 0; y < (yMax / DEFAULT_RESIZE_AMOUNT); y++) {
            for (int x = 0; x < xMax; x++) {

                outputImage[x][y] = (originalImage[x][y] + originalImage[x][y + 1])
                        / DEFAULT_RESIZE_AMOUNT;
            }
        }
        return outputImage;
    }

    /*
     * Expand in the vertical axis around the image center.
     */
    /**
     *
     * @param originalImage the image to expand in the vertical axis
     * @param amount the factor by which the image's height is expanded
     * @return the expanded image
     */
    public static int[][] expandVertical(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Shrink in the horizontal axis around the image center.
     */
    /**
     *
     * @param originalImage the image to shrink in the horizontal axis
     * @param amount the factor by which the image's width is shrunk
     * @return the shrunken image
     */
    public static int[][] shrinkHorizontal(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Expand in the horizontal axis around the image center.
     */
    /**
     *
     * @param originalImage the image to expand in the horizontal axis
     * @param amount the factor by which the image's width is expanded
     * @return the expanded image
     */
    public static int[][] expandHorizontal(final int[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Remove a green screen mask from an image.
     * <p>
     * This function should remove primarily green pixels from an image and replace them with
     * transparent pixels (FILL_VALUE), allowing you to achieve a green screen effect. Obviously
     * this function will destroy pixels, but it <i>does not modify the original image</i>.
     * <p>
     * While this function is tested by the test suite, only extreme edge cases are used. Getting it
     * work work will with real green screen images is left as a challenge for you.
     *
     * @param originalImage the image to remove a green screen from
     * @return the image with the green screen removed
     */
    public static int[][] greenScreen(final int[][] originalImage) {
        return null;
    }

    /**
     * A wild and mysterious image transform.
     * <p>
     * You are free to implement this in any way you want. It is not tested rigorously by the test
     * suite, but it should do something (change the original image) and <i>not modify the original
     * image</i>.
     * <p>
     * Call this function mystery. It should take only the original image as a single argument and
     * return a modified image.
     *
     * @param originalImage the image to perform a strange and interesting transform on
     * @return the image transformed in wooly and frightening ways
     */
    public static int[][] mystery(final int[][] originalImage) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     *
     * @param originalImage origna
     * @return spiral filter
     */

    public static int[][] spiral(final int[][] originalImage) {
        return null;
    }

}
