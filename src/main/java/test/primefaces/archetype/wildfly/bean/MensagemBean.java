package test.primefaces.archetype.wildfly.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import test.primefaces.archetype.wildfly.model.Mensagem;

@Named(value = "mensagemBean")
@ViewScoped
public class MensagemBean extends GenericBean implements Serializable {
private static final long serialVersionUID = 1L;
	
	//@Inject
	private Mensagem mensagem;
	
	@PostConstruct
	public void init() {
		this.mensagem = new Mensagem("Hello!!");
	}
	
	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}

