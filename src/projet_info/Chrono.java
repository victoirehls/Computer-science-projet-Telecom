package projet_info;

// Le chrono permet de repeindre l'image régulièrement si changements il y a 

public class Chrono implements Runnable{
	private final int Pause = 100;
	public void run() {
		while(true) { //boucle infinie qui a chaque tour repeint la scene
			Fenetre.scene.repaint(); //on fait appel à la repainte de l'écran
			try {
				Thread.sleep(Pause); //thread c'est le flux
			}catch (InterruptedException e) {}
		}
	}
}
