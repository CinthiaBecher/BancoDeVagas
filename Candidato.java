

public class Candidato extends Pessoa{
	private Competencia[] competencias;
	private double expSalario;
	
	//CONTRUTOR QUE SÓ RECEBE PARAMETROS PARA SUPERCLASSE
	public Candidato(String nome, Data dataNascimento) {
		super(nome, dataNascimento);
		this.competencias = new Competencia[100];
		this.expSalario = 0;
	}

	//CONTRUTOR QUE RECEBE COMPETENCIAS E SALARIO
	public Candidato(String nome, Data dataNascimento, Competencia[] competencias, double expSalario) {
		super(nome, dataNascimento);
		this.competencias = competencias;
		this.expSalario = expSalario;
	}
	
	public boolean alteraCompetencias(Competencia competencia)
	{
		String comp = competencia.getCompetencia();
		//VERIFICA SE JÁ EXISTE A COMPETÊNCIA NO ARRAY
		for (int i = 0; i < competencias.length; i++) {
			if (competencias[i] != null && competencias[i].getCompetencia().equals(comp))
			{
				//SE EXISTIR, VAI AUMENTAR O NÍVEL
				if (competencias[i].getNivel() == 3) //VERIFICA SE JÁ NÃO ESTÁ NO NÍVEL ALTO
					return true;
				else
				{
					int AumentaNivel = competencias[i].getNivel() + 1; //RECEBE O NIVEL ATUAL E AUMENTA +1
					competencias[i].setNivel(AumentaNivel); //ATUALIZA O NIVEL;
					return true;
				}
			}
		}
		
		//SE NÃO POSSUI NO ARRAY, INSERE ELA NA PRIMEIRA POSIÇÃO LIVRE
		for (int i = 0; i < competencias.length; i++) {
			if (competencias[i] == null)
			{
				competencias[i] = competencia;
				return true;
			}
		}
		
		//CASO HAJA ALGUM ERRO NA ALTERAÇÃO OU INSERÇÃO, RETORNA FALSE
		return false;
	}
	
	
	public Competencia[] getCompetencias()
	{
		return this.competencias;
	}

	public double getExpSalario() {
		return this.expSalario;
	}

	public void setExpSalario(double expSalario) {
		this.expSalario = expSalario;
		
	}

	@Override
	public String toString() {
		String s = " ______________________________________________\n"  +
				"\t        CANDIDATO ID: " + getId() + 
				"\t\t\n NOME: " + getNome() +
				"                        \n DATA DE NASCIMENTO: " + getDataNascimento() + 
				"               \n --------------- COMPETÊNCIAS --------------- \n";
		for (int i = 0; i < competencias.length; i++) {
			if(competencias[i] != null)
				s+= competencias[i] + "\n";
		}
		return s +=" ---------------------------------------------- " +
				"\n EXPECTATIVA SALARIAL: R$" + expSalario ;

	
	}
	
	
}
