package br.uel.gaia.gaiadoc.structure;

import java.util.ArrayList;
import java.util.List;


public class Class implements Component {
	private List<Annotation> properties;
	private List<Method> methods;
	private List<Attribute> attributes;
	
	public Class(){
		properties = new ArrayList<Annotation>();
		methods = new ArrayList<Method>();
		attributes = new ArrayList<Attribute>();
	}

	public List<Annotation> getAnnotations() {
		return properties;
	}

	public void setAnnotations(List<Annotation> annotations) {
		this.properties = annotations;
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
