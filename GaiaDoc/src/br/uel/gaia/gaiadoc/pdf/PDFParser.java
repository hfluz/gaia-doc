package br.uel.gaia.gaiadoc.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import br.uel.gaia.gaiadoc.structure.Class;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFParser {
	private Document document;
	private Class classe;
	Font helveticaBold16 = new Font(FontFamily.HELVETICA, 16, Font.BOLD);
	Font helvetica16 = new Font(FontFamily.HELVETICA, 16);
	Font helveticaBold12 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
	Font helvetica12 = new Font(FontFamily.HELVETICA, 12);

	public PDFParser(Class classe) {
		try {
			this.setClasse(classe);
			document = new Document();
			
			PdfWriter.getInstance(document,
					new FileOutputStream(classe.getProperty("name").get(0) + ".pdf"));

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
			document.add(new Chunk("Especificação de Caso de Uso: ", helveticaBold16));
			document.add(new Chunk(classe.getProperty("name").get(0),helvetica16));
			document.add(new Paragraph("Descrição: "
					+ classe.getProperty("description").get(0)));
		} catch (Exception e) {
			// handle exception
		}
		document.close();

	}

	public Class getClasse() {
		return classe;
	}

	public void setClasse(Class classe) {
		this.classe = classe;
	}
}
