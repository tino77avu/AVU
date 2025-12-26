package com.admin.avu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Inicio - Especialista en Bases de Datos");
        return "index";
    }

    @GetMapping("/sobre-mi")
    public String sobreMi(Model model) {
        model.addAttribute("titulo", "Sobre Mí - Especialista en Bases de Datos");
        return "sobre-mi";
    }

    @GetMapping("/experiencia")
    public String experiencia(Model model) {
        model.addAttribute("titulo", "Experiencia - Especialista en Bases de Datos");
        return "experiencia";
    }

    @GetMapping("/especialidades")
    public String especialidades(Model model) {
        model.addAttribute("titulo", "Especialidades - Especialista en Bases de Datos");
        return "especialidades";
    }

    @GetMapping("/certificaciones")
    public String certificaciones(Model model) {
        model.addAttribute("titulo", "Certificaciones - Especialista en Bases de Datos");
        return "certificaciones";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("titulo", "Contacto - Especialista en Bases de Datos");
        return "contacto";
    }
}

