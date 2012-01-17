package br.uel.gaia.gaiadoc;

import java.nio.file.Path;
import java.util.List;

public class Main {
	public static void main(String[] args)
	{
		FileSystemReader systemReader = new FileSystemReader();
		systemReader.start();
		for(Path path : systemReader.getClasses())
		{
			if(path.endsWith("Example.java"))
			{
				FileReader fileReader = new FileReader(path);
				fileReader.read();
			}
		}
	}
}
