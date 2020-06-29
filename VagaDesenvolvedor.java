public class VagaDesenvolvedor extends Vaga{
	private Competencia[] reqLinguagens;
	private Competencia[] reqBancoDeDados;
	
	//CONSTRUTOR PARA INICIALIZAR A SUPERCLASSE
	public VagaDesenvolvedor(String descricao, double salario) {
		super(descricao, salario);
		this.reqLinguagens = new Competencia[100];
		this.reqBancoDeDados = new Competencia[100];
	}

	//CONSTRUTOR QUE RECEBE OS ARRAYS DE COMPETENCIA
	public VagaDesenvolvedor(String descricao, double salario, Competencia[] reqLinguagens,
			Competencia[] reqBancoDeDados) {
		super(descricao, salario);
		this.reqLinguagens = reqLinguagens;
		this.reqBancoDeDados = reqBancoDeDados;
	}
	
	public boolean alteraReqLinguagens(Competencia linguagem)
	{
		String comp = linguagem.getCompetencia();
		//VERIFICA SE JÁ EXISTE A COMPETÊNCIA NO ARRAY
		for (int i = 0; i < reqLinguagens.length; i++) {
			if (reqLinguagens[i] != null && reqLinguagens[i].getCompetencia().equals(comp))
			{
				//SE EXISTIR, VAI AUMENTAR O NÍVEL
				if (reqLinguagens[i].getNivel() == 3) //VERIFICA SE JÁ NÃO ESTÁ NO NÍVEL ALTO
					return true;
				else
				{
					int AumentaNivel = reqLinguagens[i].getNivel() + 1; //RECEBE O NIVEL ATUAL E AUMENTA +1
					reqLinguagens[i].setNivel(AumentaNivel); //ATUALIZA O NIVEL;
					return true;
				}
			}
		}
		
		//SE NÃO POSSUI NO ARRAY, INSERE ELA NA PRIMEIRA POSIÇÃO LIVRE
		for (int i = 0; i < reqLinguagens.length; i++) {
			if (reqLinguagens[i] == null)
			{
				reqLinguagens[i] = linguagem;
				return true;
			}
		}
		//CASO HAJA ALGUM ERRO NA ALTERAÇÃO OU INSERÇÃO, RETORNA FALSE
		return false;
		
	}
	
	public Competencia[] getReqLinguagens()
	{
		return this.reqLinguagens;
	}
	
	public boolean alteraReqBancoDeDados(Competencia BancoDeDados)
	{
		String comp = BancoDeDados.getCompetencia();
		//VERIFICA SE JÁ EXISTE A COMPETÊNCIA NO ARRAY
		for (int i = 0; i < reqBancoDeDados.length; i++) {
			if (reqBancoDeDados[i] != null && reqBancoDeDados[i].getCompetencia().equals(comp))
			{
				//SE EXISTIR, VAI AUMENTAR O NÍVEL
				if (reqBancoDeDados[i].getNivel() == 3) //VERIFICA SE JÁ NÃO ESTÁ NO NÍVEL ALTO
					return true;
				else
				{
					int AumentaNivel = reqBancoDeDados[i].getNivel() + 1; //RECEBE O NIVEL ATUAL E AUMENTA +1
					reqBancoDeDados[i].setNivel(AumentaNivel); //ATUALIZA O NIVEL;
					return true;
				}
			}
		}
		
		//SE NÃO POSSUI NO ARRAY, INSERE ELA NA PRIMEIRA POSIÇÃO LIVRE
		for (int i = 0; i < reqBancoDeDados.length; i++) {
					if (reqBancoDeDados[i] == null)
					{
						reqBancoDeDados[i] = BancoDeDados;
						return true;
					}
		}
		
		//CASO HAJA ALGUM ERRO NA ALTERAÇÃO OU INSERÇÃO, RETORNA FALSE
		return false;
	}
	
	public Competencia[] getReqBandoDeDados()
	{
		return this.reqBancoDeDados;
	}

	@Override
	public String toString() {
		String s =  "_______________________________________________ \n\t      VAGA DESENVOLVEDOR\t    \n ID: " +
				getId() + "\tSALARIO: " + getSalario() + "\n------------------ DESCRIÇÃO ------------------\n" +
				getDescricao() + "\n---------------- COMPETÊNCIAS -----------------\n *REQUISITOS DE BANCO DE DADOS*\n";
		for (int i = 0; i < reqBancoDeDados.length; i++) {
			if (reqBancoDeDados[i] != null)
				s += reqBancoDeDados[i] + "\n";
		}
		s+= "\n *REQUISITOS DE LINGUAGENS*\n";
		for (int i = 0; i < reqLinguagens.length; i++) {
			if (reqLinguagens[i] != null)
				s += reqLinguagens[i] + "\n";
		}
		return s;
	}	
	
	
}
