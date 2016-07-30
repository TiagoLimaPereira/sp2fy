package lp2.lab04.sp2fy;
/*115210912 - Tiago Lima Pereira: LAB 4 - Turma 3*/

public class Musica {
	private String titulo;
	private int duracao;
	private String genero;
	
	public Musica(String titulo, int duracao, String genero) throws Exception{
		if(titulo == null || titulo.trim().isEmpty()){
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}
		if(duracao <= 0){
			throw new Exception("Duracao da musica nao pode ser menor ou igual a zero.");
		}

		if(genero == null || genero.trim().isEmpty()){
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;	
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) throws Exception {
		if(titulo == null || titulo.trim().isEmpty()){
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}
		this.titulo = titulo;
	}
	
	public int getDuracao() {
		return this.duracao;
	}
	
	public void setDuracao(int duracao) throws Exception {
		if(duracao <= 0){
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}
		this.duracao = duracao;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public void setGenero(String genero) throws Exception {
		if(genero == null || genero.trim().isEmpty()){
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
		this.genero = genero;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto){
		if(objeto instanceof Musica){
			Musica novaMusica = (Musica) objeto;
			if(novaMusica.getTitulo().equalsIgnoreCase(this.titulo)
					&& novaMusica.getDuracao() == this.duracao){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public String toString(){
		return this.getTitulo() + "(" + this.getGenero() + " - " + this.getDuracao() + " minutos)";
		
	}
}
