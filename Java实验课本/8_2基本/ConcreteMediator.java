package com.example;

public class ConcreteMediator { // 中介者模式中的具体中介者
    private RentHouse[] rentHouse;
    private BegRentHouse[] begRentHouse;

    public void registerRentHouse(RentHouse[] rentHouse) {
        this.rentHouse = rentHouse;
    }

    public void registerBegRentHouse(BegRentHouse[] begRentHouse) {
        this.begRentHouse = begRentHouse;
    }

    public void deliverMess(Colleague colleague, String mess) {
        if (colleague instanceof RentHouse) {
            for (BegRentHouse aBegRentHouse : begRentHouse) {
                aBegRentHouse.receiverMess(colleague.getName() + mess);
            }
        } else if (colleague instanceof BegRentHouse) {
            for (RentHouse aRentHouse : rentHouse) {
                aRentHouse.receiverMess(colleague.getName() + mess);
            }
        }
    }
}
