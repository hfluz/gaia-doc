package br.uel.gaia.gaiadoc;

/**
 * Classe que armazena o nome e o conteúdo da anotação.
 * @author humberto
 *
 */
public class Annotation {
	private String name;
	private String content;

	public Annotation(String name)
	{
		this.setName(name);
	}
	
	public Annotation(String name, String content)
	{
		this.setName(name);
		this.setContent(content);
	}
	
	/**
	 * Verifica se a anotação encontrada pertence ao conjunto de anotações
	 * GaiaDoc.
	 * 
	 * @return True, se a anotação for válida, False, em caso contrário.
	 */
	public boolean isValid()
	{
		switch (this.name.toLowerCase()) {
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
		if(this.content == null)
			this.content = content;
		else this.content += " " + content;
	}
}
