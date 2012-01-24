package br.uel.gaia.gaiadoc.structure;

import java.util.List;

import br.uel.gaia.gaiadoc.Annotation;

public class Attribute implements Component {
	private List<Annotation> properties;

	public Attribute(List<Annotation> annotations) {
		this.properties = annotations;
	}

	public List<Annotation> getAnnotations() {
		return properties;
	}

	public void setAnnotations(List<Annotation> annotations) {
		this.properties = annotations;
	}
}
