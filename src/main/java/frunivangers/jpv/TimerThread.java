package frunivangers.jpv;

public class TimerThread extends Thread {

    private Partie partie;
    private boolean stop = false;


    public TimerThread(Partie partie) {
        this.partie = partie;
    }

    void setStop(){
        this.stop = true;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Fin temps");
            if(this.stop){
                partie.endGame("Temps écoulé !");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
