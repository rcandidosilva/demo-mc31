package presentation.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import presentation.util.BusinessDelegate;
import business.entity.Rotulo;

public class RotuloConverter implements Converter {

	@Override
	public Object getAsObject(final FacesContext $arg0,
			final UIComponent $arg1, final String $value) {
		Rotulo rotulo = null;
		if ($value != null) {
			final int id = Integer.parseInt($value);
			rotulo = BusinessDelegate.INSTANCE.findRotuloById(id); 
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
