package controller;

import model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProductoService;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service){
        this.service = service;
    }

    //Permite listar todos los productos.
    @GetMapping
    public String listar(Model model){
        model.addAttribute("productos", service.obtenerTodo());
        return "productos/lista";
    }

    //Mostrar el formulario con el que crear
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model){
        model.addAttribute("producto", new Producto());
        return  "productos/form";
    }

    //Mostrar el formulario con el que editar por el id
    @GetMapping("/editar/{id}")
    public String formularioNuevo(@PathVariable Long id, Model model) {
        model.addAttribute("producto", service.obtenerPorId(id));
        return "productos/form";
    }

    //Guardar (sea un INSERT o un UPDATE, en función del id)
    @PostMapping("/guardar")
    public String guardar(Producto producto){

    }
}
