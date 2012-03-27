package br.uel.gaia.gaiadoc.examples;

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
	 * @description Ação 1.
	 * @basicFlow(1)
	 */
	public void executeAction() {
	}

	/**
	 * @description Ação 2.
	 * @basicFlow(2)
	 */
	public void executeAction2() {
	}

	/**
	 * @description Alternative flow 1.
	 * @alternativeFlow('alt1',1)
	 */
	public void alternativeFlow() {
	}
	
	/**
	 * @description Alternative flow 2.
	 * @alternativeFlow('alt1',2)
	 */
	public void alternativeFlow2() {
	}
	
	/**
	 * @description Alternative flow 3.
	 * @alternativeFlow('alt2',1)
	 */
	public void alternativeFlow3() {
	}
}

// @extension, @specialRequirement, @preCondition e @postCondition passam a ser
// apenas para o contexto de classe.
// basicFlow(x) possui o parâmetro que indica a ordem do fluxo.
// alternativeFlow('s',y) possui o primeiro parametro que determina o nome do
// fluxo alternativo e y que indica a ordem do fluxo.




// A lista temp guarda todas as anotações do bloco, quando o bloco chega ao fim
// as anotações são lidas e o bloco é classificado como de atributo ou de
// método.

// É de atributo se possui apenas a anotação description.
// É de método se possui a anotação @basicFlow ou @alternativeFlow.

// Primeiro bloco de comentário sempre é o da classe.
// Anotações permitidas: @name, @description, @writer, @performer, @extension,
// @specialRequirement,
// preCondition, postCondition

// A partir do segundo bloco, o status passa a ser o A, e se torna necessário
// analisar o bloco
// inteiro para determinar se seu contexto é de método ou de atributo.
// Atributos podem conter apenas a anotação description (podem ser utilizados
// talvez como um
// dicionário), seu nome é o mesmo do atributo declarado.
// Métodos devem conter sempre, a anotação @basicFlow ou @alternativeFlow, nunca
// as duas simultaneamente
// São também permitidas as tags @performer (no caso do ator participar apenas
// de uma ação específica),
// @extension, @specialRequirement, @preCondition e @postCondition.