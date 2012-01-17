package br.uel.gaia.gaiadoc.structure;

import java.util.List;

import br.uel.gaia.gaiadoc.Annotation;

public class Method implements Component{
	private List<Annotation> annotations;
	private String invokedBy;
	private String invokes;
}
