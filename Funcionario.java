public class Funcionario extends Pessoa {
	private String cargo;
	private double salario;
	
	//CONSTRUTOR
	public Funcionario(String nome, Data dataNascimento, String cargo, double salario) {
		super(nome, dataNascimento);
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public String getCargo() {
		return this.cargo;
	}

	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "-----------------------------------------------\n"  +
				" FUNCIONÁRIO ID: " + getId() + 
				"\n NOME: " + getNome() +
				"\n DATA DE NASCIMENTO: " + getDataNascimento() + 
				"\n CARGO: " + this.cargo + 
				"\n SALÁRIO: " + this.salario;
	}
	

}
