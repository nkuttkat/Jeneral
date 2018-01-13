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
import jeneral.model.map.JeneralTerrain;
import jeneral.model.units.JeneralLandUnit;

/**
 * The Class TestUnitFieldRelation.
 *
 * @author Nils Kuttkat
 */
public class TestUnitFieldRelation extends MainTestClass {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestUnitFieldRelation testUnitFieldRelation = new TestUnitFieldRelation();
        testUnitFieldRelation.printMap();
        testUnitFieldRelation.test();
    }

    /**
     * The unit.
     */
    JeneralLandUnit unit = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 40, 20);

    /**
     * Instantiates a new test unit field relation.
     */
    public TestUnitFieldRelation() {
        super();

        unit.addTerrain(JeneralTerrain.DESERT, 3);
        unit.addTerrain(JeneralTerrain.ROUGH, 3);
    }

    /**
     * Test.
     */
    public void test() {
        // Setzen der Position mit setPosition
        System.out.println();
        System.out.println("Initialer Zustand der Einheit:");
        System.out.println("\t" + unit);
        System.out.println("Setze die Einheit auf Position "
                + map.getField(0, 0)
                + " mit der setPosition-Methode aus AbstractUnit:");
        unit.setPosition(map.getField(0, 0));
        System.out.println("\tZustand der Einheit : " + unit);
        System.out.println("\tZustand des Feldes : "
                + map.getField(0, 0).getUnits());

        System.out.println("Setze nun die Einheit auf Position "
                + map.getField(2, 2)
                + " mit der setPosition-Methode aus AbstractUnit:");
        unit.setPosition(map.getField(2, 2));
        System.out.println("\tZustand der Einheit : " + unit);
        System.out.println("\tZustand des Feldes : "
                + map.getField(2, 2).getUnits());
        System.out.println("\tZustand des bisherigen Feldes : "
                + map.getField(0, 0) + map.getField(0, 0).getUnits());

        // Setzen der Position mit addUnit
        System.out.println();
        System.out.println("Setze die Einheit auf Position "
                + map.getField(4, 6)
                + " mit der addUnit-Methode aus AbstractField:");
        map.getField(4, 6).addUnit(unit);
        System.out.println("\tZustand der Einheit : " + unit);
        System.out.println("\tZustand des Feldes : "
                + map.getField(4, 6).getUnits());
        System.out.println("\tZustand des bisherigen Feldes : "
                + map.getField(2, 2) + map.getField(2, 2).getUnits());
        System.out.println("Setze nun die Einheit auf Position "
                + map.getField(8, 4)
                + " mit der addUnit-Methode aus AbstractField:");
        map.getField(8, 4).addUnit(unit);
        System.out.println("\tZustand der Einheit : " + unit);
        System.out.println("\tZustand des Feldes : "
                + map.getField(8, 4).getUnits());
        System.out.println("\tZustand des bisherigen Feldes : "
                + map.getField(4, 6) + map.getField(4, 6).getUnits());

        // Setzen einer illegalen Position mit setPosition
        System.out.println();
        System.out.println("Setze die Einheit auf die illegale Position "
                + map.getField(5, 3)
                + " mit der setPosition-Methode aus AbstractField:");
        unit.setPosition(map.getField(5, 3));
        System.out.println("\tZustand der Einheit : " + unit);
        System.out.println("\tZustand des Feldes : "
                + map.getField(5, 3).getUnits());
        System.out.println("\tZustand des bisherigen Feldes : "
                + map.getField(8, 4) + map.getField(8, 4).getUnits());

        // Position der Einheit wieder auf null setzen
        System.out.println();
        System.out.println("Setze nun die Einheit auf Position " + null
                + " mit der setPosition-Methode aus AbstractUnit:");
        unit.setPosition(null);
        System.out.println("\tZustand der Einheit : " + unit);
        System.out.println("\tZustand des bisherigen Feldes : "
                + map.getField(8, 4) + map.getField(8, 4).getUnits());
    }

}
