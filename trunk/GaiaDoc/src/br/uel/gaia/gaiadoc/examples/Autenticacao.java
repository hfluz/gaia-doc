package br.uel.gaia.gaiadoc.examples;

/**
 * @name Manter Autenticação
 * @description Este caso descreve o procedimento para autenticação dos usuários no portal do estudante, para mudança de senha e o respectivo método de encriptação.
 * @writer Humberto Ferreira da Luz Junior
 * @performer Aluno
 * @extension Este caso de uso não possui extensões.
 * @specialRequirement Para a mudança de senha o aluno deve estar autenticado.
 * @preCondition Para a mudança de senha o aluno deve estar autenticado.
 * @preCondition Para a requisição de uma nova senha o aluno não pode estar autenticado.
 * @postCondition Este caso de uso não possui pós-condições.
 * 
 * @author humberto
 * 
 */
public class Autenticacao {//TODO Preciso verificar se os outros atributos do método estão setados e pensar como exibi-los no documento.
	/**
	 * @description O aluno preenche seu nome de usuário e senha e clica no botão Login.
	 * @basicFlow(1)
	 */
	public void autenticar() {
	}

	/**
	 * @description Ação 2.
	 * @basicFlow(2)
	 */
	public void verificarCredenciais() {
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
