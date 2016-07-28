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
			this.musiteca.addAlbum(album);
			return true;
		}catch(Exception e){
			System.out.println("Erro na adicao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean adicionaAlbum(String titulo, String artista, int ano){
		try{
			Album album = new Album(titulo, artista, ano);
			musiteca.addAlbum(album);
			return true;
		}catch(Exception e){
			System.out.println("Erro na adicao de album na musiteca.");
			System.out.println(e.getMessage());
			return false;
		}
	}
}
