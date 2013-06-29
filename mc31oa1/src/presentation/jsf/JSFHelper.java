package presentation.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFHelper {

	public void addGlobalErrorMessage(final Exception e) {
		this.addGlobalErrorMessage(e.getLocalizedMessage(), e
				.getLocalizedMessage());
	}

	public void addGlobalErrorMessage(final String $resumida,
			final String $detalhada) {
		this.addMessage(FacesMessage.SEVERITY_ERROR, null, $resumida,
				$detalhada);
	}

	public void addGlobalInfoMessage(final String $resumida,
			final String $detalhada) {
		this
				.addMessage(FacesMessage.SEVERITY_INFO, null, $resumida,
						$detalhada);
	}

	private void addMessage(final FacesMessage.Severity $severity,
			final String $target, final String $resumida,
			final String $detalhada) {
		if (this.existFacesContext()) {
			final FacesMessage fm = new FacesMessage($resumida, $detalhada);
			this.getFacesContext().addMessage($target, fm);
		}// if
	}

	private boolean existFacesContext() {
		return (FacesContext.getCurrentInstance() != null);
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
