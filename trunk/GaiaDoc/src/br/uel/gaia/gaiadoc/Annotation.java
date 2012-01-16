package br.uel.gaia.gaiadoc;


public class Annotation {
	private String name;
	private String content;

	public Annotation(String name, String content)
	{
		this.setName(name);
		this.setContent(content);
	}
	
	public boolean isValid(String annotation)
	{
		switch (annotation.toLowerCase()) {
		case "name":
		case "description":
		case "writer":
		case "performer":
		case "extension":
		case "specialrequirements":
		case "precondition":
		case "postcondition":
		case "basicflow":
		case "alternativeflow":
			return true;
		default:
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
