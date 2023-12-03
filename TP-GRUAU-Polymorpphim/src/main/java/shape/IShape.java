package shape;

import svg.vector.IVecteur;

import java.awt.*;//todo bad import ??

public interface IShape {

    public double getSuperficy();
    public IVecteur getAnchorPoint();
    public double getPermimeter();
    public void paint(Graphics g);

}
