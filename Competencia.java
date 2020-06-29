public class Competencia {
	private String competencia;
	private int nivel;
	
	//CONSTRUTOR
	public Competencia(String competencia, int nivel) {
		this.competencia = competencia;
		this.nivel = nivel;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getCompetencia() {
		return this.competencia;
	}

	@Override
	public String toString() {
		return "  ° " +  competencia + ", nível: " + nivel ;
	}

	
	
	
	
}
