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

}
