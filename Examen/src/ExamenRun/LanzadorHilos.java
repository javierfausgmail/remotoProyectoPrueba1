package ExamenRun;



public class LanzadorHilos extends Thread {
	public LanzadorHilos(String nombre)
	{
		super(nombre);
		
	}
	


	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+": Hola soy main!!");
		long dormir =0;

		LanzadorHilos[] arrayHilos = new LanzadorHilos[5];

		for(int i=0; i<arrayHilos.length; i++)
		{	
		 dormir=dormir+100;
		LanzadorHilos hilo=new LanzadorHilos("Hilo "+(i+1));	
		arrayHilos[i]=hilo;	
		LanzadorHilos.sleep(dormir);
		hilo.start();
		}

		for(int i=0; i<arrayHilos.length; i++)
		{
			try {
				arrayHilos[i].join();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
			
			
		
		System.out.println(Thread.currentThread().getName()+": main se despide.!!");



	}
	
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+": Hola!");
	}

}


