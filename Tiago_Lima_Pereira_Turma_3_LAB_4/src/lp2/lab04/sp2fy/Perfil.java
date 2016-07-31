package lp2.lab04.sp2fy;
/*115210912 - Tiago Lima Pereira: LAB 4 - Turma 3*/

public class Perfil {
	private String nomeUsuario;
	private Musiteca musiteca;
	
	public Perfil(String nome){
		this.nomeUsuario = nome;
		this.musiteca = new Musiteca();
	}
	
	// Adiciona um album na musiteca
	public boolean adicionaAlbum(Album album){
		try{
			return musiteca.addAlbum(album);
		}catch(Exception e){
			System.out.println("Erro na adicao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// adiciona um album na musiteca com outros parametros
	public boolean adicionaAlbum(String artista, String titulo, int ano){
		try{
			return musiteca.addAlbum(artista, titulo, ano);
		}catch(Exception e){
			System.out.println("Erro na adicao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// remove um album da musiteca
	public boolean removeAlbum(Album album){
		try{
			return musiteca.removeAlbum(album);
		}catch(Exception e){
			System.out.println("Erro na remocao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;	
		}
	}
	
	// remove um album da musiteca pelo titulo
	public boolean removeAlbum(String tituloAlbum){
		try{
			return musiteca.removeAlbum(tituloAlbum);
		}catch(Exception e){
			System.out.println("Erro na remocao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean buscaAlbum(Album album){
		return musiteca.contemAlbum(album);
	}
	
	public boolean buscaAlbum(String tituloAlbum){
		return musiteca.contemAlbum(tituloAlbum);
	}
	
	// adiciona um album favorito da musiteca
	public boolean adicionaFavorito(Album album){
		try{
			return musiteca.addAosFavoritos(album);
		}catch(Exception e){
			System.out.println("Erro na adicao de album favorito na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// adiciona um album favorito da musiteca pelo titulo
	public boolean adicionaFavorito(String tituloAlbum){
		try{
			return musiteca.addAosFavoritos(tituloAlbum);
		}catch(Exception e){
			System.out.println("Erro na adicao de album favorito na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// remove um album favorito
	public boolean removeFavorito(Album album){
		try{
			return musiteca.removeDosFavoritos(album);
		}catch(Exception e){
			System.out.println("Erro na remocao de album favorito na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// remove um album favorito da musiteca pelo nome
	public boolean removeFavorito(String tituloAlbum){
		try{
			return musiteca.removeDosFavoritos(tituloAlbum);
		}catch(Exception e){
			System.out.println("Erro na remocao de album favorito na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public int getQtdAlbuns(){
		return musiteca.getQtdAlbuns();
	}
	
	public int getQtdFavoritos(){
		return musiteca.getQtdFavoritos();
	}
	
	public boolean criaPlaylist(String nomePlaylist){
		try{
			return musiteca.criaPlaylist(nomePlaylist);
		}catch(Exception e){
			System.out.println("Erro na criacao da playlist.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// aidiciona uma faixa de um determinado album na playlist
	// se a playlist nao existe ela eh criada (se o album e a faixa existirem)
	public boolean adicionaNaPlaylist(String nomePlaylist, String nomeAlbum, int faixaAlbum){
		try{
			return musiteca.addNaPlaylist(nomePlaylist, nomeAlbum, faixaAlbum);
		}catch(Exception e){
			System.out.println("Erro na adicao de musica na playlist.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// busca uma determinada musica em uma determinada playlist
	public boolean buscaMusicaPlaylist(String nomePlaylist, String nomeMusica){
		try{
			return musiteca.contemNaPlaylist(nomePlaylist, nomeMusica);
		}catch(Exception e){
			System.out.println("Erro ao buscar musica na playlist.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	// busca playlist pelo nome
	public boolean buscaPlaylist(String nomePlaylist){
		return musiteca.contemPlaylist(nomePlaylist);
	}
	
	public int getTamanhoPlaylist(String nomePlaylist){
		try{
			return musiteca.getTamPlaylist(nomePlaylist);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
		
	}
	
	public String getNomeUsuario(){
		return this.nomeUsuario;
	}
	
	public void setNomeUsuario(String novoNome){
		this.nomeUsuario = novoNome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musiteca == null) ? 0 : musiteca.hashCode());
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		return result;
	}

	// um perfil eh igual ao outro se possuir o mesmo nome e a mesma musiteca (equals da musiteca implementado)
	@Override
	public boolean equals(Object objeto) {
		if(objeto instanceof Perfil){
			Perfil outroPerfil = (Perfil) objeto;
			if(outroPerfil.getNomeUsuario().equalsIgnoreCase(this.nomeUsuario)
					&& outroPerfil.musiteca.equals(this.musiteca)){
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
		String saida = "==>Usuario: " + this.nomeUsuario + FIM_LINHA + musiteca.toString();
		return saida;
	}
}
