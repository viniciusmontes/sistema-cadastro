package domain.model;

import java.io.Serializable;

import domain.exception.BairroException;

public class Bairro extends Entidade<Integer> implements Cloneable, Serializable {

	private static final long serialVersionUID = -4457410225618819908L;

	private UFVO uf;
	private String nome;
	private Municipio municipio;

	public Bairro() {
		super();
	}

	public Bairro(String nome, Municipio municipio, String uf) {
		super();
		this.nome = nome;
		this.municipio = municipio;
		UFVO.valueOf(uf);
	}
	
	public Bairro(String nome, Municipio m, UFVO uf) {
		super();

		setNome(nome);
		setMunicipio(m);
		setUf(uf);
	}

	public UFVO getUf() {
		return uf;
	}

	public void setUf(UFVO uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public void validarNome() throws BairroException {
		if (nome == null) {
			throw new BairroException("Nome do bairro está nulo!");
		}

		if (nome.trim().isEmpty()) {
			throw new BairroException("Favor, informar nome do bairro!");
		}

		
	}

	public void validarMunicipio() throws BairroException {
		try {
			municipio.validarUf();
			municipio.validarNome();
		} catch (NullPointerException cause) {
			throw new BairroException("Município nulo!");
		} catch (Exception cause) {
			throw new BairroException(cause);
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void finalize() throws Throwable {
		this.nome = null;
		this.municipio = null;
		super.finalize();
	}

	/** {@inheritDoc} */
	@Override
	public Bairro clone() throws CloneNotSupportedException {
		Bairro b = (Bairro) super.clone();

		b.setNome(this.nome);
		b.setMunicipio(this.municipio.clone());

		return b;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Bairro)) {
			return false;
		}
		Bairro other = (Bairro) obj;
		if (municipio == null) {
			if (other.municipio != null) {
				return false;
			}
		} else if (!municipio.equals(other.municipio)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Bairro [nome=%s, municipio=%s, uf=%s]", nome, municipio, uf);
	}

}	