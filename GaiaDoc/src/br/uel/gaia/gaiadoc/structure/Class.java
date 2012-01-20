package br.uel.gaia.gaiadoc.structure;

import java.util.List;

import br.uel.gaia.gaiadoc.Annotation;

public class Class implements Component {
	private List<Annotation> annotations;
	private List<Method> methods;
	private List<Attribute> attributes;

	public List<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<Annotation> annotations) {
		this.annotations = annotations;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
}
