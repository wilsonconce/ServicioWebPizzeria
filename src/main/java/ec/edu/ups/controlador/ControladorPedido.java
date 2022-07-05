package ec.edu.ups.controlador;

import com.sun.xml.bind.v2.model.core.EnumLeafInfo;
import ec.edu.ups.entidades.*;
import ec.edu.ups.entidades.peticiones.pedido.IngresarPedido;
import ec.edu.ups.entidades.peticiones.pedido.IngresarPedidoDetalle;
import ec.edu.ups.servicio.*;
import jdk.jfr.Timespan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Convert;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ControladorPedido {

    private PedidoServicio pedidoServicio;
    private PedidoDetalleServicio pedidoDetalleServicio;
    private CuentaServicio cuentaServicio;

    private ClienteServicio clienteServicio;

    private SucursalServicio sucursalServicio;

    private ProductoServicio productoServicio;

    private FacturaServicio facturaServicio;

    private FacturaDetalleServicio facturaDetalleServicio;
    private String productos;

    private String descripcion;
    private double precioUnitario = 0.00;
    private double precioTotal = 0.00;
    private int cantidad;
    private double iva;
    private double subtotal;
    private double total;

    private int codigoPro;

    private int stock;

    private int codigoSucu;

    private double latidudSucu;
    private double longitudSucu;
    private double distancia;
    private String correo;


    //Sucursal sucursal = new Sucursal();

    Optional<Usuario> usuario;

    List<DetalleFactura> detalles = new ArrayList<>();
    List<DetalleFactura> detallesvista = new ArrayList<>();
    List<PedidoDetalle> pedidoDetalles = new ArrayList<>();
    List<PedidoDetalle> pedidodetallesVista = new ArrayList<>();
    List<Factura> facturas = new ArrayList<>();

    public double getLatidudSucu() {
        return latidudSucu;
    }

    public void setLatidudSucu(double latidudSucu) {
        this.latidudSucu = latidudSucu;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getLongitudSucu() {
        return longitudSucu;
    }

    public void setLongitudSucu(double longitudSucu) {
        this.longitudSucu = longitudSucu;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getCodigoSucu() {
        return codigoSucu;
    }

    public void setCodigoSucu(int codigoSucu) {
        this.codigoSucu = codigoSucu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigoPro() {
        return codigoPro;
    }

    public void setCodigoPro(int codigoPro) {
        this.codigoPro = codigoPro;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @Autowired
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    @Autowired
    public void setCuentaServicio(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }

    @Autowired
    public void setPedidoDetalleServicio(PedidoDetalleServicio pedidoDetalleServicio) {
        this.pedidoDetalleServicio = pedidoDetalleServicio;
    }

    @Autowired
    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }

    @Autowired
    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @Autowired
    public void setFacturaServicio(FacturaServicio facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    @Autowired
    public void setFacturaDetalleServicio(FacturaDetalleServicio facturaDetalleServicio) {
        this.facturaDetalleServicio = facturaDetalleServicio;
    }

    @PostMapping("/pedido/crearCarrito")
    public ResponseEntity<PedidoDetalle> crearPedidoDetalle(@RequestBody IngresarPedidoDetalle ingresarPedidoDetalle) {

        DetalleFactura detalleFactura = new DetalleFactura();
        PedidoDetalle pedidoDetalle = new PedidoDetalle();

        Producto producto=productoServicio.retriveProductoByNombre(ingresarPedidoDetalle.getNombreProducto());
        descripcion = ingresarPedidoDetalle.getDescripcion();
        cantidad = ingresarPedidoDetalle.getCantidad();
        precioUnitario = producto.getPrecio();
        stock =producto.getStock();

        //if (productos != null) {

            //producto = productoServicio.retriveProductoByNombre(productos);
            System.out.println("El producto es: !!!!  " + producto.getNombre());

        //}
        //Probando hasta donde llega

        System.out.println(" pRODUCRTTO STOCK: " + stock);

        if (cantidad <= stock) {
            if (precioUnitario != 0) {
                //precioUnitario = producto.getPrecio();
                precioTotal = precioUnitario * cantidad;

            }
        }
        ingresarPedidoDetalle.setPrecioUnitario(precioUnitario);
        ingresarPedidoDetalle.setPrecioTotal(precioTotal);

        System.out.println("Precio unitario del producto es: " + precioUnitario);


        //System.out.println("El pinche codigo del producto es: " + codigoPro);
        System.out.println("EL precio del producto unitario es: " + precioUnitario);
        System.out.println("Precio Total = " + precioTotal);


        pedidoDetalle.setDescripcion(descripcion);
        pedidoDetalle.setProducto(producto);
        pedidoDetalle.setCantidad(cantidad);
        pedidoDetalle.setPrecioUnitario(precioUnitario);
        pedidoDetalle.setPrecioTotal(precioTotal);
        pedidoDetalles.add(pedidoDetalle);


        detalleFactura.setCantidad(cantidad);
        detalleFactura.setDescripcion(descripcion);
        detalleFactura.setPrecioUnitario(precioUnitario);
        detalleFactura.setPrecioTotal(precioTotal);
        detalleFactura.setProducto(producto);

        for (int i = 0; i < detalles.size(); i++) {
            subtotal = subtotal + detalles.get(i).getPrecioTotal();
            System.out.println("*******TOTAL *** : " + subtotal);
        }
        iva = (precioTotal * 0.12);
        total = (precioTotal + iva);
        ingresarPedidoDetalle.setIva(iva);
        ingresarPedidoDetalle.setSubtotalFac(precioTotal);
        //ingresarPedidoDetalle.setTotalFac(total);
        //ingresarPedidoDetalle.setPrecioUnitario(precioUnitario);
        System.out.println("Comprobando Facturas Detalle");
        System.out.println("factura Detalle subtotal = " + precioTotal);
        System.out.println("factura Detalle IVA = " + iva);
        System.out.println("factura Detalle Total = " + total);

        detalles.add(detalleFactura);
        //pedidoDetalleServicio.save(pedidoDetalle);

        return ResponseEntity.ok(pedidoDetalle);


    }

    public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
        //double radioTierra = 3958.75;//en millas
        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distanciaPuntos = radioTierra * va2;

        return distanciaPuntos;
    }

    @PostMapping("/pedido/crearPedido")
    public ResponseEntity<Pedido> crearPedido(@RequestBody IngresarPedido ingresarPedido) throws ParseException {
        Optional<Sucursal> sucursal = sucursalServicio.retriveSucursalByName(ingresarPedido.getSucursalNombre());

        if (sucursal.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Cuenta> cuenta = cuentaServicio.findByCorreo(ingresarPedido.getCorreoUsuario());

        if (cuenta.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }


        Pedido pedido = new Pedido();
        Factura fac = new Factura();

        double formulaTiempo;
        Sucursal sucu = new Sucursal();
        Cuenta cue = new Cuenta();
        latidudSucu = sucursalServicio.latitudPorNombre(ingresarPedido.getSucursalNombre());
        longitudSucu = sucursalServicio.longitudPorNombre(ingresarPedido.getSucursalNombre());
        distancia = distanciaCoord(latidudSucu, longitudSucu, ingresarPedido.getLatitudUsuario(), ingresarPedido.getLingitudUsuario());
        codigoSucu = sucursalServicio.codigoPorNombre(ingresarPedido.getSucursalNombre());

        correo = ingresarPedido.getCorreoUsuario();

        System.out.println("Latidud es: " + latidudSucu + "Longitus ES: " + longitudSucu);
        System.out.println("***********");
        System.out.println("La distancia entre sucursal y cliente es: " + distancia);
        formulaTiempo = (distancia/25)*60;




       // TimeSpan ts = new TimeSpan(hours, minutes, seconds);




        ingresarPedido.setDistancia(distancia);
        pedido.setDistanciaRecorrido(distancia);
        if (distancia <= 2.0) {
            pedido.setCostoEnvio(2.00);
            ingresarPedido.setCostoEnvio(2.00);
            pedido.setTiempoAprox(Time.valueOf("00:20:00"));
        }
        if (distancia >= 2.00 && distancia <= 5.00) {
            pedido.setCostoEnvio(3.00);
            ingresarPedido.setCostoEnvio(3.00);
            pedido.setTiempoAprox(Time.valueOf("00:45:00"));
        } else {
            pedido.setCostoEnvio(5.00);
            ingresarPedido.setCostoEnvio(5.00);
            pedido.setTiempoAprox(Time.valueOf("01:00:00"));
        }


        //pedido.setCuentaPedido(cuentaServicio.buscarCuentaPorCorreo(correo));

        for (int i = 0; i < pedidoDetalles.size(); i++) {
            pedidoDetalles.get(i).setPedidoDetalle(pedido);

        }

        pedido.setPedidoDetalle(pedidoDetalles);
        pedido.setEstado(EstadoPedido.RECEPTADO);
        ingresarPedido.setEstadoPedido(String.valueOf(EstadoPedido.RECEPTADO));

        sucu = sucursal.get();
        cue = cuenta.get();

        pedido.setCuentaPedido(cue);
        pedido.setSucursal(sucu);

        System.out.println(cue);
        System.out.println(sucu);
        System.out.println("Pedido: " + pedido.toString());
//        sucursalServicio.save(sucu);
//        cuentaServicio.save(cue);


        System.out.println("Codigo Sucursal: " + codigoSucu);

        //System.out.println("Nombre Sucursal: "+sucursalServicio.sucursalPorCodigo(codigoSucu));


        System.out.println("Correo: " + correo);


        fac.setPedidoFactura(pedido);
        System.out.println("Subtotal de Factura es: " + precioTotal);
        fac.setFechaFactura(new Date());
        fac.setCuentaFactura(cue);
        fac.setUsuarioFactura(cue.getUsuario());
        fac.setTipoPago(new TipoPago(1, "Corriente"));
        fac.setFacturadetalle(detalles);
        fac.setEstadoFactura(true);

        fac.setSubtotal(precioTotal);
        fac.setIva(iva);
        fac.setTotal(total);
        System.out.println(fac);
        System.out.println("Puto COdigo de factura: "+fac.getCodigoFactura());
        pedido.setPedidoFactura(fac);
        pedidoServicio.savePedido(pedido);

        System.out.println("Stock Actual"+stock);
        System.out.println("Total de Factura" +total);
        System.out.println(detalles.size());
        for (int i = 0; i < detalles.size(); i++) {
                detalles.get(i).setFacturadetalle(fac);
                Producto p = productoServicio.retriveProductoByNombre(detalles.get(i).getDescripcion());
                p.setStock(p.getStock() - detalles.get(i).getCantidad());
                facturaDetalleServicio.save(detalles.get(i));
                productoServicio.save(p);
                System.out.println(detalles.get(i));
        }
        System.out.println("Stock despues del for " +stock);


        //System.out.println("cuenta correo: "+cuentaServicio.buscarCuentaPorCorreo(correo));
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/pedido/listar")
    ResponseEntity<List<Pedido>> getAllPedidos() {

        List<Pedido> listapedido = pedidoServicio.findAll();

        return new ResponseEntity<List<Pedido>>(listapedido, HttpStatus.OK);

    }
}
