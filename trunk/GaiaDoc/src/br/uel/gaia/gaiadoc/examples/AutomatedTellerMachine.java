package br.uel.gaia.gaiadoc.examples;

/**
 * @name Caixa Eletrônico
 * @description Este caso de uso descreve como o cliente do banco usa o caixa eletrônico para sacar dinheiro de sua conta bancária.
 * @writer Humberto Ferreira da Luz Junior
 * @performer Cliente do banco.
 * @performer Banco.
 * @specialRequirement O caixa eletrônico disponibiliza dinheiro em múltiplos de 20 reais.
 * @specialRequirement A quantidade máxima de retirada é de 500 reais.
 * @specialRequirement O caixa eletrônico deve manter um log, incluindo data e hora, de todas transações completas e incompletas com o banco.
 * @specialRequirement O usuário deve estar autenticado para efetuar a transação.
 * @preCondition Deve haver uma conexão de rede ativa com o banco.
 * @preCondition O caixa eletrônico deve ter dinheiro disponível. 
 * @postCondition O usuário deve ter recebido seu dinheiro e os logs internos devem ter sido atualizados.
 * @postCondition Os logs devem ter sido atualizados corretamente.
 */
public class AutomatedTellerMachine {
	/**
	 * @basicFlow(1)
	 * @description O caixa eletrônico exibe as diferentes opções disponíveis nessa unidade. Nesse caso, o cliente sempre seleciona "Sacar Dinheiro".
	 */
	public void withdrawCash(){
		validateAccount();
		checkAmount();
		validateCredentials();
		executeOperation();
		printReceipt();
	}
	/**
	 * @basicFlow(2)
	 * @description O caixa eletrônico solicita o número da conta bancária. O cliente insere os dados requeridos e sua conta é validada.
	 */
	private void validateAccount() {
		// Implementação do método.
	}
	/**
	 * @basicFlow(3)
	 * @description O caixa eletrônico solicita uma quantia e o cliente a digita. A quantia é validada (verifica se há dinheiro suficiente disponível).
	 */
	private void checkAmount() {
		try{
			// Implementação do método.
		} catch(Exception e){
			// Se a quantia requerida estiver incorreta.
			wrongAmount();
		}	
	}
	/**
	 * @basicFlow(4)
	 * @description É solicitado ao cliente que ele insira suas credenciais bancárias, que são validadas.
	 */
	private void validateCredentials() {
		try{
			// Implementação do método.
		} catch(Exception e){
			// Se a quantia requerida estiver incorreta.
			invalidUser();
		}	
	}
	/**
	 * @basicFlow(5)
	 * @description O dinheiro é liberado.
	 */
	private void executeOperation() {
		// Implementação do método.
	}
	/**
	 * @basicFlow(6)
	 * @description O recibo é impresso e o caso de uso se encerra com sucesso.
	 */
	private void printReceipt() {
		// Implementação do método.
	}
	/**
	 * @alternativeFlow('Quantia Errada', 1)
	 * @description Se no passo 3 no fluxo básico, o cliente entra uma quantia que não pode ser processada pelo caixa eletrônico, veja os requisitos especiais para quantias válidas.
	 */
	private void wrongAmount() {
		// Implementação do método.
		redirectToAmount();
	}
	/**
	 * @alternativeFlow('Quantia Errada', 2)
	 * @description O caixa eletrônico deve redirecionar o cliente a uma mensagem que indica que o valor deve ser múltiplo de um determinado valor e menor que o limite diário, e solicitar ao cliente uma nova quantia. O caso de uso continua no passo 3 do fluxo básico. 
	 */
	private void redirectToAmount() {
		// Implementação do método.
	}
	/**
	 * @alternativeFlow('Usuário Inválido', 1)
	 * @description Se no passo 4 no fluxo básico, o cliente entra com as credenciais bancárias incorretas, veja os requisitos especiais.
	 */
	private void invalidUser() {
		// Implementação do método.
		redirectToCredentials();
	}
	
	/**
	 * @alternativeFlow('Usuário Inválido', 2)
	 * @description O caixa eletrônico deve redirecionar o cliente a uma mensagem que indica que as credenciais não foram aceitas. É solicitado novamente que o cliente digite suas credenciais e o número de tentativas permitidas do dia é decrementado. O caso de uso continua no passo 4 do fluxo básico.
	 */
	private void redirectToCredentials() {
		// Implementação do método.
	}
}
