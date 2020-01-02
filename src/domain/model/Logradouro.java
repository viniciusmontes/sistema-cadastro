package domain.model;

import domain.exception.LogradouroException;

public class Logradouro {
	
	private String nome;
	private LogradouroVO logradouro;
	public Logradouro() {
		super();
	}
	
	public Logradouro (String logradouro,String nome) {
		super();
		this.nome = nome;
		LogradouroVO.valueOf(logradouro);
		
	}
	

	public Logradouro (String nome, LogradouroVO logradouro) {
		super();
		setNome(nome);
		setLogradouro(logradouro);
	}	
	
	public void validarLogradouro() throws LogradouroException {
		if (nome == null) {
			throw new LogradouroException("O nome do logradouro está nulo");
		} if (nome.trim().isEmpty()) {
			throw new LogradouroException("O nome do logradouro está vazio");
		}
	}
	
	public void validarBairro() throws LogradouroException {

		
	}
	
	public void validarVO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LogradouroVO getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(LogradouroVO logradouro) {
		this.logradouro = logradouro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
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
		if (logradouro != other.logradouro)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	

}
