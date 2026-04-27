package model;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Producto {

    @Id //IDENTIFICADOR DE REGISTRO
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PARA LA BASE DE DATO GENERAR AUTOMÁTICAMENTE EL ID
    private Long id; //NULL
    private String nombre;
    private Double precio;

    @ManyToMany(mappedBy = "productos") //EXPLICA LA RELACIÓN N:M (relación entre productos y pedidos) en este caso Producto es el lado inverso/no propietario
    private Set<Pedido> pedidos = new HashSet<>(); //REPRESENTACIÓN DE TODOS LOS PEDIDOS EN LOS QUE APARECE EL PRODUCTO
    //PONEMOS SET PARA EVITAR DUPLICACIONES


    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Set<Pedido> getPedidos() { return pedidos; } //PARA DEVOLVER TODOS LOS PEDIDOS DONDE APARECE EL PRODUCTO
    public void setPedidos(Set<Pedido> pedidos) { this.pedidos = pedidos; } //ESTO PERMITE REEMPLAZAR EL CONJUNTO DE PEDIDOS



}
