package gge.model;

public class OsobinePolja {
	private boolean modifying;
	private boolean hide;
	private boolean mandatory;
	private Polje polje;

	public OsobinePolja() {
	}

	public OsobinePolja(boolean modifying, boolean hide, boolean mandatory, Polje polje) {
		this.modifying = modifying;
		this.hide = hide;
		this.mandatory = mandatory;
		this.polje = polje;
	}

	public boolean isModifying() {
		return modifying;
	}

	public void setModifying(boolean modifying) {
		this.modifying = modifying;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Polje getPolje() {
		return polje;
	}

	public void setPolje(Polje polje) {
		this.polje = polje;
	}

}
