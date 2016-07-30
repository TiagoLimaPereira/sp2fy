package lp2.lab04.sp2fy;

import java.util.ArrayList;

public class Album {
	private ArrayList<Musica> musicas;
	private String artista;
	private String titulo;
	private int ano;
	
	public Album(String artista, String titulo, int ano) throws Exception{
		if(artista == null || artista.trim().isEmpty()){
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}
		if(titulo == null || titulo.trim().isEmpty()){
			throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
		}
		if(ano < 1900){
			throw new Exception("Ano de lancamento do album nao pode ser inferior a 1900.");
		}
		this.musicas = new ArrayList<Musica>();
		this.artista = artista;
		this.titulo = titulo;
		this.ano = ano;
	}
	
	
	public boolean adicionaMusica(Musica musica)throws Exception{
		if(musica == null){
			throw new Exception("Musica nao pode ser nulo.");
		}
		return this.musicas.add(musica);
	}
	
	// Remove musica pelo nome
	public boolean removeMusica(String musicaTitulo)throws Exception {
		if(musicaTitulo == null || musicaTitulo.trim().isEmpty()
				|| this.musicas.size() == 0){
			throw new Exception("Album nao pode ser vazio e titulo da musica pode ser nulo ou vazio.");
			}
		for(int i = 0; i < this.musicas.size(); i = i + 1){
			if(this.musicas.get(i).getTitulo().equalsIgnoreCase(musicaTitulo)){
				this.musicas.remove(i);
				return true;
			}
		}
		return false;	
	}
	
	// Remove musica pela faixa
	public boolean removeMusica(int faixa)throws Exception {
		if(faixa < 1 || faixa > this.musicas.size()){
			throw new Exception("faixa invalida.");
		}
		this.musicas.remove(faixa - 1);
		return true;	
	}
	
	// Busca a existencia da musica pelo nome e retorna boolean
	public boolean contemMusica(String musicaTitulo)throws Exception{
		if(musicaTitulo == null || musicaTitulo.trim().isEmpty()
				|| this.musicas.size() > 0){
			throw new Exception("Album nao pode ser vazio e titulo da musica pode ser nulo ou vazio.");
				}
	for(int i = 0; i < this.musicas.size(); i = i + 1){
		if(this.musicas.get(i).getTitulo().equalsIgnoreCase(musicaTitulo)){
			return true;
			}
		}
		return false;
	}
	
	// Busca musica pelo nome
	public Musica getMusica(String musicaTitulo)throws Exception{
		if(this.contemMusica(musicaTitulo)){
			for(int i = 0; i < this.musicas.size(); i = i + 1){
				if(this.musicas.get(i).getTitulo().equalsIgnoreCase(musicaTitulo)){
					return this.musicas.get(i);
				}
			}
		}
		return null;
	}
	
	// Busca musica pela faixa
	public Musica getMusica(int faixa)throws Exception{
		if(faixa < 1 || faixa > this.musicas.size()){
			throw new Exception("Faixa invalida.");
		}
		return this.musicas.get(faixa - 1);
	}
		
	public int quantidadeFaixas(){
		return this.musicas.size();
	}
	
	public int getDuracaoTotal(){
		int duracaoTotal = 0;
		if(musicas.size() > 0){
			for(int i = 0; i < musicas.size(); i = i + 1){
				duracaoTotal += musicas.get(i).getDuracao();
			}
		}
		return duracaoTotal;
	}
	
	public String getArtista() {
		return this.artista;
	}

	public void setArtista(String artista) throws Exception{
		if(artista == null || artista.trim().isEmpty()){
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}
		this.artista = artista;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		if(titulo == null || titulo.trim().isEmpty()){
			throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
		}
		this.titulo = titulo;
	}

	public int getAno() {
		return this.ano;
	}


	public void setAno(int ano) throws Exception {
		if(ano < 1900){
			throw new Exception("Ano de lancamento do album nao pode ser inferior a 1900.");
		}
		this.ano = ano;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if(objeto instanceof Album){
			Album novoAlbum = (Album) objeto;
			if(novoAlbum.getArtista().equalsIgnoreCase(this.getArtista())
					&& novoAlbum.getTitulo().equalsIgnoreCase(this.getTitulo())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public String toString(){
		final String FIM_LINHA = System.getProperty("line.separator");
		String saida = this.getTitulo() + ", " + this.getArtista() + " (" + this.getAno() + ")" + FIM_LINHA;	
		for(int i = 0; i < this.musicas.size(); i = i + 1){
			saida += (i+1) + ". " + this.musicas.get(i).toString() + FIM_LINHA;
		}
		return saida;
	}
}
