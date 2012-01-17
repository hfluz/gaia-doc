package br.uel.gaia.gaiadoc;

/**
 * Classe que contém diversos métodos para manipular strings.
 * 
 * @author humberto
 * 
 */
public class StringUtils {
	/**
	 * Limpa a linha passada como parâmetro, removendo os marcadores de
	 * comentário.
	 * 
	 * @param line
	 *            Linha do arquivo.
	 * @return Linha formatada.
	 */
	public static String clearLine(String line) {
		String[] vector = line.split(" ");
		String result = "";
		for (String s : vector) {
			if (!s.equals("/**") && !s.equals("*/") && !s.equals("*")
					&& !s.isEmpty())
				result += s + " ";
		}
		return result.substring(0, result.length() - 1); // Substring que exclui
															// o último espaço
															// em branco.
	}

	/**
	 * Verifica se a linha faz parte de um bloco de comentário.
	 * 
	 * @param line
	 *            Linha do arquivo.
	 * @return True, se for bloco de comentário, False, em caso contrário.
	 */
	public boolean isCommentBlock(String line) {
		String[] vector = line.split(" ");
		if (vector[1].equals("/**") || vector[1].equals("*"))
			return true;
		else
			return false;
	}

	/**
	 * Verifica se a linha encerra um bloco de comentário.
	 * 
	 * @param line
	 *            Linha do arquivo.
	 * @return True, se encerrar o bloco de comentário, False, em caso
	 *         contrário.
	 */
	public boolean isCommentBlockEnd(String line) {
		String[] vector = line.split(" ");
		if (vector[1].equals("*/"))
			return true;
		else
			return false;
	}

	/**
	 * Método que extrai a anotação da linha, caso haja alguma.
	 * 
	 * @param line
	 *            Linha do arquivo.
	 * @return Anotação, se houver, ou nulo, em caso contrário.
	 */
	public Annotation getAnnotation(String line) {
		String[] vector = line.split(" ");
		String name = "";
		String content = "";
		boolean annotationFound = false; // assegura que apenas o conteúdo que
											// vem após a anotação é adicionado.
		for (String s : vector) {
			if (s.startsWith("@")) {
				name = s.substring(1, s.length());
				annotationFound = true;
			} else if (annotationFound)
				content += s + " ";
		}
		Annotation annotation = new Annotation(name, content.substring(0,
				content.length() - 1));
		if (annotation.isValid())
			return annotation;
		else
			return null;
	}
}
