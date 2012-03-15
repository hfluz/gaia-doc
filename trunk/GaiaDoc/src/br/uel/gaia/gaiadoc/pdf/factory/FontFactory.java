package br.uel.gaia.gaiadoc.pdf.factory;

import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;

public class FontFactory {
	public static Font getNormal() {
		return new Font(FontFamily.HELVETICA, 12);
	}

	public static Font getHeader() {
		return new Font(FontFamily.HELVETICA, 16, Font.BOLD);
	}

	public static Font getSubHeader() {
		return new Font(FontFamily.HELVETICA, 14, Font.BOLD);
	}

	public static Font getSubSubHeader() {
		return new Font(FontFamily.HELVETICA, 12, Font.BOLD);
	}
}
