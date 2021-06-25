package tp03.ejercicio1;

public class Test_RedBinaria {
	public static void main (String [] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer> (new Integer(5));
		ArbolBinario<Integer> hi = new ArbolBinario<Integer> (new Integer(7));
		ArbolBinario<Integer> hd = new ArbolBinario<Integer> (new Integer(2));
		
		
		
		RedBinariaLlena red = new RedBinariaLlena(ab);
		
		System.out.print(red.retardoReenvio());
	}
}
