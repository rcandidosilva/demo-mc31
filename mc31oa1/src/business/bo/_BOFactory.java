package business.bo;

import integration.dao._DAOFactory;

public enum _BOFactory {

	INSTANCE;
	private final ArtigosBO artigosBO = new ArtigosBO();

	_BOFactory() {
		this.initArtigosBO();
	}

	public ArtigosBO getArtigosBO() {
		return this.artigosBO;
	}

	private void initArtigosBO() {
		this.artigosBO.setArtigoDAO(_DAOFactory.INSTANCE.getArtigoDAO());
		this.artigosBO.setCategoriaDAO(_DAOFactory.INSTANCE.getCategoriaDAO());
		this.artigosBO.setRotuloDAO(_DAOFactory.INSTANCE.getRotuloDAO());
	}
}
