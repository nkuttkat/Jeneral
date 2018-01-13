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

import jeneral.model.units.JeneralAirUnit;
import jeneral.model.units.JeneralLandUnit;
import jeneral.model.units.JeneralWaterUnit;
import abstractgame.unit.AbstractUnit;
import abstractgame.unit.MobileUnitRole;

/**
 * The Class TestUnitPlayerRelation.
 *
 * @author Nils Kuttkat
 */
public class TestUnitPlayerRelation extends MainTestClass {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestUnitPlayerRelation testUnitPlayerRelation = new TestUnitPlayerRelation();
        testUnitPlayerRelation.printMap();
        testUnitPlayerRelation.test();
    }

    /**
     * The unit.
     */
    AbstractUnit unit = new JeneralAirUnit(game, MobileUnitRole.GetRole(), player, 50, 20);

    /**
     * The unit1.
     */
    AbstractUnit unit1 = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 50, 10);

    /**
     * The unit2.
     */
    AbstractUnit unit2 = new JeneralWaterUnit(game, MobileUnitRole.GetRole(), null, 50, 8);

    /**
     * Instantiates a new test unit player relation.
     */
    public TestUnitPlayerRelation() {
        super();

    }

    /**
     * Test.
     */
    public void test() {
        // Test 1 (Entfernen einer Einheit mit der setPlayer-Methode aus
        // AbstractUnit)
        System.out.println("Test 1 (Entfernen einer Einheit mit der "
                + "setPlayer-Methode aus AbstractUnit):");
        System.out.println("\tZustand der Einheit: " + unit + "->"
                + unit.getPlayer());
        System.out.println("\tZustand des Spielers: " + player + "->"
                + player.getUnits());
        System.out.println("\tEntferne Einheit " + unit);
        unit.setPlayer(null);
        System.out.println("\tZustand der Einheit: " + unit + "->"
                + unit.getPlayer());
        System.out.println("\tZustand des Spielers: " + player + "->"
                + player.getUnits());

        // Test 2 (Entfernen einer Einheit mit der removeUnit-Methode aus
        // AbstractPlayer)
        System.out.println();
        System.out.println("Test 2 (Entfernen einer Einheit mit der "
                + "removeUnit-Methode aus AbstractPlayer):");
        System.out.println("\tZustand der Einheit: " + unit1 + "->"
                + unit1.getPlayer());
        System.out.println("\tZustand des Spielers: " + player + "->"
                + player.getUnits());
        System.out.println("\tEntferne Einheit " + unit1);
        player.removeUnit(unit1);
        System.out.println("\tZustand der Einheit: " + unit1 + "->"
                + unit1.getPlayer());
        System.out.println("\tZustand des Spielers: " + player + "->"
                + player.getUnits());

        // Test 3 (Hinzufügen einer Einheit mit der setPlayer-Methode aus
        // AbstractUnit)
        System.out.println();
        System.out.println("Test 3 (Hinzufügen einer Einheit mit der "
                + "setPlayer-Methode aus AbstractUnit):");
        System.out.println("\tZustand der Einheit: " + unit2 + "->"
                + unit2.getPlayer());
        System.out.println("\tZustand des Spielers: " + player + "->"
                + player.getUnits());
        System.out.println("\tFüge Einheit hinzu " + unit2);
        unit2.setPlayer(player);
        System.out.println("\tZustand der Einheit: " + unit2 + "->"
                + unit2.getPlayer());
        System.out.println("\tZustand des Spielers: " + player + "->"
                + player.getUnits());

        // Test 4 (Hinzufügen einer Einheit mit der setPlayer-Methode aus
        // AbstractUnit)
        System.out.println();
        System.out.println("Test 4 (Hinzufügen einer Einheit mit der "
                + "addUnit-Methode aus AbstractPlayer):");
        System.out.println("\tZustand der Einheit: " + unit1 + "->"
                + unit1.getPlayer());
        System.out.println("\tZustand des Spielers: " + player + "->"
                + player.getUnits());
        System.out.println("\tFüge Einheit hinzu " + unit1);
        player.addUnit(unit1);
        System.out.println("\tZustand der Einheit: " + unit1 + "->"
                + unit1.getPlayer());
        System.out.println("\tZustand des Spielers: " + player + "->"
                + player.getUnits());
    }

}
