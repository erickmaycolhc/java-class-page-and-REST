package com.springboot.web.app.controllers;

import com.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping({"/index", "/","", "/home"})
        public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework con Model");
        return "index";
    }
        /*                  otros modos de pasar datos
        public String index(Map<String, Object> map){
            map.put("titulo", "Hola Spring Framework con Map!");
            return "index";

         public ModelAndView index(ModelAndView mv){
            mv.addObject("titulo" , "Hola Spring Framework con ModelAndView");
            mv.setViewName("index");
            return mv;
        }
        }*/

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Carlos");
        usuario.setApellido("Cirineo");
        usuario.setEmail("erickmaycolhc@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("perfil", "Perfil del usuario: " .concat(usuario.getNombre()) + " ".concat(usuario.getApellido()) );
        return "perfil";
    }

//+ " apellido: ".concat(usuario.getApellido())

    @RequestMapping("/listar")
    public String listar(Model model){
      model.addAttribute("titulo","Listado de usuarios");

      return "listar";
    };

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Erick","Cirineo","erick@gmail.com"),
                new Usuario("Maycol","Cirineo","maycol@gmail.com"),
                new Usuario("Josue","Cirineo","josue@gmail.com")
        );
        return usuarios;
    };
}
