package br.uel.gaia.gaiadoc;

import java.util.ArrayList;
import java.util.List;

import br.uel.gaia.gaiadoc.structure.Annotation;

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
		if (!line.isEmpty()) {
			String[] vector = line.split(" ");
			String result = "";
			for (String s : vector) {
				if (!s.equals("/**") && !s.equals("*/") && !s.equals("*")
						&& !s.equals("\t") && !s.isEmpty())
					result += s + " ";
			}
			if (!result.isEmpty())
				// Substring que exclui o último espaço em branco.
				return result.substring(0, result.length() - 1);
			else
				return result;
		} else
			return line;
	}

	/**
	 * Verifica se a linha faz parte de um bloco de comentário.
	 * 
	 * @param line
	 *            Linha do arquivo.
	 * @return True, se for bloco de comentário, False, em caso contrário.
	 */
	public static boolean isCommentBlock(String line) {
		line = line.replaceAll("\\t", "");
		if (!line.isEmpty()) {
			String[] vector = line.split(" ");
			for (String s : vector) {
				if (!s.isEmpty()) {
					if (s.equals("/**") || s.equals("*"))
						return true;
					else
						return false;
				}
			}

		}
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
	public static boolean isCommentBlockEnd(String line) {
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
	public static Annotation getAnnotation(String line) {
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
		Annotation annotation;
		if (annotationFound) {
			if (name.startsWith("basicFlow")) {
				annotation = new Annotation("basicFlow");
				annotation.setParameters(getParametroBasicFlow(name));
			} else if (name.startsWith("alternativeFlow")) {
				annotation = new Annotation("alternativeFlow");
				annotation.setParameters(getParametroAlternativeFlow(name));
			} else {
				System.out.println(name);
				annotation = new Annotation(name, content.substring(0,
						content.length() - 1));
			}
			if (annotation.isValid())
				return annotation;
			else
				return null;
		} else
			return null;
	}

	private static List<String> getParametroAlternativeFlow(String name) {
		boolean entreParenteses = false;
		String parametro = "";
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == '(')
				entreParenteses = true;
			else if (name.charAt(i) == ')' && parametro.length() == 0) {
				System.out.println("ERRO: Nenhum parâmetro foi informado.");
			} else if (name.charAt(i) == ')') {
				entreParenteses = false;
				break;
			}
			if (entreParenteses && name.charAt(i) != ')'
					&& name.charAt(i) != '(')
				parametro += name.charAt(i);
			if (i + 1 == name.length() && entreParenteses)
				System.out
						.println("ERRO: Término de linha sem fechar parenteses.");
		}
		String[] splitedList = parametro.split(",");
		if (splitedList[0].startsWith("'"))
			splitedList[0] = splitedList[0].substring(1);
		if (splitedList[0].endsWith("'"))
			splitedList[0] = splitedList[0].substring(0,
					splitedList[0].length() - 1);
		List<String> parametros = new ArrayList<>();
		parametros.add(splitedList[0]);
		parametros.add(splitedList[1]);
		return parametros;
	}

	public static List<String> getParametroBasicFlow(String name) {
		boolean entreParenteses = false;
		String parametro = "";
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == '(')
				entreParenteses = true;
			else if (name.charAt(i) == ')' && parametro.length() == 0) {
				System.out.println("ERRO: Nenhum parâmetro foi informado.");
			} else if (name.charAt(i) == ')') {
				entreParenteses = false;
				break;
			}
			if (entreParenteses && name.charAt(i) != ')'
					&& name.charAt(i) != '(')
				parametro += name.charAt(i);
			if (i + 1 == name.length() && entreParenteses)
				System.out
						.println("ERRO: Término de linha sem fechar parenteses.");
		}
		List<String> parametros = new ArrayList<>();
		parametros.add(parametro);
		return parametros;
	}
}
