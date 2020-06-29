public class Principal {
	public static void main(String[] args) {
		//STRING PARA INFORMAR OS NÍVEIS DE COMPETÊNCIA
		String NiveisCompetencia = " OBS.: LEGENDA\n 1-NÍVEL BAIXO\t2-NÍVEL MÉDIO\t3-NÍVEL ALTO"; 
		
		//CRIANDO VAGAS DE DESENVOLVEDOR ================================================================
		//VAGA 1
		String descricao = "Executa a manutenção dos sistemas, \n"
				+ "fazendo eventuais correções necessárias,\n"
				+ " visando atender às necessidades dos usuários.";
		double salario = 1500.00;
		Competencia cLinguagem1 = new Competencia("C#", 2);
		Competencia cLinguagem2 = new Competencia("JavaScript", 1);
		Competencia[] reqLinguagens = {cLinguagem1, cLinguagem2};
		Competencia cBanco1 = new Competencia("Modelagem de dados", 1);
		Competencia cBanco2 = new Competencia("Oracle", 2);
		Competencia[] reqBancoDeDados = {cBanco1,cBanco2};
		VagaDesenvolvedor vagaD1 = new VagaDesenvolvedor(descricao, salario, reqLinguagens, reqBancoDeDados);
	
		// VAGA 2 
		String descricao2 = "Habilidade em: Experiência em UI e \n"
				+ "UX (webdesign). Configuração de \n"
				+ "servidor Linux (Apache e PHP).\n"
				+ "Programação e testes.";
		double salario2 = 1800.00;
		VagaDesenvolvedor vagaD2 = new VagaDesenvolvedor(descricao2, salario2);
		Competencia cLinguagem5 = new Competencia("Python", 1);
		Competencia cLinguagem6 = new Competencia("Java", 3);
		vagaD2.alteraReqLinguagens(cLinguagem5); //ADICIONA NO ARRAY
		vagaD2.alteraReqLinguagens(cLinguagem6);
		Competencia cBanco3 = new Competencia("MySQL", 1);
		vagaD2.alteraReqBancoDeDados(cBanco3);
		
		//AUMENTA NÍVEL DA COMPETENCIA SE POSSIVEL
		Competencia cLinguagem7 = new Competencia("Python", 1);
		vagaD2.alteraReqLinguagens(cLinguagem7);
		Competencia cLinguagem8 = new Competencia("Java", 3);
		vagaD2.alteraReqLinguagens(cLinguagem8);
		
		
		
		//CRIANDO VAGAS DE GESTOR =======================================================================
		//VAGA 1  
		String descricao3 = "Atuará como líder da área de \n"
				+ "desenvolvimento para o planejamento \n"
				+ "e execução dos projetos no sistema de \n"
				+ "gestão ERP.";
		double salario3 = 5000.00;
		Competencia cMetodologia1 = new Competencia("ITIL", 2);
		VagaGestor vagaG1 = new VagaGestor(descricao3, salario3);
	
		vagaG1.alteraReqMetodologia(cMetodologia1);
		
		//AUMENTA NÍVEL DA COMPETENCIA
		Competencia cMetodologia2 = new Competencia("ITIL", 3);
		vagaG1.alteraReqMetodologia(cMetodologia2);
		
		//MUDA O SALÁRIO DA VAGA DE GESTOR E IMPRIME ===================================================
		vagaG1.alteraSalario(4500.00);
		
		
		
		//CRIANDO CANDIDATOS ===========================================================================
		//candidato 1
		String nome1 = "Cinthia Becher";
		Data d1 = new Data(12, 01, 2001);
		Candidato c1 = new Candidato(nome1, d1);
		
		Competencia comp1Candidato1 = new Competencia("Java", 1);
		Competencia comp2Candidato1 = new Competencia("Python", 2);
		
		c1.alteraCompetencias(comp1Candidato1);
		c1.alteraCompetencias(comp2Candidato1);
		
		c1.setExpSalario(1000.00);
		
		//candidato 2
		String nome2 = "Jõao Silva";
		Data d2 = new Data(25, 05, 1995);
		Competencia comp1Candidato2 = new Competencia("Java", 3);
		Competencia comp2Candidato2 = new Competencia("ITIL", 3);
		Competencia[] compCandidato2 = {comp1Candidato2, comp2Candidato2};
		Candidato c2 = new Candidato(nome2, d2, compCandidato2, 4000 );
		
		//candidato 3
		String nome3 = "Maria Santos";
		Data d3 = new Data(18, 04, 1998);
		Candidato c3 = new Candidato(nome3, d3);
				
		Competencia comp1Candidato3 = new Competencia("MySQL", 1);
		Competencia comp2Candidato3 = new Competencia("JavaScript", 2);
				
		c3.alteraCompetencias(comp1Candidato3);
		c3.alteraCompetencias(comp2Candidato3);
		
		c3.setExpSalario(2000);
		
		//aumenta nível da competencia
		Competencia comp3Candidato3 = new Competencia("MySQL", 1);
		c3.alteraCompetencias(comp3Candidato3);

		//candidato 4
		String nome4 = "Joana Ferreira";
		Data d4 = new Data(8, 9, 1997);
		Competencia comp1Candidato4 = new Competencia("Oracle", 2);
		Competencia comp2Candidato4 = new Competencia("Modelagem de dados", 2);
		Competencia comp3Candidato4 = new Competencia("C#", 2);
		Competencia comp4Candidato4 = new Competencia("Java", 2);
		Competencia[] compCandidato4 = {comp1Candidato4, comp2Candidato4, comp3Candidato4, comp4Candidato4};
		Candidato c4 = new Candidato(nome4, d4, compCandidato4, 2000);
				
		
		//candidato 5
		String nome5 = "Rafaela Oliveira";
		Data d5 = new Data(19, 12, 2000);
		Candidato c5 = new Candidato(nome5, d5);
						
		Competencia comp1Candidato5 = new Competencia("C++", 3);
		c5.alteraCompetencias(comp1Candidato5);
		
		c5.setExpSalario(2500);
		
		
		
		//CRIA BANCO DE VAGAS ============================================================================
		BancoDeVagas bc = new BancoDeVagas();
		
		//ADICIONA CANDIDATO E IMPRIME LISTA  ============================================================
		bc.adicionaCandidato(c1);
		bc.adicionaCandidato(c2);
		bc.adicionaCandidato(c3);
		bc.adicionaCandidato(c4);
		bc.adicionaCandidato(c5);
		
		System.out.println(NiveisCompetencia); //imprime a legenda dos níveis
		bc.listaCandidatos();
		
		//tenta adicionar um candidato já cadastrado;
		bc.adicionaCandidato(c2);
		
		//ADICIONA VAGAS E IMPRIME LISTA  ===============================================================
		bc.adicionaVaga(vagaG1);
		bc.adicionaVaga(vagaD2);
		bc.adicionaVaga(vagaD1);
		System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		bc.listaVagas();
		
		
		//LISTA AS VAGAS COM BASE EM FILTROS  ==========================================================
		System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		bc.listaVagasFiltro(1000); 
		bc.listaVagasFiltro(5000); 
		System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		Competencia competenciaFiltro1 = new Competencia("ITIL", 3);
		bc.listaVagasFiltro(competenciaFiltro1);
		
		System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		Competencia competenciaFiltro2 = new Competencia("Java", 3);
		bc.listaVagasFiltro(competenciaFiltro2);
		
		System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		Competencia competenciaFiltro3 = new Competencia("PHP", 1);
		bc.listaVagasFiltro(competenciaFiltro3);

		
		

		//LISTA AS VAGAS PARA CANDIDATOS  ==============================================================
		System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");	
		bc.listaVagasParaCandidato(1001);
			
		// LISTA CANDIDATOS PARA VAGA  =================================================================
			System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			bc.listaCandidatosParaVaga(1003);
		
		
		
		//CONTRATA CANDIDATOS E IMPRIME A LISTA DE FUNCIONÁRIOS  =======================================
			System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			bc.contratarCandidato(1003, 1002);
			bc.contratarCandidato(1001, 1004);
			bc.listaFuncionarios();
		
			
			
		//TESTA OS EXERICICIOS EXTRAS 
		
			System.out.println("\n\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"
					+ "\n--------- TESTANDO EXERCICIOS EXTRAS ---------");

			Vaga vagaAletatoria = geraVagaAleatoria();
			System.out.println(vagaAletatoria);
			
			Candidato candAleatorio = geraCandidatoAleatorio();
			candAleatorio.alteraCompetencias(geraCompetenciaAleatoria());
			System.out.println(candAleatorio);

		
		
	}
	
	public static Competencia geraCompetenciaAleatoria()
	{
		String[] competencias = {"Python", "Java", "PHP", "Swift", "C#", "MySQL","JavaScript"};
		int numAleatorio = (int) (Math.random() * 6 ); //GERA UM Nº ALEATÓRIO PARA SER A POSICAO DO ARRAY
		int nivel = (int) (Math.random() * 3 +1);
		
		Competencia CompetenciaAleatoria = new Competencia(competencias[numAleatorio],nivel);
		return CompetenciaAleatoria;
	}
	
	public static Vaga geraVagaAleatoria()
	{
		Vaga v = null;
		int TipoDeVaga = (int) (Math.random() * 2 +1);
		if (TipoDeVaga == 1)
		{
			String descricao = "Desenvolvimento e Manutenção em Sistemas"; //DESCRIÇÃO PADRAO
			double salario = (int) (Math.random() * 4000 + 900); //OBTER UM SALÁRIO MAIOR QUE R$ 900
			v = new VagaDesenvolvedor(descricao, salario);
		}
		else 
		{
			String descricao = "Gerenciar projetos e operações de serviços de TI"; //DESCRIÇÃO PADRAO
			double salario = (int)  (Math.random() * 6000 + 2000);//OBTER UM SALÁRIO MAIOR QUE R$ 2000
			v = new VagaGestor(descricao, salario);
		}
		return v;
	}
	
	public static Candidato geraCandidatoAleatorio()
	{
		String[] nome =  {"Jõao", "Marcos", "Amanda", "Roberto", "Catarina", "Alex","Carlos"};
		int numAleatorio = (int) (Math.random() * 6 ); //GERA UM Nº ALEATÓRIO PARA SER A POSICAO DO ARRAY
		
		int mes = (int) (Math.random() * 12 + 1 );
		int dia;
		// CONFERE OS MESES PARA NÃO CRIAR DIAS INEXISTENTES
		if (mes == 1 && mes == 3 && mes == 5 && mes == 7 && mes == 8 && mes == 10 && mes == 12)
			dia = (int) (Math.random() * 31 + 1);
		else if (mes == 2)
			dia = (int) (Math.random() * 27 + 1);
		else
			dia = (int) (Math.random() * 31 + 1);
		
		int[] anos = {1990,1991, 1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002};
		int numAleatorioAno = (int) (Math.random() * 13 ); //GERA UM Nº ALEATÓRIO PARA SER A POSICAO DO ARRAY

		Data data = new Data(dia, mes, anos[numAleatorioAno]);
		Candidato c = new Candidato(nome[numAleatorio], data);
		
		double salario = (int) (Math.random() * 4000 + 900); //OBTER UM SALÁRIO MAIOR QUE R$ 900
		c.setExpSalario(salario);
		
		return c;
	}
	
	
}

