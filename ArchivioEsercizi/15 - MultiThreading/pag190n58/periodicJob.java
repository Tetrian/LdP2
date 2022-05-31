/*
	Implementare il metodo statico periodicJob, che accetta un Runnable r
	e un periodo p espresso in millisecondi e fa partire un'esecuzione di
	r ogni p millisecondi. Il metodo periodicJob non deve essere bloccante.
	Esempio d'uso:
		Runnable r = new Runnable() {
			public void run() {
				System.outprintln(“Ciao”);
			}
		};
		periodicJob(r, 2000);

	Risultato: il programma stampa a video “Ciao” ogni 2 secondi.
*/
public static void periodicJob(Runnable r, long p) {
	new Thread() {
		public void run() {
			while(!isInterrupted()) {
				try {
					new Thread(r).start();
					sleep(p);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}.start();
}
