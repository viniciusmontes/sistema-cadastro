package domain.model;

import java.io.Serializable;

import domain.exception.LogradouroException;

public class Logradouro extends Entidade<Integer> implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3775971876471514212L;
	private String nome;
	private UFVO uf;
	private Municipio municipio;
	private Bairro bairro;

	public Logradouro() {
		super();
	}

	public Logradouro(String uf, Municipio municipio, Bairro bairro, String nome) {
		UFVO.valueOf(uf);
		this.municipio = municipio;
		this.bairro = bairro;
		this.nome = nome;

	}

	public Logradouro(UFVO uf, Municipio m, Bairro b, String nome) {
		super();
		setUf(uf);
		setMunicipio(m);
		setBairro(b);
		setNome(nome);
	}

	public void validarMunicipio() throws LogradouroException {
		try {
			municipio.validarUf();
			municipio.validarNome();
		} catch (NullPointerException cause) {
			throw new LogradouroException("Município nulo!");
		} catch (Exception cause) {
			throw new LogradouroException(cause);
		}
	}

	public void validarBairro() throws LogradouroException {
		try {
			bairro.validarMunicipio();
			bairro.validarNome();
		} catch (NullPointerException cause) {
			throw new LogradouroException("Bairro nulo!");
		} catch (Exception cause) {
			throw new LogradouroException(cause);
		}
	}

	public void validarNome() throws LogradouroException {
		if (nome == null) {
			throw new LogradouroException("O nome do logradouro está nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new LogradouroException("O nome do logradouro está vazio");
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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logradouro other = (Logradouro) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

}
