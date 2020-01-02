package domain.model;

public enum SexoVO {
	
	ESCOLHA,
	Feminino,
	Masculino;
	
	public boolean isSelecionado() {
		return !ESCOLHA.equals(this);
	}
	
	public boolean isNotSelecionado() {
		return !isSelecionado();
	}
	
	

}
