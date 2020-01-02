package domain.model;

public enum EstadoCivilVO {
	
	ESCOLHA,
	CASADO,
	SOLTEIRO,
	VIUVO;
	
	public boolean isSelecionado() {
		return !ESCOLHA.equals(this);
	}
	
	public boolean isNotSelecionado() {
		return !isSelecionado();
	}

}
