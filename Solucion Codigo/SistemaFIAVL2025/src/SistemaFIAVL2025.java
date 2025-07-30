

import java.util.ArrayList;
import java.util.List;
public class SistemaFIAVL2025 {
    public static void main(String[] args) {
        List<Presentacion> presentaciones = new ArrayList<>();

        RecursosTecnicos recursos1 = new RecursosTecnicos(3000, 2000, 5000);
        RecursosTecnicos recursos2 = new RecursosTecnicos(1500, 1200, 2500);

        Presentacion musica1 = new PresentacionMusical("Concierto Sinfonico Loja", 120, 800, recursos1);
        Presentacion teatro1 = new PresentacionTeatral("Obra Clasica Andina", 90, 300, recursos2);

        presentaciones.add(musica1);
        presentaciones.add(teatro1);

        System.out.println("REPORTE FINAL DE PRESENTACIONES");
        System.out.println("==================================");

        for (Presentacion p : presentaciones) {
            System.out.println(p);
        }
    }
}

abstract class Presentacion {
     String titulo;
    public int duracion; 
    public int aforoPermitido;
    public RecursosTecnicos recursosTecnicos;

    public Presentacion(String titulo, int duracion, int aforoPermitido, RecursosTecnicos recursosTecnicos) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.aforoPermitido = aforoPermitido;
        this.recursosTecnicos = recursosTecnicos;
    }

    public double calcularCostoBase() {
        double totalRecursos = recursosTecnicos.getTotalRecursos();
        return (totalRecursos == 0) ? 0 : aforoPermitido / totalRecursos;
    }

    public abstract double calcularCostoFinal();

    @Override
    public String toString() {
        return "Titulo: " + titulo +
               "\nDuracion: " + duracion + " minutos" +
               "\nAforo permitido: " + aforoPermitido +
               "\nCosto base: $" + String.format("%.2f", calcularCostoBase()) +
               "\nCosto final: $" + String.format("%.2f", calcularCostoFinal()) +
               "\n" + recursosTecnicos.toString() +
               "\n-----------------------------------";
    }
}

class PresentacionMusical extends Presentacion {
    public PresentacionMusical(String titulo, int duracion, int aforoPermitido, RecursosTecnicos recursosTecnicos) {
        super(titulo, duracion, aforoPermitido, recursosTecnicos);
    }
    @Override
    public double calcularCostoFinal() {
        double base = calcularCostoBase();
        double indiceAforo = (aforoPermitido >= 500) ? 0.05 : 0.01;
        return base + (duracion * 0.08) + (aforoPermitido * indiceAforo);
    }
}

class PresentacionTeatral extends Presentacion {
    public PresentacionTeatral(String titulo, int duracion, int aforoPermitido, RecursosTecnicos recursosTecnicos) {
        super(titulo, duracion, aforoPermitido, recursosTecnicos);
    }
    @Override
    public double calcularCostoFinal() {
        double base = calcularCostoBase();
        return (base * 1.1) + (duracion * 0.05);
    }
}

class RecursosTecnicos {
    public double sonido;
    public double iluminacion;
    public double escenografia;

    public RecursosTecnicos(double sonido, double iluminacion, double escenografia) {
        this.sonido = sonido;
        this.iluminacion = iluminacion;
        this.escenografia = escenografia;
    }

    public double getTotalRecursos() {
        return sonido + iluminacion + escenografia;
    }

    @Override
    public String toString() {
        return "Recursos Tecnicos:" +
               "\nSonido: $" + sonido +
               "\nIluminacion: $" + iluminacion +
               "\nEscenografia: $" + escenografia +
               "\nTotal: $" + getTotalRecursos();
    }
}

/*
debug:
REPORTE FINAL DE PRESENTACIONES
==================================
Titulo: Concierto Sinfonico Loja
Duracion: 120 minutos
Aforo permitido: 800
Costo base: $0,08
Costo final: $49,68
Recursos Tecnicos:
Sonido: $3000.0
Iluminacion: $2000.0
Escenografia: $5000.0
Total: $10000.0
-----------------------------------
Titulo: Obra Clasica Andina
Duracion: 90 minutos
Aforo permitido: 300
Costo base: $0,06
Costo final: $4,56
Recursos Tecnicos:
Sonido: $1500.0
Iluminacion: $1200.0
Escenografia: $2500.0
Total: $5200.0
-----------------------------------
BUILD SUCCESSFUL (total time: 2 seconds)

*/