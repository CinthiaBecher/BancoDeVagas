public class Vaga {
	private static int countVaga = 1000;
	protected int id;
	protected double salario;
	protected String descricao; 
	
	public Vaga(String descricao, double salario) {
		//costr�i um ID para que nenhuma vaga possua ID iguais
		Vaga.countVaga++;
		this.id = Vaga.countVaga;
		
		// Informa��es da vaga
		this.salario = salario;
		this.descricao = descricao;
	}

	public int getId() {
		return this.id;
	}

	public double getSalario() {
		return this.salario;
	}
	
	public String getDescricao()
	{
		return this.descricao;
	}
	
	//ALTERA SAL�RIO PARA UM NOVO RECEBIDO
	public void alteraSalario(double novoSalario)
	{
		this.salario = novoSalario;
	}
	
	@Override
	public String toString() {
		return "********************************** \nID: " + this.id +
				"\n" + this.descricao +
				"\n SAL�RIO: " + this.salario; 
	}
	
}

	
