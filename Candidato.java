

public class Candidato extends Pessoa{
	private Competencia[] competencias;
	private double expSalario;
	
	//CONTRUTOR QUE S� RECEBE PARAMETROS PARA SUPERCLASSE
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
		//VERIFICA SE J� EXISTE A COMPET�NCIA NO ARRAY
		for (int i = 0; i < competencias.length; i++) {
			if (competencias[i] != null && competencias[i].getCompetencia().equals(comp))
			{
				//SE EXISTIR, VAI AUMENTAR O N�VEL
				if (competencias[i].getNivel() == 3) //VERIFICA SE J� N�O EST� NO N�VEL ALTO
					return true;
				else
				{
					int AumentaNivel = competencias[i].getNivel() + 1; //RECEBE O NIVEL ATUAL E AUMENTA +1
					competencias[i].setNivel(AumentaNivel); //ATUALIZA O NIVEL;
					return true;
				}
			}
		}
		
		//SE N�O POSSUI NO ARRAY, INSERE ELA NA PRIMEIRA POSI��O LIVRE
		for (int i = 0; i < competencias.length; i++) {
			if (competencias[i] == null)
			{
				competencias[i] = competencia;
				return true;
			}
		}
		
		//CASO HAJA ALGUM ERRO NA ALTERA��O OU INSER��O, RETORNA FALSE
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
				"               \n --------------- COMPET�NCIAS --------------- \n";
		for (int i = 0; i < competencias.length; i++) {
			if(competencias[i] != null)
				s+= competencias[i] + "\n";
		}
		return s +=" ---------------------------------------------- " +
				"\n EXPECTATIVA SALARIAL: R$" + expSalario ;

	
	}
	
	
}
