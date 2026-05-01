public class CoffeeMaker {
//    private EspressoMachine espressoMachine;
//    private DripCoffeeMachine dripCoffeeMachine;
    private CoffeeMachine coffeeMachine;

    public CoffeeMaker() {
//        this.espressoMachine = new EspressoMachine();
//        this.dripCoffeeMachine = new DripCoffeeMachine();
    }

    public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void makeCoffee() {
//        System.out.println(espressoMachine.brew());
//        System.out.println(dripCoffeeMachine.brew());
        System.out.println(coffeeMachine.brew());
    }
}
