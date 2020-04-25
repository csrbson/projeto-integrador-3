package br.com.projetointegrador3.model;

public class Musica {
	
	private String nome;
	private String cantor;
	private String banda;
	private String album;
	private String genero;
	private int ano;
	
	public Musica() {
		// TODO Auto-generated constructor stub
	}

	public Musica(String nome, String cantor, String banda, String album, String genero, int ano) {
		super();
		this.nome = nome;
		this.cantor = cantor;
		this.banda = banda;
		this.album = album;
		this.genero = genero;
		this.ano = ano;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCantor() {
		return cantor;
	}

	public void setCantor(String cantor) {
		this.cantor = cantor;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Musica [nome=" + nome + ", cantor=" + cantor + ", banda=" + banda + ", album=" + album + ", genero="
				+ genero + ", ano=" + ano + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equalsIgnoreCase(other.album))
			return false;
		if (ano != other.ano)
			return false;
		if (banda == null) {
			if (other.banda != null)
				return false;
		} else if (!banda.equalsIgnoreCase(other.banda))
			return false;
		if (cantor == null) {
			if (other.cantor != null)
				return false;
		} else if (!cantor.equalsIgnoreCase(other.cantor))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equalsIgnoreCase(other.genero))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equalsIgnoreCase(other.nome))
			return false;
		return true;
	}

}
