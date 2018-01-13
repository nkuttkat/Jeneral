/* 
 * Copyright (C) 2018 Nils Kuttkat <nkuttkat@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jeneral.model.test;

import abstractgame.unit.MobileUnitRole;
import jeneral.model.units.JeneralAirCarrierUnit;
import jeneral.model.units.JeneralAirUnit;
import jeneral.model.units.JeneralLandCarrierUnit;
import jeneral.model.units.JeneralLandUnit;
import jeneral.model.units.JeneralUnit;
import jeneral.model.units.JeneralWaterUnit;
import jeneral.view.units.BuggyView;
import jeneral.view.units.CruiserView;
import jeneral.view.units.FighterView;
import jeneral.view.units.TankView;
import jeneral.view.units.TruckView;

/**
 * The Class TestEnterCarrier.
 *
 * @author Nils Kuttkat
 */
public class TestEnterCarrier extends MainTestClass {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestEnterCarrier testEnterCarrier = new TestEnterCarrier();
        testEnterCarrier.printMap();
        testEnterCarrier.test();
    }

    /**
     * The jet.
     */
    protected JeneralUnit landCarrier, airCarrier, buggy, tank, jet;

    /**
     * Instantiates a new test enter carrier.
     */
    public TestEnterCarrier() {
        super();
        landCarrier = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 30, 5,
                new JeneralLandCarrierUnit(2));
        airCarrier = new JeneralWaterUnit(game, MobileUnitRole.GetRole(), player, 10, 7,
                new JeneralAirCarrierUnit(5));
        buggy = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 40, 10);
        tank = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 25, 9);
        jet = new JeneralAirUnit(game, MobileUnitRole.GetRole(), player, 10, 20);
        landCarrier.setView(new TruckView());
        airCarrier.setView(new CruiserView());
        buggy.setView(new BuggyView());
        tank.setView(new TankView());
        jet.setView(new FighterView());

    }

    /**
     * Test.
     */
    public void test() {
        landCarrier.setPosition(map.getField(2, 5));
        airCarrier.setPosition(map.getField(2, 4));
        buggy.setPosition(map.getField(4, 5));
        tank.setPosition(map.getField(1, 5));
        jet.setPosition(map.getField(2, 4));

        System.out.println("Carrier: " + landCarrier);
        System.out.println("Carrier1: " + airCarrier);
        System.out.println("Unit1: " + buggy);
        System.out.println("Unit2: " + tank);
        System.out.println("AirUnit: " + jet);

        // Test 1 (fahre Tank in den Träger)
        System.out.println();
        System.out.println("Test 1 (fahre Tank in den Träger):");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tank.enterCarrier(landCarrier);
        System.out.println("\tCarrier: " + landCarrier + "->"
                + landCarrier.getCarrierUnit().getUnits());
        System.out.println("\tTank: " + tank);

        // Test 2 (fahre Buggy in den Träger)
        System.out.println();
        System.out.println("Test 2 (fahre Buggy in den Träger):");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buggy.enterCarrier(landCarrier);
        System.out.println("\tCarrier: " + landCarrier + "->"
                + landCarrier.getCarrierUnit().getUnits());
        System.out.println("\tBuggy: " + buggy);
        System.out
                .println("Die Aktion misslingt, da sich die Einheit nicht in "
                        + "einem benachbarten Feld befindet.");

        // Test 3 (fliege AirUnit in den Träger)
        System.out.println();
        System.out.println("Test 3 (fliege Jet in den Träger):");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jet.enterCarrier(landCarrier);
        System.out.println("\tCarrier: " + landCarrier + "->"
                + landCarrier.getCarrierUnit().getUnits());
        System.out.println("\tAirUnit: " + jet);
        System.out.println("Die Aktion misslingt, da der Träger keine "
                + "Lufteinheiten aufnehmen kann.");

        // Test 4 (fliege AirUnit in den Träger1)
        System.out.println();
        System.out.println("Test 4 (fliege AirUnit in den Träger1):");
        jet.enterCarrier(airCarrier);
        System.out.println("\tCarrier1: " + airCarrier + "->"
                + airCarrier.getCarrierUnit().getUnits());
        System.out.println("\tAirUnit: " + jet);

        // Test 5 (Versuch des Trägers sich selbst aufzunehmen)
        System.out.println();
        System.out
                .println("Test 5 (Versuch des Trägers sich selbst aufzunehmen):");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        landCarrier.enterCarrier(landCarrier);
        System.out.println("\tCarrier: " + landCarrier + "->"
                + landCarrier.getCarrierUnit().getUnits());
        System.out.println("\tCarrier: " + landCarrier);
        System.out.println("Die Aktion misslingt, da der Träger sich nicht "
                + "selbst aufnehmen kann.");
    }
}
