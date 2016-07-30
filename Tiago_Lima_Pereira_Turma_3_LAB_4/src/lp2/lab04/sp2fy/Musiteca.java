package lp2.lab04.sp2fy;
/*115210912 - Tiago Lima Pereira: LAB 4 - Turma 3*/

import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Musiteca {
	private HashSet<Album> meusAlbuns;
	private HashSet<Album> albunsFavoritos;
	private HashMap<String, ArrayList<Musica>> playList;
	
	public Musiteca() {
		meusAlbuns = new HashSet<Album>();
		albunsFavoritos = new HashSet<Album>();
		playList = new HashMap<String, ArrayList<Musica>>();
	}
	
	// Busca album na musiteca
	public boolean contemAlbum(Album album) {
		return this.meusAlbuns.contains(album);
	}
	
	// Busca album na musiteca pelo nome
	public boolean contemAlbum(String nomeAlbum){
		for(Album album : this.meusAlbuns){
			if(album.getTitulo().equalsIgnoreCase(nomeAlbum)){
				return true;
			}
		}
		return false;
	}
	
	// Busca album pelo nome e o retorna
	public Album getAlbum(String nomeAlbum){
		for(Album album : this.meusAlbuns){
			if (album.getTitulo().equalsIgnoreCase(nomeAlbum)){
				return album;
			}
		}return null;  
	}
	
	// Adiciona album
	public boolean addAlbum(Album novoAlbum) throws Exception{
		if(novoAlbum == null){
			return false;
		}else{
			return this.meusAlbuns.add(novoAlbum);	
		}
	}
	
	// Cria album e adiciona
	public boolean addAlbum(String artista, String titulo, int ano)throws Exception{
		Album novoAlbum = new Album(artista, titulo, ano);
		return this.meusAlbuns.add(novoAlbum);
	}
	
	// remove album
	public boolean removeAlbum(Album album)throws Exception{
		if(album == null || !this.contemAlbum(album)){
			throw new Exception("Album nao pode ser nulo ou inexistente na musiteca.");
		}
		return this.meusAlbuns.remove(album);
	}
	
	// remove album pelo titulo
	public boolean removeAlbum(String tituloAlbum)throws Exception{
		Album album = this.getAlbum(tituloAlbum);
		return this.removeAlbum(album);
	}
	
	// adiciona album aos favoritos
	public boolean addAosFavoritos(Album novoAlbum)throws Exception{
		if(novoAlbum == null || !this.contemAlbum(novoAlbum)){
			throw new Exception("Album nao pode ser nulo ou inexistente na musiteca.");
		}
		return this.albunsFavoritos.add(novoAlbum);	
	}
	
	// cria album e adiciona aos favoritos
	public boolean addAosFavoritos(String tituloAlbum)throws Exception{
		Album album = this.getAlbum(tituloAlbum);
		return this.addAosFavoritos(album);
	}
	
	// remove album dos favoritos
	public boolean removeDosFavoritos(Album album)throws Exception{
		if(album == null || !this.albunsFavoritos.contains(album)){
			throw new Exception("Album nao pode ser nulo ou inexistente nos favoritos.");
		}
			return this.albunsFavoritos.remove(album);
	}
	
	// remove album dos favoritos pelo titulo
	public boolean removeDosFavoritos(String tituloAlbum)throws Exception{
		Album album = this.getAlbum(tituloAlbum);
		return this.removeDosFavoritos(album);
	}
	
	public int getQtdAlbuns(){
		return this.meusAlbuns.size();
	}
	
	public int getQtdFavoritos(){
		return this.albunsFavoritos.size();
	}
	
	// =====METODOS DA PLAYLIST====
	// Verifica, pelo nome, se uma playlist existe
	public boolean contemPlaylist(String nomePlaylist){
		return this.playList.containsKey(nomePlaylist);	
	}
	
	// retorna o tamanho de uma determinada playlist
	public int getTamPlaylist(String nomePlaylist)throws Exception{
		if(!contemPlaylist(nomePlaylist)){
			throw new Exception("Playlist inexistente.");
		}
		return this.playList.size();
	}
	
	// verifica se uma musica existe numa determinada playlist
	public boolean contemNaPlaylist(String nomePlaylist, String nomeMusica)throws Exception{
		if(!contemPlaylist(nomePlaylist)){
			throw new Exception("Playlist inexistente.");
		}
		ArrayList<Musica> playlist = this.playList.get(nomePlaylist);
		for(int i = 0; i < playlist.size(); i = i +1){
			if(playlist.get(i).getTitulo().equalsIgnoreCase(nomeMusica)){
				return true;
			}
		}
		return false;
	}
	
	// cria uma nova playlist
	public boolean criaPlaylist(String nomePlaylist)throws Exception{
		if(nomePlaylist.trim().isEmpty() || this.contemPlaylist(nomePlaylist)){
			return false;
		}else{
			ArrayList<Musica> playlist = new ArrayList<Musica>();
			this.playList.put(nomePlaylist, playlist);
			return true;
		}
	}
	
	// busca um album, uma playlist e adiciona uma determinada faixa do album na playlist
	// caso a playlist nao exista, eh criada uma nova playlist
	public boolean addNaPlaylist(String nomePlaylist, String nomeAlbum, int faixaAlbum)throws Exception{
		if(!contemAlbum(nomeAlbum)){
			throw new Exception("Album nao pertence ao Perfil especificado.");
		}
		Album album = this.getAlbum(nomeAlbum);
		Musica musica = album.getMusica(faixaAlbum);
		if(this.contemPlaylist(nomePlaylist)){	
			return this.playList.get(nomePlaylist).add(musica);
		}else{
			criaPlaylist(nomePlaylist);
			return this.playList.get(nomePlaylist).add(musica);
		}	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albunsFavoritos == null) ? 0 : albunsFavoritos.hashCode());
		result = prime * result + ((meusAlbuns == null) ? 0 : meusAlbuns.hashCode());
		result = prime * result + ((playList == null) ? 0 : playList.hashCode());
		return result;
	}
	
	// Outra musiteca eh igual se a quantidade de albuns, de favoritos e de playlist forem iguais
	@Override
	public boolean equals(Object objeto) {
		if(objeto instanceof Musiteca){
			Musiteca outraMusiteca = (Musiteca) objeto;
			if(outraMusiteca.meusAlbuns.size() == this.meusAlbuns.size() 
					&& outraMusiteca.albunsFavoritos.size() == this.albunsFavoritos.size()
					&& outraMusiteca.playList.size() == this.playList.size()){
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
		String saida = "===Albuns da musiteca===" + FIM_LINHA;
		saida += "Titulo, Artista, Ano" + FIM_LINHA;
		for(Album album : this.meusAlbuns){
			saida += "- " + album.getTitulo() + ", " + album.getArtista() + " (" + album.getAno() + ")" + FIM_LINHA;
		}
		saida += FIM_LINHA;
		saida += "===Albuns favoritos da musiteca===" + FIM_LINHA;
		saida += "Titulo, Arista, Ano" + FIM_LINHA;
		for(Album album : this.albunsFavoritos){
			saida += "- " + album.getTitulo() + ", " + album.getArtista() + " (" + album.getAno() + ")" + FIM_LINHA;
		}
		saida += FIM_LINHA;
		saida += "===Playlists da musiteca===" + FIM_LINHA;
		for(String nomePlaylist : this.playList.keySet()){
			saida += "- " + nomePlaylist + FIM_LINHA;
		}
		return saida;	
	}
}
