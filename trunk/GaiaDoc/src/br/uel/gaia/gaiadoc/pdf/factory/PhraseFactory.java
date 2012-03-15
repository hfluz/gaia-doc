package br.uel.gaia.gaiadoc.pdf.factory;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;

public class PhraseFactory {
	public static Phrase getPhrase(String phrase, Font font)
	{
		return new Phrase(new Chunk(phrase, font));
	}
	
	public static Phrase getPhrase(Chunk c)
	{
		return new Phrase(c);
	}
	
	public static Phrase getPhrase()
	{
		return new Phrase();
	}
}
