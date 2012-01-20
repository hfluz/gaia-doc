package br.uel.gaia.gaiadoc;

/**
 * @name Manter Exemplo
 * @description Classe que demonstra como é escrita a documentação com gaiadoc.
 * @writer Humberto Ferreira da Luz Junior
 * @performer Fulano
 * @extension Este caso de uso não possui extensões.
 * @specialRequirement Este caso de uso não possui requisitos especiais.
 * @preCondition Este caso de uso não possui pré-condições.
 * @postCondition Este caso de uso não possui pós-condições.
 * 
 * @author humberto
 *
 */
public class Example {
	/**
	 * @description Atributo utilizado para...
	 */
	private String atributo;
	/**
	 * @performer Ciclano
	 * @basicFlow
	 * 
	 */
	public void executeAction(){}
}

//Primeiro bloco de comentário sempre é o da classe.
//Anotações permitidas: @name, @description, @writer, @performer, @extension, @specialRequirement,
//preCondition, postCondition

//A partir do segundo bloco, o status passa a ser o A, e se torna necessário analisar o bloco
//inteiro para determinar se seu contexto é de método ou de atributo.
//Atributos podem conter apenas a anotação description (podem ser utilizados talvez como um
//dicionário), seu nome é o mesmo do atributo declarado.
//Métodos devem conter sempre, a anotação @basicFlow ou @alternativeFlow, nunca as duas simultaneamente
//São também permitidas as tags @performer (no caso do ator participar apenas de uma ação específica),
//@extension, @specialRequirement, @preCondition e @postCondition.