package lp2.lab04.sp2fy;

import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Musiteca {
	HashSet<Album> meusAlbuns;
	HashSet<Album> albunsFavoritos;
	HashMap<String, ArrayList<Musica>> playList;
	
	
	public Musiteca() {
		meusAlbuns = new HashSet<Album>();
		albunsFavoritos = new HashSet<Album>();
		playList = new HashMap<String, ArrayList<Musica>>();
	}
	
	public boolean contemAlbum(Album album) {
		return this.meusAlbuns.contains(album);
	}
	
	public boolean contemAlbum(String nomeAlbum){
		for(Album album : this.meusAlbuns){
			if(album.getTitulo().equalsIgnoreCase(nomeAlbum)){
				return true;
			}
		}
		return false;
	}
	
	public Album getAlbum(String nomeAlbum){
		for(Album album : this.meusAlbuns){
			if (album.getTitulo().equalsIgnoreCase(nomeAlbum)){
				return album;
			}
		}return null;  
	}
	
	public boolean addAlbum(Album novoAlbum) {
		if(novoAlbum == null){
			return false;
		}else{
			return this.meusAlbuns.add(novoAlbum);
			
		}
	}
	
	public boolean removeAlbum(Album album){
		if(album == null && !this.contemAlbum(album)){
			return false;
		}else{
			return this.meusAlbuns.remove(album);
		}
	}
	
	public boolean addAosFavoritos(Album novoAlbum){
		if(novoAlbum == null){
			return false;
		}else{
			return this.albunsFavoritos.add(novoAlbum);
			
		}
	}
	
	public boolean removeDosFavoritos(Album album){
		if(album == null && !this.albunsFavoritos.contains(album)){
			return false;
		}else{
			return this.albunsFavoritos.remove(album);
		}
	}
	
	public int getQtdFavoritos(){
		return this.albunsFavoritos.size();
	}
	// Verifica, pelo nome, se uma playlist existe
	public boolean contemPlaylist(String nomePlaylist){
		if(nomePlaylist == null || nomePlaylist.trim().isEmpty()
			|| this.playList.size() == 0){
				return false;
			}else{
				return this.playList.containsKey(nomePlaylist);
			}
	}
	
	public int getTamPlaylist(String nomePlaylist)throws Exception{
		if(!contemPlaylist(nomePlaylist)){
			throw new Exception("Playlist inexistente.");
		}
		return this.playList.get(nomePlaylist).size();
	}
	// verifica se uma musica existe numa determinada playlist
	public boolean contemNaPlaylist(String nomePlaylist, String nomeMusica){
		if(!contemPlaylist(nomePlaylist)){
			return false;
		}else{
			ArrayList<Musica> playlist = this.playList.get(nomePlaylist);
			for(int i = 0; i < playlist.size(); i = i +1){
				if(playlist.get(i).getTitulo().equalsIgnoreCase(nomeMusica)){
					return true;
				}
			}
			return false;
		}
	}
	
	public boolean criaPlaylist(String nomePlaylist){
		if(nomePlaylist.trim().isEmpty() || contemPlaylist(nomePlaylist)){
			return false;
		}else{
			ArrayList<Musica> playlist = new ArrayList<Musica>();
			this.playList.put(nomePlaylist, playlist);
			return true;
		}
	}
	
	public boolean addNaPlaylist(String nomePlaylist, String nomeAlbum, int faixaAlbum)throws Exception{
		if(!contemAlbum(nomeAlbum)){
			throw new Exception("Album nao pertence ao Perfil especificado.");
		}else{
			Album album = this.getAlbum(nomeAlbum);
			Musica musica = album.getMusica(faixaAlbum);
			if(this.contemPlaylist(nomePlaylist)){
				
				return this.playList.get(nomePlaylist).add(musica);
			}else{
				criaPlaylist(nomePlaylist);
				return this.playList.get(nomePlaylist).add(musica);
			}	
		}
	}
}
