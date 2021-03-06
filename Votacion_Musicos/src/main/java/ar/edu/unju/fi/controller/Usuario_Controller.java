package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/usuario") //@{/usuario/listaUsuario}
public class Usuario_Controller {
	
	@Autowired
	@Qualifier("UsuarioServiceImpList")
	private IUsuarioService usuarioService;
	
	private static final Log LOGGER = LogFactory.getLog(Usuario_Controller.class);
	@GetMapping("/nuevo")
	public String getUsuarios(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "nuevo_usuario";
	}
	@PostMapping("/guardar")
	public ModelAndView getListaUsuarioPage(@Validated @ModelAttribute("usuario")Usuario usuario,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav= new ModelAndView("nuevo_usuario");
			mav.addObject("usuario", usuario);
			return mav;
		}
		ModelAndView mav=new ModelAndView("redirect:/usuario/listaUsuarios");
		usuario.setCont_voto(0);
		if(usuarioService.guardarUsuario(usuario)) {
			LOGGER.info("Se registro usuario "+usuario.getNombre());
		}
		return mav;
	}
	
	@GetMapping("/listaUsuarios")
	public String getListaCargada(Model model){
		model.addAttribute("usuarios",usuarioService.getListaUsuario().getUsuario());
		return "lista_usuario";
	}
	
	@GetMapping("/votar/{email}")
	public ModelAndView getResitroVotoPage(@PathVariable(value="email") String email) {
		if(usuarioService.guardarVoto(email)) {
			LOGGER.info("Se realiz?? el voto de "+usuarioService.buscarUsuario(email).getNombre());
			ModelAndView mav = new ModelAndView("redirect:/Candidatos/listaEleccion");
			return mav;
		}else {
			LOGGER.info("No se realiz?? el voto de "+usuarioService.buscarUsuario(email).getNombre());
			ModelAndView mav = new ModelAndView("error_page");
			return mav;
		}
	}
	

}
