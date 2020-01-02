package domain.model;

public enum EnderecoVO {
	
	ESCOLHA,
	COMERCIAL,
	RESIDENCIAL;
	
	public boolean isSelecionado() {
		return !ESCOLHA.equals(this);
	}
	
	public boolean isNotSelecionado() {
		return !isSelecionado();
	}

}
