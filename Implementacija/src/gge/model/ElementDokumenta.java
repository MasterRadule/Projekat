package gge.model;

public abstract class ElementDokumenta {
	private String entityID;
	private String lifecycleName;
	private Dokument dokument;

	public ElementDokumenta() {
	}

	public ElementDokumenta(String entityID, String lifecycleName, Dokument dokument) {
		this.entityID = entityID;
		this.lifecycleName = lifecycleName;
		this.dokument = dokument;
	}

	public String getEntityID() {
		return entityID;
	}

	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}

	public String getLifecycleName() {
		return lifecycleName;
	}

	public void setLifecycleName(String lifecycleName) {
		this.lifecycleName = lifecycleName;
	}

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementDokumenta other = (ElementDokumenta) obj;
		if (entityID == null) {
			if (other.entityID != null)
				return false;
		} else if (!entityID.equals(other.entityID))
			return false;
		return true;
	}

}
