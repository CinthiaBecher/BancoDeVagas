public class BancoDeVagas {
	private Vaga[] vagas;
	private Candidato[] candidatos;
	private Funcionario[] funcionarios;
	
	public BancoDeVagas() {
		this.vagas = new Vaga[100];
		this.candidatos = new Candidato[100];
		this.funcionarios  = new Funcionario[100];
	}
	
	public boolean adicionaVaga(Vaga novaVaga)
	{
		//VERIFICA SE ELA JÁ ESTÁ NO ARRAY
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] == novaVaga)
			{
				System.out.println("ERRO! VAGA JÁ CADASTRADA");
				return false;
			}
		}
		
		//SE ELA NÃO ESTIVER NO ARRAY, INSERIR NA PRIMEIRA POSIÇÃO NULA DO ARRAY
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] == null)
			{
				vagas[i] = novaVaga;
				return true;
			}
		}
		//CASO TEN333HA OCORRIDO ALGUM ERRO, RETORNA FALSE
		return false;
	}
	
	public boolean adicionaCandidato(Candidato novoCandidato)
	{
		//VERIFICA SE ELA JÁ ESTÁ NO ARRAY
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] == novoCandidato)
			{
				System.out.println("ERRO! CANDIDATO JÁ CADASTRADO");
				return false;
			}
		}
				
		//SE ELA NÃO ESTIVER NO ARRAY, INSERIR NA PRIMEIRA POSIÇÃO NULA DO ARRAY
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] == null)
			{
				candidatos[i] = novoCandidato;
				return true;
			}
		}
		//CASO TENHA OCORRIDO ALGUM ERRO, RETORNA FALSE
		return false;
	}
	
	public boolean contratarCandidato(int idVaga ,int idCandidato )
	{
		boolean deuCerto = true; //CASO DE ALGO ERRADO, A FUNCAO RETORNA FALSE
		
		Funcionario novoFuncionario; //CRIA NOVO FUNCIONÁRIO
		String nome = null;
		Data dataNascimento = null;
		String cargo = null;
		double salario = 0;
		
		
		//PROCURA O CANDIDATO NO ARRAY CORRESPONDENTE;
		for (int i = 0; i < candidatos.length; i++) {
			if ( candidatos[i] != null && candidatos[i].getId() == idCandidato)
			{
				//SALVA OS ATRIBUTOS CORRESPONDENTES PARA A CRIAÇÃO DO FUNCIONÁRIO
				nome = candidatos[i].getNome();
				dataNascimento = candidatos[i].getDataNascimento();
				
				//REMOVE DA LISTA DE CANDIDADOS
				candidatos[i] = null;
				
				break;
			}
			else 
			{
				deuCerto = false; 
			}
			
		}
		
		//PROCURA A VAGA NO ARRAY CORRESPONDENTE
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null && vagas[i].getId() == idVaga)
			{
				//SALVA OS ATRIBUTOS CORRESPONDENTES PARA A CRIAÇÃO DO FUNCIONÁRIO
				salario = vagas[i].getSalario();
				//VERIFICA A INSTANCIA PARA INFORMAR O CARGO
				if (vagas[i] instanceof VagaDesenvolvedor)
					cargo = "Desenvolvedor";
				else if (vagas[i] instanceof VagaGestor)
					cargo = "Gestor";
				
				
				//REMOVE DA LISTA DE VAGAS
				vagas[i] = null;
				
				break;
			}
			else 
			{
				deuCerto = false; 
			}
		}
			
		
		
		//INICIALIZA O NOVO FUNCIONÁRIO
		novoFuncionario = new Funcionario(nome, dataNascimento, cargo, salario);
		
		//ADICIONA O FUNCIONÁRIO NA LISTA CORRESPONDENTE
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i] == null)
			{
				funcionarios[i] = novoFuncionario;
				break;
			}
			else 
			{
				deuCerto = false; 
			}
		}
		
		return deuCerto;
	}
	
	
	public void listaVagas()
	{
		System.out.println("===============================================");
		System.out.println("\t       VAGAS DISPONÍVEIS\t       ");
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null) {
				//VERIFICA SE É UMA INSTANCIA DE VAGAGESTOR
				if (vagas[i] instanceof VagaGestor)
				{
					VagaGestor vg = (VagaGestor) vagas[i];
					System.out.println(vg);
				}
				//VERIFICA SE É UMA INSTANCIA DE VAGADESENVOLVEDOR
				else if (vagas[i] instanceof VagaDesenvolvedor)
				{
					VagaDesenvolvedor vd = (VagaDesenvolvedor) vagas[i];
					System.out.println(vd);
				}
			}
		}
		System.out.println("===============================================");
	}
	
	public void listaCandidatos()
	{
		System.out.println(" ==============================================");
		System.out.println("\t      CANDIDATOS CADASTRADOS\t       ");
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] != null)
				System.out.println(candidatos[i]);
		}
		System.out.println("===============================================");

	}
	
	
	public void listaFuncionarios()
	{
		System.out.println("===============================================");
		System.out.println("\t      FUNCIONÁRIOS CADASTRADOS");
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i] != null)
				System.out.println(funcionarios[i]);
		}
		System.out.println("===============================================");

	}
	
	
	public void listaVagasFiltro(double expSalarial)
	{	
		int vagasDisponíveis = 0;
		System.out.println(" ==============================================");
		System.out.println("|VAGAS COM SALÁRIO MAIORES OU IGUAIS À R$" + expSalarial + "|");

		
		//PROCURA VAGAS REFERENTE AO SALÁRIO
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null && vagas[i].getSalario() >= expSalarial)
			{
				//SE CUMPRIR CONDIÇÃO DO SALARIO, ADICIONA NO ARRAY DE VAGAS
					System.out.println(vagas[i]);
					vagasDisponíveis++;
			}
		}
		if (vagasDisponíveis == 0)
		{  
			System.out.println("|----------------------------------------------|");
			System.out.println("|      \t*SEM RESULTADOS PARA SUA BUSCA*\t       |");
			System.out.println(" ==============================================");
		}
		
	}

	
	public void listaVagasFiltro(Competencia competenciaFiltro)
	{
		int vagasDisponíveis = 0;
		System.out.println(" ==============================================");
		System.out.println("|          VAGAS RELACIONADAS  À " + competenciaFiltro.getCompetencia() + "\t\t|");
  
		
		//PROCURA VAGAS REFERENTE A COMPETENCIA
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null)
			{
				// VERIFICA A INSTANCIA
				if (vagas[i] instanceof VagaGestor)
				{
					VagaGestor vagaG = (VagaGestor) vagas[i];
					for (Competencia compGestor : vagaG.getReqMetodologia())
					{
						if (compGestor != null && compGestor.getCompetencia().equals(competenciaFiltro.getCompetencia()))
						{
							System.out.println(vagas[i]);
							vagasDisponíveis++;
						}
					}
					
				}
				else if (vagas[i] instanceof VagaDesenvolvedor)
				{
					VagaDesenvolvedor vagaD = (VagaDesenvolvedor) vagas[i];
					for (Competencia compDev : vagaD.getReqLinguagens())
					{
						if (compDev != null && compDev.getCompetencia().equals(competenciaFiltro.getCompetencia()))
						{
							System.out.println(vagas[i]);
							vagasDisponíveis++;
						}
					}
					for (Competencia compDev : vagaD.getReqBandoDeDados())
					{
						if (compDev != null && compDev.getCompetencia().equals(competenciaFiltro.getCompetencia()))
						{
							System.out.println(vagas[i]);
							vagasDisponíveis++;
						}
					}
					
				}
			}
		}	
		if (vagasDisponíveis == 0)
		{  
			System.out.println("|----------------------------------------------|");
			System.out.println("|      \t*SEM RESULTADOS PARA SUA BUSCA*\t       |");
			System.out.println(" ==============================================");
		}
		
	}
	
	
	public void listaVagasParaCandidato(int idCandidato )
	{
		System.out.println("|=============================================|");
		System.out.println("|      \tVAGAS PARA CANDIDATO Nº" + idCandidato + "\t      |");
	 
		//ENCONTRA O CADIDATO 
				Candidato c = null;
				for (int i = 0; i < candidatos.length; i++) {
					if (candidatos[i] != null && candidatos[i].getId() == idCandidato)
					{
						c = candidatos[i];
					}
				}
			
				
				//PROCURA VAGAS DISPONIVEIS CONFORME AS COMPETENCIAS
				Vaga[] vagasDisponiveis = new Vaga[100];
				int quantVagas = 0;
				for (int i = 0; i < vagas.length; i++) {
					if (vagas[i] != null)
					{
						//verifica a instancia
						if (vagas[i] instanceof VagaGestor)
						{
							VagaGestor vagaG = (VagaGestor) vagas[i];
							for (Competencia compGestor : vagaG.getReqMetodologia())
							{
								for (Competencia comCand : c.getCompetencias())
								{
									//verifica se o canditato possui a competencia
									if (compGestor != null && comCand != null && compGestor.getCompetencia().equals(comCand.getCompetencia()))
									{
										System.out.println(vagas[i]);
										vagasDisponiveis[quantVagas] = vagas[i];
										quantVagas++;
										break;
									}
								}
								break;
							}
						}
						else if (vagas[i] instanceof VagaDesenvolvedor)
						{
							VagaDesenvolvedor vagaD = (VagaDesenvolvedor) vagas[i];
							for (Competencia compDev : vagaD.getReqLinguagens())
							{
								for (Competencia comCand : c.getCompetencias())
								{
									if (compDev != null && comCand != null && compDev.getCompetencia().equals(comCand.getCompetencia()))
									{
										System.out.println(vagas[i]);
										vagasDisponiveis[quantVagas] = vagas[i];
										quantVagas++;
										break;
									}
								}
								
							}
							for (Competencia compeDev : vagaD.getReqBandoDeDados())
							{
								for (Competencia comCand : c.getCompetencias())
								{
									if (compeDev != null && comCand != null && compeDev.getCompetencia().equals(comCand.getCompetencia()))
									{
										System.out.println(vagas[i]);
										vagasDisponiveis[quantVagas] = vagas[i];
										quantVagas++;
										break;
									}
								}
								
							}
						}
					}
				}
		}
		
		
	
	
	public void listaCandidatosParaVaga(int idVaga)
	{
		System.out.println("|=============================================|");
		System.out.println("|      \tCANDIDATOS PARA VAGA Nº" + idVaga + "\t      |");
	 
		//ENCONTRA A VAGA -- ok
				Vaga v = null;
				for (int i = 0; i < vagas.length; i++) {
					if (vagas[i] != null && vagas[i].getId() == idVaga)
					{
						v = vagas[i];
					}
				}
				
				
				
		//PROCURA CANDIDATOS DISPONIVEIS CONFORME AS COMPETENCIAS
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] != null)
			{
				Candidato c = candidatos[i];
				//para cada competencia do candidato verifica se a vaga possui a competencia 
				for (Competencia comCand : c.getCompetencias())
				{
					if (v instanceof VagaGestor)
					{
						VagaGestor vagaG = (VagaGestor) v;
						for (Competencia compGestor : vagaG.getReqMetodologia())
						{
							if (compGestor != null && comCand != null && compGestor.getCompetencia().equals(comCand.getCompetencia()))
							{
								System.out.println(candidatos[i]);
								
							}
						}
					}
					else if (v instanceof VagaDesenvolvedor)
					{
						VagaDesenvolvedor vagaD = (VagaDesenvolvedor) v;
						//procura pelos requesitos de Banco de dados
						for (Competencia compDev : vagaD.getReqBandoDeDados())
						{
							if (compDev != null && comCand != null 
									&& compDev.getCompetencia().equals(comCand.getCompetencia())
									&& v.getSalario() > c.getExpSalario())
							{
								System.out.println(candidatos[i]);
							}
						}
						//procura pelos requesitos de linguagem
						for (Competencia compDev : vagaD.getReqLinguagens())
						{
							if (compDev != null && comCand != null && compDev.getCompetencia().equals(comCand.getCompetencia()))
							{
								System.out.println(candidatos[i]);
							}
						}
					}
					
				}
			}
		}
						
						
						
	}
	
	
		
		
		
		
		
		
	
	
	
	
	
	
	
	
}
	
	
