package br.uel.gaia.gaiadoc.examples;

/**
 * @name Automated Teller Machine
 * @description This use case describes how the Bank Customer uses the ATM to withdraw money to his/her bank account.
 * @writer Humberto Ferreira da Luz Junior
 * @performer Bank Customer.
 * @performer Bank.
 * @specialRequirement The ATM shall dispense cash in multiples of $20.
 * @specialRequirement The maximum individual withdrawal is $500.
 * @specialRequirement The ATM shall keep a log, including date and time, of all complete and incomplete transactions with the Bank.
 * @preCondition There is an active network connection to the Bank.
 * @preCondition The ATM has cash available. 
 * @postCondition The user has received their cash and the internal logs have been updated.
 * @postCondition The logs have been updated accordingly.
 */
public class AutomatedTellerMachine {
	/**
	 * @basicFlow(1)
	 * @description The ATM displays the different alternatives that are available on this unit. In this case the Bank Customer always selects "Withdraw Cash".
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
	 * @description The ATM prompts for an account. See Supporting Requirement SR-yyy for account types that shall be supported. The Bank Customer inserts the required data and its account is validated.
	 */
	private void validateAccount() {

	}
	/**
	 * @basicFlow(3)
	 * @description The ATM prompts for an amount and the Bank Customer enters an amount. The amount is validated (it verifies if there is enough money available).
	 */
	private void checkAmount() {
		try{
			
		} catch(Exception e){
			// Se a quantia requerida estiver incorreta.
			wrongAmount();
		}	
	}
	/**
	 * @basicFlow(4)
	 * @description The Bank Customer is prompted to insert his bank credentials, which are validated.
	 */
	private void validateCredentials() {
		try{
			invalidUser();
		} catch(Exception e){
			// Se a quantia requerida estiver incorreta.
			wrongAmount();
		}	
	}
	/**
	 * @basicFlow(5)
	 * @description Then money is dispensed.
	 */
	private void executeOperation() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @basicFlow(6)
	 * @description The receipt is printed and the use case ends successfully.
	 */
	private void printReceipt() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @alternativeFlow('Wrong Amount', 1)
	 * @description If in step 7 in the basic flow, the Bank Customer enters an amount that can't be 'created' with the kind of in the ATM. See Special Requirements for valid amounts.
	 */
	private void wrongAmount() {
		// TODO Auto-generated method stub
		//redirectToAmount();
	}
	/**
	 * @alternativeFlow('Wrong Amount', 2)
	 * @description The ATM shall display a the message indicating that the amount must be a multiple of the bills on hand, and ask the Bank Customer to reenter the amount. The use case resumes at step 7. 
	 */
	private void redirectToAmount() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @alternativeFlow('Invalid User', 1)
	 * @description If in step 7 in the basic flow, the Bank Customer enters an amount that can't be 'created' with the kind of in the ATM. See Special Requirements for valid amounts.
	 */
	private void invalidUser() {
		// TODO Auto-generated method stub
		
	}
}
