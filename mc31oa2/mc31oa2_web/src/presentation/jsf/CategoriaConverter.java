package presentation.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import presentation.util.BusinessDelegate;
import business.entity.Categoria;

public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(final FacesContext $arg0,
			final UIComponent $arg1, final String $value) {
		Categoria categoria = null;
		if ($value != null) {
			final int id = Integer.parseInt($value);
			categoria = BusinessDelegate.INSTANCE.findCategoriaById(id); 
		}// if
		return categoria;
	}

	@Override
	public String getAsString(final FacesContext $arg0,
			final UIComponent $arg1, final Object $value) {
		String id = "";
		if ($value != null) {
			id = String.valueOf(((Categoria) $value).getId());
		}// if
		return id;
	}

}
