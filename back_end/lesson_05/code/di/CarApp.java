package lesson_05.code.di;

public class CarApp {
    public static void main(String[] args) {

        /*
        DI / IoC

        bean
         */

        EngineGeneral ourEngine = new EngineDiesel();
        Carcas carcas = new Carcas();
        Transmission transmission = new Transmission();

        Car myCar = new Car(ourEngine, carcas, transmission);
        myCar.engineGeneral.start();

    }
}
