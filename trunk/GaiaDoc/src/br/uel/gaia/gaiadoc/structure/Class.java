package br.uel.gaia.gaiadoc.structure;

import java.util.List;

import br.uel.gaia.gaiadoc.Annotation;

public class Class implements Component{
	private List<Annotation> annotations;
	private List<Method> methods;
	private List<Attribute> attributes;
}
