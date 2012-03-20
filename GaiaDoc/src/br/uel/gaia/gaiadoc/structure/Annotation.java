package br.uel.gaia.gaiadoc.structure;

import java.util.List;

/**
 * Classe que armazena o nome e o conteúdo da anotação.
 * 
 * @author humberto
 * 
 */
public class Annotation {
	private String name;
	private String content;
	private List<String> parameters;

	public Annotation(String name) {
		this.setName(name);
	}

	public Annotation(String name, String content) {
		this.setName(name);
		this.setContent(content);
	}

	/**
	 * Verifica se a anotação encontrada pertence ao conjunto de anotações
	 * GaiaDoc.
	 * 
	 * @return True, se a anotação for válida, False, em caso contrário.
	 */
	public boolean isValid() {
		switch (this.name.toLowerCase()) {
		case "name":
		case "description":
		case "writer":
		case "performer":
		case "extension":
		case "specialrequirement":
		case "precondition":
		case "postcondition":
		case "basicflow":
		case "alternativeflow":
			return true;
		default:
			return false;
		}
	}

	public boolean belongsToMethod() {
		switch (this.name.toLowerCase()) {
		case "description":
		case "performer":
		case "basicflow":
		case "alternativeflow":
			return true;
		default:
			return false;
		}
	}

	public boolean belongsToAttribute() {
		switch (this.name.toLowerCase()) {
		case "description":
			return true;
		default:
			return false;
		}
	}

	public boolean belongsToClass() {
		switch (this.name.toLowerCase()) {
		case "name":
		case "description":
		case "writer":
		case "performer":
		case "extension":
		case "specialrequirement":
		case "precondition":
		case "postcondition":
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
		if (this.content == null)
			this.content = content;
		else
			this.content += " " + content;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
}
