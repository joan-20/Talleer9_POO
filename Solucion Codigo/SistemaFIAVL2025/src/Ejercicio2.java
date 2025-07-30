import java.util.ArrayList;
import java.util.List;


public class Ejercicio2 {
    public static void main(String[] args) {
        SistemaMovilidad sistema = new SistemaMovilidad();

        Usuario u1 = new Usuario("Ana Loja", "1101122334", "Estudiante");
        Usuario u2 = new Usuario("Carlos Perez", "1100988776", "Publico");
        Usuario u3 = new Usuario("Dra. Rosas", "1100554321", "Docente");

        sistema.registrarUsuario(u1);
        sistema.registrarUsuario(u2);
        sistema.registrarUsuario(u3);

        ServicioMovilidad s1 = new Ktaxi(5.0, 12);
        ServicioMovilidad s2 = new Situ(true);
        ServicioMovilidad s3 = new AppBusesUTPL(true);

        sistema.agregarServicio(s1);
        sistema.agregarServicio(s2);
        sistema.agregarServicio(s3);

        sistema.mostrarFacturas();
    }
}

class Usuario {
    public String nombre;
    public String cedula;
    public String tipo;

    public Usuario(String nombre, String cedula, String tipo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Cedula: " + cedula + " | Tipo: " + tipo;
    }
}


abstract class ServicioMovilidad {
    public String nombreServicio;
    public String empresa;
    public double tarifaBase;

    public ServicioMovilidad(String nombreServicio, String empresa, double tarifaBase) {
        this.nombreServicio = nombreServicio;
        this.empresa = empresa;
        this.tarifaBase = tarifaBase;
    }

    public abstract double calcularCosto();

    

    public String generarFactura(Usuario u) {
        return "----- FACTURA -----\n"
             + "Cliente: " + u + "\n"                   
             + "Empresa: " + empresa + "\n"
             + "Servicio: " + nombreServicio + "\n"
             + toString()                                
             + "Costo total: $" + String.format("%.2f", calcularCosto()) + "\n";
    }

    public void calificarServicio(int estrellas) {
        System.out.println("Calificacion registrada: " + estrellas + " estrellas.");
    }
}

class Ktaxi extends ServicioMovilidad {
    public double kmRecorridos;
    public int tiempoMin;

    public Ktaxi(double kmRecorridos, int tiempoMin) {
        super("Ktaxi", "KRADAC", 0.50);
        this.kmRecorridos = kmRecorridos;
        this.tiempoMin = tiempoMin;
    }

    @Override
    public double calcularCosto() {
        return tarifaBase * kmRecorridos + (tiempoMin * 0.10);
    }

    @Override
    public String toString() {
        return "Km recorridos: " + kmRecorridos + "\n"
             + "Tiempo: " + tiempoMin + " min\n"
             + "Tarifa por Km: $" + tarifaBase + "\n";
    }
}


class Situ extends ServicioMovilidad {
    public boolean descuentoAplicado;

    public Situ(boolean descuentoAplicado) {
        super("Situ", "CEDIA", 0.30);
        this.descuentoAplicado = descuentoAplicado;
    }

    @Override
    public double calcularCosto() {
        return descuentoAplicado ? tarifaBase * 0.5 : tarifaBase;
    }

    @Override
    public String toString() {
        return "Pasaje estandar: $" + tarifaBase + "\n"
             + "Descuento aplicado: " + (descuentoAplicado ? "Si (50%)" : "No") + "\n";
    }
}


class AppBusesUTPL extends ServicioMovilidad {
    public boolean esEstudianteUTPL;

    public AppBusesUTPL(boolean esEstudianteUTPL) {
        super("AppBusesUTPL", "UTPL", 0.0);
        this.esEstudianteUTPL = esEstudianteUTPL;
    }

    @Override
    public double calcularCosto() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Servicio gratuito de bus interno UTPL\n"
             + "Acceso autorizado para: " + (esEstudianteUTPL ? "Estudiantes UTPL" : "Publico en general") + "\n";
    }
}

class SistemaMovilidad {
    public List<Usuario> listaUsuarios = new ArrayList<>();
    public List<ServicioMovilidad> listaServicios = new ArrayList<>();

    public void registrarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public void agregarServicio(ServicioMovilidad s) {
        listaServicios.add(s);
    }

    public void mostrarFacturas() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println(listaServicios.get(i).generarFactura(listaUsuarios.get(i)));
            listaServicios.get(i).calificarServicio((int)(Math.random() * 5 + 1));
            System.out.println("------------------------");
        }
    }
}
/*
debug:
----- FACTURA -----
Cliente: Nombre: Ana Loja | Cedula: 1101122334 | Tipo: Estudiante
Empresa: KRADAC
Servicio: Ktaxi
Km recorridos: 5.0
Tiempo: 12 min
Tarifa por Km: $0.5
Costo total: $3,70

Calificacion registrada: 4 estrellas.
------------------------
----- FACTURA -----
Cliente: Nombre: Carlos Perez | Cedula: 1100988776 | Tipo: Publico
Empresa: CEDIA
Servicio: Situ
Pasaje estandar: $0.3
Descuento aplicado: Si (50%)
Costo total: $0,15

Calificacion registrada: 3 estrellas.
------------------------
----- FACTURA -----
Cliente: Nombre: Dra. Rosas | Cedula: 1100554321 | Tipo: Docente
Empresa: UTPL
Servicio: AppBusesUTPL
Servicio gratuito de bus interno UTPL
Acceso autorizado para: Estudiantes UTPL
Costo total: $0,00

Calificacion registrada: 1 estrellas.
------------------------
BUILD SUCCESSFUL (total time: 1 second)

*/