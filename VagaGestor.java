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
		//VERIFICA SE JÁ EXISTE A COMPETÊNCIA NO ARRAY
		for (int i = 0; i < reqMetodologia.length; i++) {
			if (reqMetodologia[i] != null && reqMetodologia[i].getCompetencia().equals(comp))
			{
				//SE EXISTIR, VAI AUMENTAR O NÍVEL
				if (reqMetodologia[i].getNivel() == 3) //VERIFICA SE JÁ NÃO ESTÁ NO NÍVEL ALTO
					return true;
				else
				{
					int AumentaNivel = reqMetodologia[i].getNivel() + 1; //RECEBE O NIVEL ATUAL E AUMENTA +1
					reqMetodologia[i].setNivel(AumentaNivel); //ATUALIZA O NIVEL;
					return true;
				}
			}
		}
				
		//SE NÃO POSSUI NO ARRAY, INSERE ELA NA PRIMEIRA POSIÇÃO LIVRE
		for (int i = 0; i < reqMetodologia.length; i++) {
			if (reqMetodologia[i] == null)
			{
				reqMetodologia[i] = metodologia;
				return true;
			}
		}
		//CASO HAJA ALGUM ERRO NA ALTERAÇÃO OU INSERÇÃO, RETORNA FALSE
		return false;
	}


	public Competencia[] getReqMetodologia() {
		return this.reqMetodologia;
	}
	
	@Override
	public String toString() {
		String s =  "_______________________________________________ \n                  VAGA GESTOR\n ID: " +
				getId() + "\tSALARIO: " + getSalario() + "\n------------------ DESCRIÇÃO ------------------\n" +
				getDescricao() + "\n---------------- COMPETÊNCIAS -----------------\n *REQUISITOS DE METODOLOGIA*\n";
		for (int i = 0; i < reqMetodologia.length; i++) {
			if (reqMetodologia[i] != null)
				s += reqMetodologia[i] + "\n";
		}
		return s;
		
		


				
	}
}
	

	