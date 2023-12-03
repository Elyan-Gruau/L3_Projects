package svg.polygone.model;

import java.util.Iterator;

import svg.vector.IVecteur;

public class PolygoneIterable implements Iterable<IVecteur> {
	private PolygoneOld polygon;
	public PolygoneIterable(PolygoneOld p) {
		this.polygon = p;
	}

	@Override
	public Iterator<IVecteur> iterator() {
		return new PolygoneIterator(polygon);
	}
}