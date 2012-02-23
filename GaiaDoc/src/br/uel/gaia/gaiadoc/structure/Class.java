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

	public List<String> getProperty(String propertyName){
		List<String> result = new ArrayList<String>();
		for (Annotation a : properties) {
			if (a.getName().equals(propertyName)){
				result.add(a.getContent());
				if(propertyName.equals("name") || propertyName.equals("description"))
					return result;
			}
		}
		return result;
	}
	
	public List<Annotation> getProperties() {
		return properties;
	}

	public void setProperties(List<Annotation> properties) {
		this.properties = properties;
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
