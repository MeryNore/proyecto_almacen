package model;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Producto {

    @Id //Identificador de registro
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para la base de datos generar automáticamente el id
    private Long id; //NULL
    private String nombre;
    private Double precio;

    @ManyToMany(mappedBy = "productos") //Explica la relación N:M (relación entre productos y pedidos) en este caso Producto es el lado inverso/no propietario
    private Set<Pedido> pedidos = new HashSet<>(); //Representación de todos los pedidos en los que aparece el producto
    //Ponemos set para evitar duplicaciones


    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Set<Pedido> getPedidos() { return pedidos; } //Para devolver todos los pedidos donde aparece el producto
    public void setPedidos(Set<Pedido> pedidos) { this.pedidos = pedidos; } //Esto permite reemplazar el conjunto de pedidos


}