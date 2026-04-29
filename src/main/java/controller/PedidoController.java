package controller;

import model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PedidoService;

@Controller
@RequestMapping ("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    //Listar todos los pedidos
    @GetMapping
    public String listar(Model model){
        model.addAttribute("pedidos", service.obtenerTodo());
        return "/pedidos/lista";
    }

    //Editar pedido
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model){
        model.addAttribute("pedidos", service.obtenerPorId(id));
        return "/pedidos/form";
    }

    //Eliminar pedido
    @GetMapping("/eliminar/{id}")
    public String formDelete(@PathVariable Long id){
        service.eliminar(id);
        return "redirect:/pedidos";
    }

    //Mostrar el formulario para crear o editar
    @GetMapping("/pedidos/nuevo")
    public String formNuevo(Model model){
        model.addAttribute("pedido", new Pedido() );
        return "pedidos/form";
    }

    //Guardar pedido (edición o creación)
    @PostMapping("/pedidos/guardar")
    public String formGuardar(Pedido pedido){
        service.guardar(pedido);
        return "redirect:/pedidos";
    }


    //Gestionar pedido - REVISAR!!!
    @GetMapping("pedidos/{id}")
    public String formGestionar(@PathVariable Long id, Model model){
        model.addAttribute("pedido", service.obtenerPorId(id));
        return "/pedidos/productos";
    }

    //Desasignar producto en pedido
    @GetMapping("/pedidos/{pid}/desasignar/{rid}")

}
