package presentation.jsf;

import integration.dao.CategoriaDAO;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import business.entity.Categoria;

public class CategoriaConverter implements Converter {

	@EJB
	private CategoriaDAO categoriaDAO;
	
	@Override
	public Object getAsObject(final FacesContext $arg0,
			final UIComponent $arg1, final String $value) {
		Categoria categoria = null;
		if ($value != null) {
			final int id = Integer.parseInt($value);
			//TODO: Ajustar a DI (@EJB) para o CategoriaConverter
			categoria = this.categoriaDAO.findById(id);
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
