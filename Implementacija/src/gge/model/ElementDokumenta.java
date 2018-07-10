package gge.model;

public abstract class ElementDokumenta {
	private String entityID;
	private String lifecycleName;

	public ElementDokumenta() {
	}

	public ElementDokumenta(String entityID, String lifecycleName) {
		this.entityID = entityID;
		this.lifecycleName = lifecycleName;
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

}
