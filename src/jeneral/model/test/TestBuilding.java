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

import abstractgame.unit.ImmobileUnitRole;
import jeneral.model.map.JeneralTerrain;
import jeneral.model.units.JeneralBuilding;

/**
 * The Class TestBuilding.
 *
 * @author Nils Kuttkat
 */
public class TestBuilding extends MainTestClass {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestBuilding testBuilding = new TestBuilding();
        testBuilding.printMap();
        testBuilding.test();
    }

    /**
     * The b3.
     */
    JeneralBuilding b, b1, b2, b3;

    /**
     * Instantiates a new test building.
     */
    public TestBuilding() {
        super();
        b = new JeneralBuilding(game, ImmobileUnitRole.GetRole(), player1, 1000);
        b1 = new JeneralBuilding(game, ImmobileUnitRole.GetRole(), player1, 500);
        b2 = new JeneralBuilding(game, ImmobileUnitRole.GetRole(), player1, 300);
        b3 = new JeneralBuilding(game, ImmobileUnitRole.GetRole(), player1, 100);
        b.addTerrain(JeneralTerrain.PLAIN);
        b1.addTerrain(JeneralTerrain.PLAIN);
        b2.addTerrain(JeneralTerrain.PLAIN);
        b3.addTerrain(JeneralTerrain.PLAIN);
    }

    /**
     * Test.
     */
    public void test() {
        b.setPosition(map.getField(4, 9));
        b1.setPosition(map.getField(4, 8));
        b2.setPosition(map.getField(4, 7));
        b3.setPosition(map.getField(4, 6));
        b.addPart(b1);
        b.addPart(b2);
        b.addPart(b3);

        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
