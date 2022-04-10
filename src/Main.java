import com.ifpe.ppro.observer.ObserverTest;
import com.ifpe.ppro.strategy.StrategyTest;
import view.MainWindow;

public class Main {

    public static void main(String[] args) {

       //new MainWindow();

        /**
         * tests
         */
        //StrategyTest.strategyDuckPlay();
        //StrategyTest.strategySortPlay();
        //ObserverTest.onwObserverTimerTest();

        ObserverTest.ownObserverApp();
       // mainWindow.createWindow();

//        ObservableImpl observable = new ObservableImpl();
//
//        observable.registerObserver(new Observer() {
//            @Override
//            public void onUpdate(Observable observable) {
//                ObservableImpl ons = (ObservableImpl) observable;
//
//                System.out.println(ons.getConteudo());
//                System.out.println("fui notificado");
//            }
//        });
//
//        observable.registerObserver(new Observer() {
//            @Override
//            public void onUpdate(Observable observable) {
//                System.out.println("eita, eu sou um novo observer e fui notificado");
//            }
//        });
//
//
//        observable.notifyObservers(observable);
//
//        observable.setConteudo("meu conteudo mudou ");
//        observable.setConteudo("meu conteudo mudou mais uma vez");

    }
}
