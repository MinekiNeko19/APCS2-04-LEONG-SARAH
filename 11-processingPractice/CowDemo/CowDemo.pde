ArrayList<Cow> particles;
void setup() {
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 100; i++)
    particles.add(new Cow());
}

void draw() {
  background(200);
  for (Cow c : particles) {
    c.move();
    c.display();
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
   //Read about mouseClicked()/mousePressed() and related methods in the documentation.
   //Right click: add a cow at the mouse location.
   //Left click: call the click of each cow
   //println(mouseButton);
   if (mouseButton==39) { // right
     Cow a = new Cow(10, mouseX,mouseY,10,10);
     particles.add(a);
   }
   if (mouseButton==37) { // left
     for (Cow c : particles) {
       if (dist(mouseX,mouseY,c.x,c.y) < c.radius) {
         c.dx++;
       }
     }
   }
}

void keyPressed() {
  //Read about keyPressed() in the documentation.
  //hint:
  //println(keyCode);
  if (keyCode==32) {
    particles = new ArrayList<Cow>();
  }
}
