
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

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.service.ICandidatoService;



@Controller
@RequestMapping("/Candidatos")
public class CandidatoController {
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;
	
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	//private ListaCandidato lista_candidatos = new ListaCandidato();
	
	@GetMapping("/nuevo")
	public String getCandidatos(Model model) {
		
		model.addAttribute("candidato", candidatoService.getCandidato());
		return "nuevo_candidato";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCandidatosPage(@Validated @ModelAttribute("candidato")Candidato candidato, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav= new ModelAndView("nuevo_candidato");
			mav.addObject("candidato", candidato);
			return mav;
		}
		ModelAndView mav=new ModelAndView("redirect:/Candidatos/listaCandidatos");
		if(candidatoService.guardarCandidato(candidato)) {
			LOGGER.info("Se registro un candidato "+candidato.getNombre());
		}else {
			LOGGER.info("No se puede registrar al candidato "+candidato.getNombre());
		}
		mav.addObject("unCandidato", candidatoService.getListaCandidato());
		return mav;
	}
	@GetMapping("/listaCandidatos")
	public String getListaCargada(Model model){
		model.addAttribute("unCandidato",candidatoService.getListaCandidato().getCandidato());
		return "lista_candidatos"; 
	}
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCandidatoPage(@PathVariable(value="codigo") int codigo) {
		ModelAndView mav = new ModelAndView("edicion_candidato");
		Candidato candidato= candidatoService.buscarCandidato(codigo);
		mav.addObject("candidato", candidato);
		return mav;
	}
	@PostMapping("/modificar")
	public ModelAndView editarDatosCandidato(@Validated @ModelAttribute("candidato") Candidato candidato, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
		}
		//
		ModelAndView mav= new ModelAndView("redirect:/Candidatos/listaCandidatos");
		candidatoService.modificarCandidato(candidato);
		return mav;
	}
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getElimnarCandidato(@PathVariable(value="codigo") int codigo) {
		
		ModelAndView mav=new ModelAndView("redirect:/Candidatos/listaCandidatos");
		candidatoService.eliminarCandidato(codigo);
		return mav;
	}
}
