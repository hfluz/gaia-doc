package br.uel.gaia.gaiadoc.exception;

public class InvalidAnnotationException extends RuntimeException {

	private static final long serialVersionUID = -6700861378713179641L;

	public InvalidAnnotationException()
	{
		this("Foi encontrada uma anotação gaiadoc no contexto incorreto.");
	}
	
	public InvalidAnnotationException(String name)
	{
		super("A anotação gaiadoc " + name + " no contexto incorreto.");
	}
}
