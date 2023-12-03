package svg.polygone.model;

import java.util.Iterator;

import svg.vector.IVecteur;

class PolygoneIterator implements Iterator<IVecteur> {
	private PolygoneOld polygon;
	private int current = 0;
	PolygoneIterator(PolygoneOld polygon) {
		this.polygon = polygon;
	}

	@Override
	public boolean hasNext() {
		return current < polygon.numberOfPoints();
	}

	@Override
	public IVecteur next() {
		return polygon.get(current++);
	}

}
