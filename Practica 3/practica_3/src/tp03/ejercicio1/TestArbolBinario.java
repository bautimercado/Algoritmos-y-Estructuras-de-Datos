package tp03.ejercicio1;

public class TestArbolBinario {

	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(new Integer (10));
		ArbolBinario<Integer> hi = new ArbolBinario<Integer>(new Integer (25));
		ArbolBinario<Integer> hd = new ArbolBinario<Integer>(new Integer (40));
		
		hi.agregarHijoIzquierdo(new ArbolBinario<Integer> (15));
		hi.agregarHijoDerecho(new ArbolBinario<Integer> (87));
		
		hd.agregarHijoIzquierdo(new ArbolBinario<Integer> (50));
		hd.agregarHijoDerecho(new ArbolBinario<Integer> (70));
		
		a.agregarHijoIzquierdo(hi);
		a.agregarHijoDerecho(hd);
		
		System.out.print(a.esLleno());
	}

}
