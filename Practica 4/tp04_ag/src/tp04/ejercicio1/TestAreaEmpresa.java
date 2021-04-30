package tp04.ejercicio1;

import tp02.ejercicio2.*;

public class TestAreaEmpresa {
	
	public Integer devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol) {
		Integer promedio = 0;
		int prom = 0;
		int cant = 0; int aux;
		if (!arbol.esVacio()) {
			ArbolGeneral<AreaEmpresa> a = null;
			ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
			ListaGenerica<ArbolGeneral<AreaEmpresa>> lHijos = null;
			cola.encolar(arbol);
			cola.encolar(null);
			
			while (!cola.esVacia()) {
				a = cola.desencolar();
				if (a != null) {
					cant++;
					prom += a.getDato().getRetardo_mensaje();
					
					if (a.tieneHijos()) {
						lHijos = a.getHijos();
						lHijos.comenzar();
						while (!lHijos.fin()) 
							cola.encolar(lHijos.proximo());
					}
				} else if (!cola.esVacia()) {
					cola.encolar(null);
					aux = prom/cant;
					if (promedio < aux) {
						promedio = aux;
					}
					prom = 0; cant = 0;
				}
			}
		}
		return promedio;
	}
}
