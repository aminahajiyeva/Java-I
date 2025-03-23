/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kšlling and David J. Barnes
 * @version 2016.02.29
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle moon, phase;
    private boolean drawn;
    //private Canvas canvas;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        wall = new Square();
        window = new Square();
        roof = new Triangle();  
        moon = new Circle();
        drawn = false;
        //canvas.getCanvas();
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        if(!drawn) {
            wall.moveHorizontal(-140);
            wall.moveVertical(20);
            wall.changeSize(120);
            wall.makeVisible();

            window.changeColor("black");
            window.moveHorizontal(-120);
            window.moveVertical(40);
            window.changeSize(40);
            window.makeVisible();

            roof.changeSize(60, 180);
            roof.moveHorizontal(20);
            roof.moveVertical(-60);
            roof.makeVisible();

            moon.changeColor("blue");
            moon.moveHorizontal(150);
            moon.moveVertical(-40);
            moon.changeSize(80);
            moon.makeVisible();
            drawn = true;
        }
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        wall.changeColor("white");
        window.changeColor("black");
        roof.changeColor("white");
        moon.changeColor("white");
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        wall.changeColor("red");
        window.changeColor("black");
        roof.changeColor("green");
        moon.changeColor("blue");
    }

    /**
     * Model the different phases of the moon
     */
    public void moonPhases()
    {
        Circle phase = new Circle(); // make new circle to use as a shadow to show the moon phases
        phase.changeColor("black");
        phase.changeSize(80); // make phase same size as moon for proper display
        phase.moveHorizontal(71); // move shadow to be just right of the moon for proper shadow display
        phase.moveVertical(-40); // move shadow to be at same position as moon
        phase.makeVisible(); // make shadow visible
        phase.slowMoveHorizontal(200); // gradually move shadow for the phases of the moon to be seen
    }
}
