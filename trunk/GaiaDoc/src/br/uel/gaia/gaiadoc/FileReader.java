package br.uel.gaia.gaiadoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import br.uel.gaia.gaiadoc.structure.Component;

/**
 * Classe responsável por ler o arquivo e convertê-lo em uma lista de Components, que posteriormente será convertida em PDF.
 * @author humberto
 *
 */
public class FileReader {
	private Path file;
	private Status status;

	/**
	 * Estados do leitor.
	 * @author humberto
	 *
	 */
	public enum Status {
		INITIAL, A, B, C, D, FINAL
	}

	public FileReader(Path path) {

		if (Files.exists(path) && Files.isRegularFile(path))
			file = path;
		status = Status.INITIAL;
		// TODO disparar exceção.
	}

	public List<Component> read() {
		Charset charset = Charset.forName("UTF8");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				switch (status) {
				case INITIAL:
					processInitial(line);
					break;
				case A:
					processA(line);
					break;
				case B:
					processB(line);
					break;
				case C:
					processC(line);
					break;
				case D:
					processD(line);
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
		}
		return null;
	}

	/**
	 * Bloco inicial, que descreve as informações do caso de uso, representado pela classe encontrada.
	 * @param line Linha do arquivo.
	 */
	public void processInitial(String line) {

		//if()
	}

	public void processA(String line) {

	}

	public void processB(String line) {

	}

	public void processC(String line) {

	}

	public void processD(String line) {

	}

	public void processFinal(String line) {

	}
}
