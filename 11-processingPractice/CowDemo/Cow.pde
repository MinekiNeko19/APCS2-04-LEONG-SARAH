public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding, selected;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    colliding = false;
    selected = false;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    if (colliding && selected) {     
      x += 2*dx;
      y += 2*dy;    
    } else {
      x += dx;
      y += dy;
    }
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  
  void display() {
    stroke(0);
    collide(particles);
    if (colliding) {
      fill(color(255,0,0,50));
    } else {
      fill(c);
    }
    
    ellipse(x, y, radius*2, radius*2);
    
    fill(0);
    if (selected) {
      rect(x-radius/2, y-radius/4,radius/4,(radius/4));
      rect(x+radius/2, y-radius/4,radius/4,(radius/4));
      text("x: " + x, x + radius, y);
      text("y: " + y, x + radius, y+20);
    }
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
   if (dist(mouseX,mouseY,x,y) < radius) {
     if (selected) {
         selected = false;
         //println("clicked false");
       } else {
         selected = true;
         //println("clicked true");
       }
   }
  }
  
  void collide(ArrayList<Cow>others) {
    colliding = false;
    for (Cow w : others) {
      if (this!=w) {
        if (dist(w.x,w.y,x,y) < radius + w.radius) {
          w.colliding = true;
          colliding = true;
        }
      }
    }
  }

}
