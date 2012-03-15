package br.uel.gaia.gaiadoc.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import br.uel.gaia.gaiadoc.pdf.factory.FontFactory;
import br.uel.gaia.gaiadoc.pdf.factory.ParagraphFactory;
import br.uel.gaia.gaiadoc.pdf.factory.PhraseFactory;
import br.uel.gaia.gaiadoc.structure.Class;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFParser {
	private Document document;
	private Class classe;
	private Font NORMAL = FontFactory.getNormal();
	private Font HEADER = FontFactory.getHeader();
	private Font SUB_HEADER = FontFactory.getSubHeader();
	private Font SUB_SUB_HEADER = FontFactory.getSubSubHeader();

	public PDFParser(Class classe) {
		try {
			this.setClasse(classe);
			document = new Document();

			PdfWriter.getInstance(document, new FileOutputStream(classe
					.getProperty("name").get(0) + ".pdf"));

			document.addTitle(classe.getProperty("name").get(0));
			document.addSubject("Especificação de Caso de Uso");
			document.addKeywords("UML, RUP, GaiaDoc");
			document.addCreator("GaiaDoc by Humberto F. da Luz Jr.");
			document.addAuthor(classe.getProperty("writer").get(0));
			document.addHeader("Expires", "0");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void parseDocument() {
		try {

			document.open();
			document.add(ParagraphFactory.getCenterParagraph(
					"Especificação de Caso de Uso: "
							+ classe.getProperty("name").get(0), HEADER));
			includeUseCaseWriter();
			includeUseCaseDescription();
			includeUseCaseExtension();
			includeUseCasePreCondition();
			includeUseCasePostCondition();
			includeUseCaseSpecialRequirements();
			classe.getMethods()

		} catch (DocumentException e) {
			// handle exception
		}
		document.close();

	}

	public void includeUseCaseWriter() throws DocumentException {
		String authors = "";
		for (String author : classe.getProperty("writer")) {
			authors += author + ", ";
		}
		if (!authors.isEmpty()) {
			authors = authors.substring(0, authors.length() - 2) + ".";
			Phrase p = PhraseFactory.getPhrase();
			p.add(new Chunk(
					classe.getProperty("writer").size() > 1 ? "Autores: "
							: "Autor: ", SUB_SUB_HEADER));
			p.add(new Chunk(authors, NORMAL));
			document.add(ParagraphFactory.getLeftParagraph(p));

		}
	}

	public void includeUseCaseDescription() throws DocumentException {
		Phrase p = PhraseFactory.getPhrase();
		p.add(new Chunk("Descrição: ", SUB_SUB_HEADER));
		p.add(new Chunk(classe.getProperty("description").get(0), NORMAL));
		document.add(ParagraphFactory.getLeftParagraph(p));
	}

	private void includeUseCaseExtension() throws DocumentException {
		List<String> extensions = classe.getProperty("extension");
		if (!extensions.isEmpty()) {
			document.add(ParagraphFactory.getLeftParagraph(
					extensions.size() > 1 ? "Extensões" : "Extensão",
					SUB_HEADER));
			for (int i = 0; i < extensions.size(); i++) {
				document.add(ParagraphFactory.getJustifiedParagraph((i + 1)
						+ ". " + extensions.get(i), NORMAL));
			}
		}
	}

	private void includeUseCasePreCondition() throws DocumentException {
		List<String> preConditions = classe.getProperty("preCondition");
		if (!preConditions.isEmpty()) {
			document.add(ParagraphFactory.getLeftParagraph(
					preConditions.size() > 1 ? "Pré-condições" : "Pré-condição",
					SUB_HEADER));
			for (int i = 0; i < preConditions.size(); i++) {
				document.add(ParagraphFactory.getJustifiedParagraph((i + 1)
						+ ". " + preConditions.get(i), NORMAL));
			}
		}
	}
	
	private void includeUseCasePostCondition() throws DocumentException {
		List<String> postConditions = classe.getProperty("postCondition");
		if (!postConditions.isEmpty()) {
			document.add(ParagraphFactory.getLeftParagraph(
					postConditions.size() > 1 ? "Pós-condições" : "Pós-condição",
					SUB_HEADER));
			for (int i = 0; i < postConditions.size(); i++) {
				document.add(ParagraphFactory.getJustifiedParagraph((i + 1)
						+ ". " + postConditions.get(i), NORMAL));
			}
		}
	}

	private void includeUseCaseSpecialRequirements() throws DocumentException {
		List<String> specialRequirements = classe.getProperty("specialRequirement");
		if (!specialRequirements.isEmpty()) {
			document.add(ParagraphFactory.getLeftParagraph(
					specialRequirements.size() > 1 ? "Requisitos Especiais" : "Requisito Especial",
					SUB_HEADER));
			for (int i = 0; i < specialRequirements.size(); i++) {
				document.add(ParagraphFactory.getJustifiedParagraph((i + 1)
						+ ". " + specialRequirements.get(i), NORMAL));
			}
		}
	}
	public Class getClasse() {
		return classe;
	}

	public void setClasse(Class classe) {
		this.classe = classe;
	}
}
