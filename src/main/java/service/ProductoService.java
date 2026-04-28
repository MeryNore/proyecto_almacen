package service;

import model.Pedido;
import model.Producto;
import repository.PedidoRepository;
import repository.ProductoRepository;

import java.util.List;

public class ProductoService {

    private PedidoService pedidoService;
    private ProductoRepository productoRepo;

    public ProductoService(PedidoService pedidoService, ProductoRepository productoRepo){
        this.pedidoService = pedidoService;
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
