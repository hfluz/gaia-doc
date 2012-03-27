package br.uel.gaia.gaiadoc.structure;

import java.util.List;

public class Method implements Component, Comparable<Method> {
	private List<Annotation> properties;
	private String invokedBy;
	private String invokes;

	public Method(List<Annotation> properties) {
		this.properties = properties;
	}

	public String getProperty(String property) {
		for (Annotation a : properties)
			if (a.getName().equals(property))
				return a.getContent();
		return null;
	}

	public List<Annotation> getProperties() {
		return properties;
	}

	public void setProperties(List<Annotation> properties) {
		this.properties = properties;
	}

	public boolean isBasic() {
		for (Annotation a : properties)
			if (a.getName().equals("basicFlow"))
				return true;
		return false;
	}

	public boolean isAlternative() {
		for (Annotation a : properties)
			if (a.getName().equals("alternativeFlow"))
				return true;
		return false;
	}

	public Annotation getBasicFlow() {
		for (Annotation a : properties) {
			if (a.getName().equals("basicFlow"))
				return a;
		}
		return null;
	}

	public Annotation getAlternativeFlow() {
		for (Annotation a : properties) {
			if (a.getName().equals("alternativeFlow"))
				return a;
		}
		return null;
	}

	@Override
	public int compareTo(Method o) {
		Integer seq = getBasicFlow().getParameters().get(0) != null ? Integer
				.valueOf(getBasicFlow().getParameters().get(0)) : null;
		Integer seq2 = o.getBasicFlow().getParameters().get(0) != null ? Integer
				.valueOf(o.getBasicFlow().getParameters().get(0)) : null;
		if (seq == null && seq2 != null)
			return -1;
		else if (seq != null && seq2 == null)
			return +1;
		else if (seq != null && seq2 != null)
			return seq.compareTo(seq2);
		else {
			seq = getAlternativeFlow().getParameters().get(1) != null ? Integer
					.valueOf(getAlternativeFlow().getParameters().get(1)) : null;
			String name = getAlternativeFlow().getParameters().get(0);
			seq2 = o.getAlternativeFlow().getParameters().get(1) != null ? Integer
					.valueOf(o.getAlternativeFlow().getParameters().get(1)) : null;
			String name2 = o.getAlternativeFlow().getParameters().get(0);
			if (name.compareTo(name2) != 0)
				return name.compareTo(name2);
			else
				return seq.compareTo(seq2);
		}
	}
}
