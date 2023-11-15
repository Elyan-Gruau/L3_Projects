package svg.polygone.model;

import java.util.Iterator;

import svg.vector.Vector;

class PolygoneIterator implements Iterator<Vector> {
	private Polygone polygon;
	private int current = 0;
	PolygoneIterator(Polygone polygon) {
		this.polygon = polygon;
	}

	@Override
	public boolean hasNext() {
		return current < polygon.numberOfPoints();
	}

	@Override
	public Vector next() {
		return polygon.get(current++);
	}

}
