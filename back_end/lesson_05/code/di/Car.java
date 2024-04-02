package lesson_05.code.di;

public class Car {

    EngineGeneral engineGeneral;
    Carcas carcas;
    Transmission transmission;

    public Car(EngineGeneral engineGeneral, Carcas carcas, Transmission transmission) {
        this.engineGeneral = engineGeneral;
        this.carcas = carcas;
        this.transmission = transmission;
    }
}
