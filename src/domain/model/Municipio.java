package domain.model;

import java.io.Serializable;

import domain.exception.MunicipioException;

public class Municipio extends Entidade<Integer> implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private UFVO uf;

	public Municipio() {
		super();
	}

	public Municipio(String nome, String uf) {
		this(nome, UFVO.valueOf(uf));
	}

	public Municipio(String nome, UFVO uf) {
		super();

		setNome(nome);
		setUf(uf);
	}

	public void validarNome() throws MunicipioException {
		if (nome == null) {
			throw new NullPointerException("Nome do município nulo!");
		}

		if (nome.trim().isEmpty()) {
			throw new MunicipioException(
					"Por favor, informe o nome do município!");
		}
	}

	public void validarUf() throws MunicipioException {
		if (uf == null) {
			throw new MunicipioException("Uf do municipio está nula!");
		}
		if (uf.isNotSelecionado()) {
			throw new MunicipioException("Por favor, selecione uma Uf!");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UFVO getUf() {
		return uf;
	}

	public void setUf(UFVO uf) {
		this.uf = uf;
	}

	@Override
	public Municipio clone() throws CloneNotSupportedException {
		Municipio m = (Municipio) super.clone();

		m.setNome(this.nome);
		m.setUf(this.uf);

		return m;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Municipio)) {
			return false;
		}
		Municipio other = (Municipio) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (uf == null) {
			if (other.uf != null) {
				return false;
			}
		} else if (!uf.equals(other.uf)) {
			return false;
		}
		return true;
	}

	@Override
	protected void finalize() throws Throwable {
		this.nome = null;
		this.uf = null;
		super.finalize();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return nome;
	}
}
