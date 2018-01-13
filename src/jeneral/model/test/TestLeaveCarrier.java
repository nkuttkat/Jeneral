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
import jeneral.model.map.JeneralGameField;
import jeneral.model.units.JeneralAirCarrierUnit;
import jeneral.model.units.JeneralAirUnit;
import jeneral.model.units.JeneralLandCarrierUnit;
import jeneral.model.units.JeneralLandUnit;
import jeneral.model.units.JeneralUnit;
import jeneral.model.units.JeneralWaterUnit;

/**
 * The Class TestLeaveCarrier.
 *
 * @author Nils Kuttkat
 */
public class TestLeaveCarrier extends TestEnterCarrier {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestLeaveCarrier testLeaveCarrier = new TestLeaveCarrier();
        testLeaveCarrier.printMap();
        testLeaveCarrier.test();
    }

    /**
     * The air unit.
     */
    JeneralUnit carrier, carrier1, unit1, unit2, airUnit;

    /**
     * Instantiates a new test leave carrier.
     */
    public TestLeaveCarrier() {
        super();
        carrier = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 30, 5,
                new JeneralLandCarrierUnit(1));
        carrier1 = new JeneralWaterUnit(game, MobileUnitRole.GetRole(), player, 10, 7,
                new JeneralAirCarrierUnit(5));
        unit1 = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 40, 10);
        unit2 = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 25, 9);
        airUnit = new JeneralAirUnit(game, MobileUnitRole.GetRole(), player, 10, 20);
    }

    /* (non-Javadoc)
	 * @see jeneral.model.test.TestEnterCarrier#test()
     */
    public void test() { // TODO test wieder gangbar machen!!
        super.test();
        carrier.setPosition(map.getField(4, 3));
        carrier1.setPosition(map.getField(5, 5));
        unit1.setPosition(map.getField(2, 1));
        unit2.setPosition(map.getField(3, 3));
        airUnit.setPosition(map.getField(4, 4));

        unit2.enterCarrier(carrier);
        airUnit.enterCarrier(carrier1);

        System.out.println("Carrier: " + carrier + "->"
                + carrier.getCarrierUnit().getUnits());
        System.out.println("Carrier1: " + carrier1 + "->"
                + carrier1.getCarrierUnit().getUnits());
        System.out.println("Unit1: " + unit1);
        System.out.println("Unit2: " + unit2);
        System.out.println("AirUnit: " + airUnit);

        // Test 1
        System.out.println();
        System.out
                .println("Versuch Unit2 auf die Position des Trägers zu entlassen:");
        carrier.releaseUnit(unit2, ((JeneralGameField) carrier.getPosition()));
        System.out.println("Carrier: " + carrier + "->"
                + carrier.getCarrierUnit().getUnits());
        System.out.println("Unit2: " + unit2);
        System.out
                .println("Die Aktion misslingt, da sich nicht zwei LandUnits "
                        + "auf einem Feld befinden dürfen !");
        System.out.println();

        // Test 2
        System.out
                .println("Versuch Unit2 auf die Position (4/4 MOUNTAIN) zu entlassen:");
        carrier.releaseUnit(unit2, (JeneralGameField) map.getField(4, 4));
        System.out.println("Carrier: " + carrier + "->"
                + carrier.getCarrierUnit().getUnits());
        System.out.println("Unit2: " + unit2);
        System.out
                .println("Die Aktion misslingt, da sich die LandUnit nicht auf "
                        + "einem Feld mit dem Terrain MOUNTAIN befinden darf !");

        // Test 3
        System.out.println();
        System.out
                .println("Versuch Unit2 auf die Position (4/1 PLAIN) zu entlassen:");
        carrier.releaseUnit(unit2, (JeneralGameField) map.getField(4, 1));
        System.out.println("Carrier: " + carrier + "->"
                + carrier.getCarrierUnit().getUnits());
        System.out.println("Unit2: " + unit2);
        System.out.println("Die Aktion misslingt, da die LandUnit nur auf ein "
                + "benachbartes Feld entlassen werden kann !");

        // Test 3
        System.out.println();
        System.out
                .println("Versuch Unit2 auf die Position (5/3 PLAIN) zu entlassen:");
        carrier.releaseUnit(unit2, (JeneralGameField) map.getField(5, 3));
        System.out.println("Carrier: " + carrier + "->"
                + carrier.getCarrierUnit().getUnits());
        System.out.println("Unit2: " + unit2);
        System.out
                .println("Die Aktion gelingt, da das Zielfeld ein Nachbarfeld ist "
                        + "und die Einheit das Feld auch betreten kann !");

        // Test 4
        System.out.println();
        System.out
                .println("Versuch AirUnit auf die Position (5/5 Water) zu entlassen:");
        carrier1.releaseUnit(airUnit, (JeneralGameField) map.getField(5, 5));
        System.out.println("Carrier1: " + carrier1 + "->"
                + carrier1.getCarrierUnit().getUnits());
        System.out.println("AirUnit: " + airUnit);
        System.out
                .println("Die Aktion gelingt, da sich eine AirUnit und eine GroundUnit"
                        + " auf einem Feld befinden dürfen !");
    }

}
