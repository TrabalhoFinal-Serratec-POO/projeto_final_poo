package org.serratec.humano;

public enum Parentesco {
	FILHO(1, "Filho"), SOBRINHO(2, "Sobrinho"), OUTROS(3, "Outros");

	private int tipo;
	private String parentesco;

	private Parentesco(int tipo, String parentesco) {
		this.tipo = tipo;
		this.parentesco = parentesco;
	}

	public int getTipo() {
		return tipo;
	}

	public String getParentesco() {
		return parentesco;
	}

}
