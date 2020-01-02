package domain.model;

public enum UFVO {
	
	ESCOLHA, RS, SC, PR, SP, RJ, ES, MG, MS, MT, GO,
	BA, DF, SE, PI, MA, PE, AM, AL, RN, RR,
	RO, AC, TO, PB, CE, PA, AP;

	public boolean isSelecionado() {
		return !ESCOLHA.equals(this);
	}

	public boolean isNotSelecionado() {
		return !isSelecionado();
	}


}
