public class Kernel {
  float[][]kernel;
  
  /*Constructor takes the kernel that will be applied to the image*/
  public Kernel(float[][]init) {
    kernel = init;
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    if (x >= img.width-1 || x <= 0 ||
      y >= img.height-1 || y <= 0) return color(0);
    color r = 0;    
    color g = 0;
    color b = 0;
    
    for (int i = -1; i < 1; i++) {
      for (int j = -1; j < 1; j++) {
        r += kernel[i+1][j+1] * red(img.get(x+i,y+j));
      }
    }
    
    
    for (int i = -1; i < 1; i++) {
      for (int j = -1; j < 1; j++) {
        g += kernel[i+1][j+1] * green(img.get(x+i,y+j));
      }
    }
    
    
    for (int i = -1; i < 1; i++) {
      for (int j = -1; j < 1; j++) {
        b += kernel[i+1][j+1] * blue(img.get(x+i,y+j));
      }
    }
    r /= 9;
    g /= 9;
    b /= 9;
    
    return color(r,g,b);
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
    for (int x = 0; x < source.width; x++) {
      for (int y = 0; y < source.height; y++) {
        color c = calcNewColor(source,x,y);
        destination.set(x,y,c);
      }
    }
  }

}
