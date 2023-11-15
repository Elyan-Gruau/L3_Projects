package svg.polygone.model;

import java.util.Iterator;

import svg.vecteur.Vector;

public class PolygoneIterable implements Iterable<Vector> {
	private Polygone polygon;
	public PolygoneIterable(Polygone p) {
		this.polygon = p;
	}

	@Override
	public Iterator<Vector> iterator() {
		return new PolygoneIterator(polygon);
	}
}