public class VagaGestor extends Vaga {
	private Competencia[] reqMetodologia;

	//CONSTRUTOR PARA INICIALIZAR A SUPERCLASSE
	public VagaGestor(String descricao, double salario) {
		super(descricao, salario);
		this.reqMetodologia = new Competencia[100];
	}
	//CONSTRUTOR QUE RECEBE AS COMPETENCIAS
	public VagaGestor(String descricao, double salario, Competencia[] reqMetodologia) {
		super(descricao, salario);
		this.reqMetodologia = reqMetodologia;
	}

	public boolean alteraReqMetodologia (Competencia metodologia)
	{
		String comp = metodologia.getCompetencia();
		//VERIFICA SE J� EXISTE A COMPET�NCIA NO ARRAY
		for (int i = 0; i < reqMetodologia.length; i++) {
			if (reqMetodologia[i] != null && reqMetodologia[i].getCompetencia().equals(comp))
			{
				//SE EXISTIR, VAI AUMENTAR O N�VEL
				if (reqMetodologia[i].getNivel() == 3) //VERIFICA SE J� N�O EST� NO N�VEL ALTO
					return true;
				else
				{
					int AumentaNivel = reqMetodologia[i].getNivel() + 1; //RECEBE O NIVEL ATUAL E AUMENTA +1
					reqMetodologia[i].setNivel(AumentaNivel); //ATUALIZA O NIVEL;
					return true;
				}
			}
		}
				
		//SE N�O POSSUI NO ARRAY, INSERE ELA NA PRIMEIRA POSI��O LIVRE
		for (int i = 0; i < reqMetodologia.length; i++) {
			if (reqMetodologia[i] == null)
			{
				reqMetodologia[i] = metodologia;
				return true;
			}
		}
		//CASO HAJA ALGUM ERRO NA ALTERA��O OU INSER��O, RETORNA FALSE
		return false;
	}


	public Competencia[] getReqMetodologia() {
		return this.reqMetodologia;
	}
	
	@Override
	public String toString() {
		String s =  "_______________________________________________ \n                  VAGA GESTOR\n ID: " +
				getId() + "\tSALARIO: " + getSalario() + "\n------------------ DESCRI��O ------------------\n" +
				getDescricao() + "\n---------------- COMPET�NCIAS -----------------\n *REQUISITOS DE METODOLOGIA*\n";
		for (int i = 0; i < reqMetodologia.length; i++) {
			if (reqMetodologia[i] != null)
				s += reqMetodologia[i] + "\n";
		}
		return s;
		
		


				
	}
}
	

	