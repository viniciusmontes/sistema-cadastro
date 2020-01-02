package domain.model;

import java.util.Date;

import domain.exception.ClienteException;

public class Cliente extends Entidade<Integer> {

	private String nome;
	private String sobrenome;
	private EstadoCivilVO estadoCivil;
	private Date dataNascimento;
	private SexoVO sexo;
	private Municipio municipio;

	public Cliente(String nome, String sobrenome, String estadoCivil, Date dataNascimento, String sexo) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		EstadoCivilVO.valueOf(estadoCivil);
		this.dataNascimento = dataNascimento;
		SexoVO.valueOf(sexo);
	}

	public Cliente() {
		super();
		setNome(nome);
		setSobrenome(sobrenome);
		setEstadoCivil(estadoCivil);
		setSexo(sexo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivilVO getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilVO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public SexoVO getSexo() {
		return sexo;
	}

	public void setSexo(SexoVO sexo) {
		this.sexo = sexo;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public void validarNome() throws ClienteException {
		if (nome == null) {
			throw new NullPointerException("Nome do cliente está nulo!");
		}

		if (nome.trim().isEmpty()) {
			throw new ClienteException("Por favor, informe o nome do cliente!");
		}

	}

	public void validarSobrenome() throws ClienteException {
		if (sobrenome == null) {
			throw new NullPointerException("O sobrenome do cliente está nulo!");
		}

		if (sobrenome.trim().isEmpty()) {
			throw new ClienteException("Por favor, informe o sobrenome do Cliente!");
		}

	}

	public void validarDataNascimento() throws ClienteException {
		if (dataNascimento == null) {
			throw new NullPointerException("O sobrenome do cliente está nulo!");
		}
	}

	public void validarEstadoCivil() throws ClienteException {
		if (estadoCivil == null) {
			throw new ClienteException("O estado civil está nulo!");
		}
		if (estadoCivil.isNotSelecionado()) {
			throw new ClienteException("Por favor, selecione um estado civil!");
		}
	}

	public void validarSexo() throws ClienteException {
		if (sexo == null) {
			throw new ClienteException("O sexo está nulo!");
		}
		if (sexo.isNotSelecionado()) {
			throw new ClienteException("Por favor, selecione um sexo!");
		}
	}

	public void validarMunicipio() throws ClienteException {
		try {
			municipio.validarUf();
			municipio.validarNome();
		} catch (NullPointerException cause) {
			throw new ClienteException("Município nulo!");
		} catch (Exception cause) {
			throw new ClienteException(cause);
		}
	}

	public void validarEndereco() throws ClienteException {

	}

	public void validarContatos() throws ClienteException {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
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
		Cliente other = (Cliente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome + sobrenome + dataNascimento + estadoCivil + sexo;
	}

}
