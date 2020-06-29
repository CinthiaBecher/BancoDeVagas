public class Pessoa {
	private static int countPessoa = 1000;
	protected int id;
	protected String nome;
	protected Data dataNascimento;
	
	//CONSTRUTOR
	public Pessoa(String nome, Data dataNascimento) {
		//CONSTRÓI UM ID PARA QUE NÃO TENHA NENHUM IGUAL
		Pessoa.countPessoa++;
		this.id = Pessoa.countPessoa;
		
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public Data getDataNascimento() {
		return this.dataNascimento;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + 
				"\nNOME: " + this.nome +
				"\nDATA DE NASCIMENTO: " + this.dataNascimento;
	}
	
	
	
}
