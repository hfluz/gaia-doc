package br.uel.gaia.gaiadoc;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por ler o sistema de arquivos a partir do caminho (PATH)
 * fornecido e procurar arquivos com a extensão .java, delegando o trabalho de
 * analisar e converter o conteúdo do arquivo em PDF para a classe FileReader.
 * 
 * @author humberto
 * 
 */
public class FileSystemReader {

	private List<Path> classes;

	public FileSystemReader() {
		classes = new ArrayList<Path>();
	}

	public void start() {
		Path dir = Paths.get("/home/humberto/workspace/mestrado/GaiaDoc");
		try {
			Files.walkFileTree(dir, new GaiaDocVisitor());
			for (Path path : classes) {
				if (path.getFileName().endsWith("AutomatedTellerMachine.java"))
					System.out.println(path.getFileName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Path> getClasses() {
		return classes;
	}

	class GaiaDocVisitor extends SimpleFileVisitor<Path> {
		private PathMatcher matcher;

		public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
			matcher = FileSystems.getDefault().getPathMatcher(
					"glob:*AutomatedTellerMachine.java");
			if (attr.isRegularFile() && matcher.matches(file.getFileName())
					&& !classes.contains(file)) {
				classes.add(file);
				// System.out.format("%s encontrado\n", file.getFileName());
			}
			return CONTINUE;
		}
	}
}
