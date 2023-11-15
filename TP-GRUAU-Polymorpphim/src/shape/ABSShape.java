package shape;

import svg.vector.Vector;

public abstract class ABSShape implements IShape{
    protected Vector[] points;
    protected Vector anchorPoints;

    public ABSShape(Vector[] points, Vector anchorPoints) {
        this.points = points;
        this.anchorPoints = anchorPoints;
    }


    @Override
    public final Vector getAnchorPoint() {
        return anchorPoints;
    }

}
