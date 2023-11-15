package shape;

import svg.vector.Vector;

import java.awt.*;//todo bad import ??

public interface IShape {

    public double getSuperficy();
    public Vector getAnchorPoint();
    public double getPermimeter();
    public void paint(Graphics g);

}
