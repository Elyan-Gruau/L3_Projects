package shape;

import svg.vector.Vector;

import java.awt.*;

public abstract class ABSShape implements IShape{
    protected Vector[] points;
    protected Vector anchorPoints;
    protected Color color;

    public ABSShape(Vector[] points, Vector anchorPoints) {
        this.points = points;
        this.anchorPoints = anchorPoints;
        this.color = Color.BLUE;
    }


    @Override
    public final Vector getAnchorPoint() {
        return anchorPoints;
    }

}
