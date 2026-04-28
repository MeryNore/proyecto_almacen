package service;

import model.Pedido;
import model.Producto;
import org.springframework.stereotype.Service;
import repository.PedidoRepository;
import repository.ProductoRepository;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepo;
    private final ProductoService productoService;

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
