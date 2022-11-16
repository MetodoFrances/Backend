package com.leasing.backend.domains.users.controller;

import com.leasing.backend.domains.users.domain.service.UserService;
import com.leasing.backend.domains.users.resource.UserResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegisterUserController {
	private UserService userService;

	public RegisterUserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserResource retornarNuevoUsuarioRegistroDTO() {
		return new UserResource();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("user") UserResource userResource) {
		userService.create(userResource);
		return "redirect:/registro?exito";
	}
}
