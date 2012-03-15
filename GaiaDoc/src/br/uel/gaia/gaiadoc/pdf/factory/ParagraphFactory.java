package br.uel.gaia.gaiadoc.pdf.factory;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

public class ParagraphFactory {
	public static Paragraph getLeftParagraph(String phrase, Font font)
	{
		Paragraph p = new Paragraph(new Chunk(phrase, font));
		p.setAlignment(Element.ALIGN_LEFT);
		return p;
	}
	
	public static Paragraph getCenterParagraph(String phrase, Font font)
	{
		Paragraph p = new Paragraph(new Chunk(phrase, font));
		p.setAlignment(Element.ALIGN_CENTER);
		return p;
	}
	
	public static Paragraph getJustifiedParagraph(String phrase, Font font)
	{
		Paragraph p = new Paragraph(new Chunk(phrase, font));
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		return p;
	}
	
	public static Paragraph getRightParagraph(String phrase, Font font)
	{
		Paragraph p = new Paragraph(new Chunk(phrase, font));
		p.setAlignment(Element.ALIGN_RIGHT);
		return p;
	}
	
	public static Paragraph getLeftParagraph(Phrase phrase)
	{
		Paragraph p = new Paragraph(phrase);
		p.setAlignment(Element.ALIGN_LEFT);
		return p;
	}
	
	public static Paragraph getCenterParagraph(Phrase phrase)
	{
		Paragraph p = new Paragraph(phrase);
		p.setAlignment(Element.ALIGN_CENTER);
		return p;
	}
	
	public static Paragraph getJustifiedParagraph(Phrase phrase)
	{
		Paragraph p = new Paragraph(phrase);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		return p;
	}
	
	public static Paragraph getRightParagraph(Phrase phrase)
	{
		Paragraph p = new Paragraph(phrase);
		p.setAlignment(Element.ALIGN_RIGHT);
		return p;
	}
}
