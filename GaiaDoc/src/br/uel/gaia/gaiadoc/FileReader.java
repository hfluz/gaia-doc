package br.uel.gaia.gaiadoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import br.uel.gaia.gaiadoc.exception.InvalidAnnotationException;
import br.uel.gaia.gaiadoc.structure.Annotation;
import br.uel.gaia.gaiadoc.structure.Attribute;
import br.uel.gaia.gaiadoc.structure.Class;
import br.uel.gaia.gaiadoc.structure.Component;
import br.uel.gaia.gaiadoc.structure.Method;

/**
 * Classe responsável por ler o arquivo e convertê-lo em um objeto do tipo
 * br.uel.gaia.gaiadoc.structure.Class, que posteriormente será convertida em
 * PDF.
 * 
 * @author humberto
 * 
 */
public class FileReader {
	private Path file;
	private Status status;
	private Block block;
	private br.uel.gaia.gaiadoc.structure.Class classe;
	List<Annotation> temp;

	/**
	 * Estados do leitor.
	 * 
	 * @author humberto
	 * 
	 */
	public enum Status {
		CLASS, ATTRIBUTE, METHOD, FINAL
	}

	public enum Block {
		NEW, SAME
	}

	public FileReader(Path path) {

		if (Files.exists(path) && Files.isRegularFile(path))
			file = path;
		status = Status.CLASS;
		block = Block.NEW;
		classe = new Class();
		// TODO disparar exceção.
	}

	public List<Component> read() {
		Charset charset = Charset.forName("UTF8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				switch (status) {
				case CLASS:
					processInitial(line);
					break;
				case ATTRIBUTE:
					processAttribute(line);
					break;
				case METHOD:
					processMethod(line);
					break;
				case FINAL:
					processFinal(line);
					break;
				default:
					break;
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} catch (InvalidAnnotationException iae) {
			System.err.format("IOException: %s%n", iae);
		}
		return null;
	}

	/**
	 * Bloco inicial, que descreve as informações do caso de uso, representado
	 * pela classe encontrada.
	 * 
	 * @param line
	 *            Linha do arquivo.
	 */
	public void processInitial(String line) throws InvalidAnnotationException {
		if (block.equals(Block.NEW)) {
			if (StringUtils.isCommentBlock(line)) {
				line = StringUtils.clearLine(line);
				if (!line.isEmpty()) {
					Annotation a = StringUtils.getAnnotation(line);
					if (a != null) {
						temp = new ArrayList<Annotation>();
						temp.add(a);
						block = Block.SAME;
					}
				}
			}
		} else {
			if (StringUtils.isCommentBlock(line)) {
				line = StringUtils.clearLine(line);
				Annotation a = StringUtils.getAnnotation(line);
				if (a != null) {
					if (a.getName() != null) {
						if (a.belongsToClass())
							temp.add(a);
						else throw new InvalidAnnotationException(a.getName());
					} else {
						temp.get(temp.size() - 1).setContent(a.getContent());
					}
				}
			} else if (StringUtils.isCommentBlockEnd(line)) {
				block = Block.NEW;
				status = Status.ATTRIBUTE;
				classe.setProperties(temp);
			}
		}
	}

	/**
	 * Método que processa o arquivo a partir do fim do primeiro bloco de
	 * comentário. A cada novo bloco encerrado, se o status for igual a A, quer
	 * dizer que o bloco de comentário pertence a um atributo. Se as anotações @basicFlow
	 * ou @alternativeFlow forem encontradas o status muda para B e o método
	 * processB passa a ser chamado ao invés.
	 * 
	 * @param line
	 *            Linha do arquivo.
	 */
	public void processAttribute(String line) {
		if (block.equals(Block.NEW)) {
			if (StringUtils.isCommentBlock(line)) {
				line = StringUtils.clearLine(line);
				if (!line.isEmpty()) {
					Annotation a = StringUtils.getAnnotation(line);
					if (a != null) {
						temp = new ArrayList<Annotation>();
						temp.add(a);
						if (a.getName().equals("basicFlow")
								|| a.getName().equals("alternativeFlow"))
							status = Status.METHOD;
						block = Block.SAME;
					}
				}
			}
		} else {
			if (StringUtils.isCommentBlock(line)) {
				line = StringUtils.clearLine(line);
				Annotation a = StringUtils.getAnnotation(line);
				if (a != null) {
					if (a.getName() != null) {
						temp.add(a);
						if (a.getName().equals("basicFlow")
								|| a.getName().equals("alternativeFlow"))
							status = Status.METHOD;
					} else {
						temp.get(temp.size() - 1).setContent(a.getContent());
					}
				}
			} else if (StringUtils.isCommentBlockEnd(line)) {
				block = Block.NEW;
				status = Status.ATTRIBUTE;
				classe.getAttributes().add(new Attribute(temp));
			}
		}
	}

	/**
	 * Se este método for utilizado para processar uma linha do arquivo, isso
	 * significa que o bloco de comentário que está sendo lido pertence a um
	 * método.
	 * 
	 * @param line
	 *            Linha do arquivo.
	 */
	public void processMethod(String line) {
		if (StringUtils.isCommentBlock(line)) {
			line = StringUtils.clearLine(line);
			Annotation a = StringUtils.getAnnotation(line);
			if (a != null) {
				if (a.getName() != null)
					temp.add(a);
				else {
					temp.get(temp.size() - 1).setContent(a.getContent());
				}
			}
		} else if (StringUtils.isCommentBlockEnd(line)) {
			block = Block.NEW;
			status = Status.ATTRIBUTE;
			classe.getMethods().add(new Method(temp));
		}
	}

	public void processC(String line) {

	}

	public void processD(String line) {

	}

	public void processFinal(String line) {

	}

	public br.uel.gaia.gaiadoc.structure.Class getClasse() {
		return classe;
	}

	public void setClasse(br.uel.gaia.gaiadoc.structure.Class classe) {
		this.classe = classe;
	}
	
	

}
