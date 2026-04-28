package service;

import model.Pedido;
import model.Producto;
import org.springframework.stereotype.Service;
import repository.PedidoRepository;
import repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepo;

    public ProductoService(ProductoRepository productoRepo){
        this.productoRepo = productoRepo;
    }

    public List<Producto> obtenerTodo(){
        return productoRepo.findAll();
    }

    public Producto obtenerPorId(Long id){
        return productoRepo.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado: " + id));
    }

    public void guardar(Producto producto){
        productoRepo.save(producto);
    }

    public void eliminar(Long id){
        productoRepo.deleteById(id);
    }

}
