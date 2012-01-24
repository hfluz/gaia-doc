package br.uel.gaia.gaiadoc.structure;

import java.util.List;

import br.uel.gaia.gaiadoc.Annotation;

public class Method implements Component{
	private List<Annotation> properties;
	private String invokedBy;
	private String invokes;
	
	public Method(List<Annotation> properties)
	{
		this.properties = properties;
	}
	
	public List<Annotation> getProperties() {
		return properties;
	}
	public void setProperties(List<Annotation> properties) {
		this.properties = properties;
	}
}
