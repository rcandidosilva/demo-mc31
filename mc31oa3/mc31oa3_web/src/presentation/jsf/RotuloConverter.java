package presentation.jsf;

import integration.dao.RotuloDAO;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import business.entity.Rotulo;

public class RotuloConverter implements Converter {

	@EJB
	private RotuloDAO rotuloDAO;
	
	@Override
	public Object getAsObject(final FacesContext $arg0,
			final UIComponent $arg1, final String $value) {
		Rotulo rotulo = null;
		if ($value != null) {
			final int id = Integer.parseInt($value);
			//TODO: Ajustar a DI (@EJB) para o RotuloConverter
			rotulo = rotuloDAO.findById(id);
		}// if
		return rotulo;
	}

	@Override
	public String getAsString(final FacesContext $arg0,
			final UIComponent $arg1, final Object $value) {
		String id = "";
		if ($value != null) {
			id = String.valueOf(((Rotulo) $value).getId());
		}// if
		return id;
	}

}
