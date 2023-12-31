package shape;

import svg.vector.IVecteur;

import java.awt.*;

public abstract class ABSShape implements IShape{

    protected IVecteur anchorPoint;
    protected Color colorFill = Color.BLUE;

    public Color getColorFill() {
        return colorFill;
    }

    @Override
    public final IVecteur getAnchorPoint() {
        return anchorPoint;
    }

}
