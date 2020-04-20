public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if(salarioBase < 1039.00){
			return Math.round(0.0);
		}
		double salarioSemInss = this.calcularInss(salarioBase);
		double salarioLiquido = this.calcularIrrf(salarioSemInss);

		return Math.round(salarioLiquido);
	}

	private double calcularIrrf(double valorReferencia){
		double taxaIrrf = defineTaxaIrrf(valorReferencia);
		return valorReferencia * (1 - taxaIrrf);
	}

	private double defineTaxaIrrf(double valorReferencia){
		double taxa = 0.0;
		if(valorReferencia <= 3000.00){
			taxa = 0.0;
		} else if((valorReferencia > 3000.00) && (valorReferencia <= 6000.00)){
			taxa = 0.075;
		} else{
			taxa = 0.15;
		}
		return taxa;
	}
	
	
	private double calcularInss(double salarioBase) {
		double taxaDesconto = this.defineTaxaDesconto(salarioBase);
		return salarioBase * (1-taxaDesconto);
	}

	private double defineTaxaDesconto(double salarioBase){
		double desconto = 0.0;
		if(salarioBase <= 1500.00){
			desconto = 0.08;
		} else if((salarioBase > 1500.00) && (salarioBase <= 4000.00)){
			desconto = 0.09;
		} else {
			desconto = 0.11;
		}
		return desconto;
	}

}
