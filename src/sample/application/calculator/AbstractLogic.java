package sample.application.calculator;

public class AbstractLogic implements FunctionLogic {
	
	@Override
	public void doFunction(CalculatorActivity ca) {
		this.doFunction(ca);
		ca.showNumber(ca.strTemp);
	}
	
	public abstract void doSomething(CalculatorActivity ca);

}
