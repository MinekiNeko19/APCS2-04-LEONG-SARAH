public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding, selected;
  boolean angry;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    colliding = false;
    selected = false;
    c = color(random(255),random(255),random(255));
    if (Math.random() < 0.05) angry = true; else angry = false;

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
    // you can also just add speed twice
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
      
      if (angry) rect(x-radius/2, y-radius/4,radius,2);
      rect(x-radius/2, y+radius/4,radius,2);
      text("dx: " + dx, x + radius, y);
      text("dy: " + dy, x + radius, y+20);
      
      //line(x,y,x+30*dx,y+30*dy); // direction check
    }
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
   if (dist(mouseX,mouseY,x,y) < radius) {
     selected = !selected;
     // testing
     turn(30);
   }
  }
  
  void collide(ArrayList<Cow>others) {
    colliding = false;
    for (Cow w : others) {
      if (this!=w) {
        if (dist(w.x,w.y,x,y) <= radius + w.radius) {
          w.colliding = true;
          colliding = true;
        }
      }
    }
  }

  /*Write a Cow method that will modify the dx and dy
   *such that the cow will change the direction it is moving
   *counter-clockwise by the specified angle (degrees).
   *Test this with any of the existing cow demos. (make the cows turn 30 degrees on click)
   */
  void turn(float angle){
    float r = dist(dx,0,0,dy);
    float original = atan2((float)dy,(float)dx);
    original += radians(angle);
    dy = -r*cos(original);
    dx = r*sin(original);
  }
  /*Write a Cow method that will modify the dx and dy
   *such that the cow will add dv to the magnitude of its velocity 
   *but maintain the same direction.
   *Test this with any of the existing cow demos. (make the cows get 2 units faster on click to test)
   */
  void changeSpeed(float dv){

  }
}
