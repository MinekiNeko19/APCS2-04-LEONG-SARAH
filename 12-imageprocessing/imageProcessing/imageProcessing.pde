void setup(){
  size(1544,495);
  PImage car = loadImage("redcar.jpg");
  PImage output = car.copy();
  Kernel k = new Kernel(new float[][]
   { {-2, -1, 0},
     {-1, 1, 1},
   {0, 1, 2} } );
  k.apply(car,output);
  image(car,0,0);
  image(output,car.width,0);
}
