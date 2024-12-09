package com.solvd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Laptop {

    MACBOOK("M4 PRO", 5000, Battery.LOW_POWER),
    LENOVO("Super laptop", 4000, Battery.HIGH_POWER);

    private String name;
    private int price;
    private Battery battery;

    public void checkTheBattery() {
        if (this.battery == Battery.LOW_POWER) {
            System.out.println("Battery LOW_POWER");
        } else if (this.battery == Battery.HIGH_POWER) {
            System.out.println("Battery HIGH_POWER");
        } else {
            System.out.println("Battery MEDIUM_POWER");
        }
    }
}
