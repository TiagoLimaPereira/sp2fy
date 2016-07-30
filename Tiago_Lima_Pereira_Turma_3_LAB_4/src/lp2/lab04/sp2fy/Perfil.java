package lp2.lab04.sp2fy;

public class Perfil {
	private String nomeUsuario;
	private Musiteca musiteca;
	
	public Perfil(String nome){
		this.nomeUsuario = nome;
		this.musiteca = new Musiteca();
	}
	
	public boolean adicionaAlbum(Album album){
		try{
			return musiteca.addAlbum(album);
		}catch(Exception e){
			System.out.println("Erro na adicao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean adicionaAlbum(String titulo, String artista, int ano){
		try{
			Album album = new Album(titulo, artista, ano);
			return musiteca.addAlbum(album);
		}catch(Exception e){
			System.out.println("Erro na adicao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean removeAlbum(Album album){
		try{
			return musiteca.removeAlbum(album);
		}catch(Exception e){
			System.out.println("Erro na remocao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;	
		}
	}
	
	public boolean removeAlbum(String tituloAlbum){
		try{
			Album album = musiteca.getAlbum(tituloAlbum);
			return musiteca.removeAlbum(album);
		}catch(Exception e){
			System.out.println("Erro na remocao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean adicionaFavorito(Album album){
		try{
			return musiteca.addAosFavoritos(album);
		}catch(Exception e){
			System.out.println("Erro na adicao de album favorito na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean adicionaFavorito(String tituloAlbum){
		try{
			Album album = musiteca.getAlbum(tituloAlbum);
			return musiteca.addAosFavoritos(album);
		}catch(Exception e){
			System.out.println("Erro na adicao de album favorito na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean removeFavorito(Album album){
		try{
			return musiteca.removeDosFavoritos(album);
		}catch(Exception e){
			System.out.println("Erro na remocao de album favorito na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean removeFavorito(String tituloAlbum){
		try{
			Album album = musiteca.getAlbum(tituloAlbum);
			return musiteca.removeDosFavoritos(album);
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
	
	public boolean adicionaNaPlaylist(String nomePlaylist, String nomeAlbum, int faixaAlbum){
		try{
			return musiteca.addNaPlaylist(nomePlaylist, nomeAlbum, faixaAlbum);
		}catch(Exception e){
			System.out.println("Erro na adicao de musica na playlist.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String getNomeUsuario(){
		return this.nomeUsuario;
	}
	
	public void setNomeUsuario(String novoNome){
		this.nomeUsuario = novoNome;
	}
	
	
}
