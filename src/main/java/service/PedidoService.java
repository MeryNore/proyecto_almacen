package service;

import model.Pedido;
import model.Producto;
import repository.PedidoRepository;
import repository.ProductoRepository;

import java.util.List;


public class PedidoService {

    private PedidoRepository pedidoRepo;
    private ProductoService productoService;

    public PedidoService(PedidoRepository pedidoRepo, ProductoService productoService){
        this.pedidoRepo = pedidoRepo;
        this.productoService = productoService;
    }

    public List<Pedido> obtenerTodo(){
        return pedidoRepo.findAll();
    }

    public Pedido obtenerPorId(Long id){
        return pedidoRepo.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado: " + id));
    }

    public void guardar(Pedido pedido){
        pedidoRepo.save(pedido);
    }

    public void eliminar(Long id){
        pedidoRepo.deleteById(id);
    }

    public void asignarProducto(Long pedidoId, Long productoId) {
        Pedido pedido = obtenerPorId(pedidoId);
        Producto producto = productoService.obtenerPorId(productoId);
        pedido.getProductos().add(producto);
        pedidoRepo.save(pedido);
    }

    public void desasignarProduco(Long pedidoId, Long productoId){
        Pedido pedido = obtenerPorId(pedidoId);
        pedido.getProductos().removeIf(p -> p.getId().equals(productoId));

    }


}
