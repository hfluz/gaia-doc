package br.uel.gaia.gaiadoc;

/**
 * Classe que contém diversos métodos para manipular strings.
 * 
 * @author humberto
 * 
 */
public class StringUtils {
	public static void main(String[] args) {
		String line = " /** @nAMe Classe que contém diversos métodos para manipular strings. */";
		if (isCommentBlock(line))
			System.out.println("É bloco de comentário.");
		else
			System.out.println("Não é bloco de comentário.");
		String annotation = getAnnotationName(line);
		if (annotation != null)
			System.out.println("Anotação " + annotation + " é " + (isValidAnnotation(annotation) ? "válida." : "inválida."));
		else
			System.out.println("Anotação não encontrada.");
		System.out.println(clearLine(line));
	}


	public static String clearLine(String line) {
		String[] vector = line.split(" ");
		String result = "";
		for (String s : vector) {
			if (!s.equals("/**") && !s.equals("*/") && !s.equals("*")
					&& !s.startsWith("@") && !s.isEmpty())
				result += s + " ";
		}
		return result.substring(0, result.length() - 1); // Substring que exclui
															// o último espaço
															// em branco.
	}

	public static boolean isCommentBlock(String line) {
		String[] vector = line.split(" ");
		if (vector[1].equals("/**") || vector[1].equals("*"))
			return true;
		else
			return false;
	}

	public static String getAnnotationName(String line) {
		String[] vector = line.split(" ");
		for (String s : vector) {
			if (!s.equals("/**") && !s.equals("*") && !s.isEmpty() && s.startsWith("@"))
				return s.substring(1, s.length());
		}
		return null;
	}
	
	public static boolean isValidAnnotation(String annotation)
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
}
