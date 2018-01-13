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

import jeneral.model.map.JeneralTerrain;
import jeneral.model.units.JeneralUnit;

/**
 * The Class TestFight.
 *
 * @author Nils Kuttkat
 */
public class TestFight extends MainTestClass {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestFight testFight = new TestFight();
        testFight.printMap();
        testFight.test();
    }

    /**
     * The air unit.
     */
    JeneralUnit flakUnit, tankUnit, airUnit;

    /**
     * Instantiates a new test fight.
     */
    public TestFight() {
        super();
        flakUnit = new AirDefense(game, player);
        tankUnit = new Tank(game, player);
        airUnit = new Fighter(game, player);
        flakUnit.addTerrain(JeneralTerrain.PLAIN, 1);
        flakUnit.addTerrain(JeneralTerrain.DESERT, 2);
        tankUnit.addTerrain(JeneralTerrain.PLAIN, 1);
        tankUnit.addTerrain(JeneralTerrain.DESERT, 2);
    }

    /**
     * Test.
     */
    public void test() {
        flakUnit.setPosition(map.getField(4, 2));
        tankUnit.setPosition(map.getField(4, 3));
        airUnit.setPosition(map.getField(5, 5));

        System.out.println();
        System.out.println("FlakUnit: " + flakUnit);
        System.out.println("TankUnit: " + tankUnit);
        System.out.println("AirUnit: " + airUnit);

        // Test 1
        System.out.println();
        System.out.println("FlakUnit versucht die AirUnit anzugreifen: ");
        flakUnit.attack(airUnit);
        System.out.println("FlakUnit: " + flakUnit);
        System.out.println("AirUnit: " + airUnit);
        System.out
                .println("Die Aktion misslingt, da sich die AirUnit außerhalb der"
                        + " Waffenreichweite befindet.");

        // Test 2
        System.out.println();
        System.out.println("TankUnit versucht die FlakUnit anzugreifen: ");
        tankUnit.attack(flakUnit);
        System.out.println("TankUnit: " + tankUnit);
        System.out.println("FlakUnit: " + flakUnit);
        System.out
                .println("Die Aktion gelingt, da sich die FlakUnit innerhalb der"
                        + " Waffenreichweite befindet und die TankUnit GroundUnits angreifen "
                        + "kann.");

        // Test 3
        System.out.println();
        System.out
                .println("Bewege die FlakUnit um in Reichweite der AirUnit zu kommen "
                        + "und greife die AirUnit an: ");
        flakUnit.turnRight();
        flakUnit.moveForward();
        flakUnit.attack(airUnit);
        System.out.println("FlakUnit: " + flakUnit);
        System.out.println("AirUnit: " + airUnit);
        System.out
                .println("Die Aktion gelingt, da sich die AirUnit innerhalb der"
                        + " Waffenreichweite befindet und die FlakUnit AirUnits angreifen "
                        + "kann.");

        // Test 4
        System.out.println();
        System.out.println("AirUnit versucht die TankUnit anzugreifen: ");
        airUnit.attack(tankUnit);
        System.out.println("AirUnit: " + airUnit);
        System.out.println("TankUnit: " + tankUnit);
        System.out
                .println("Die Aktion gelingt, da sich die TankUnit innerhalb der"
                        + " Waffenreichweite befindet und die AirUnit GroundUnits angreifen "
                        + "kann.");

        // Test 5
        System.out.println();
        System.out.println("FlakUnit greift die AirUnit an: ");
        flakUnit.attack(airUnit);
        System.out.println("FlakUnit: " + flakUnit);
        System.out.println("AirUnit: " + airUnit);
        System.out.println("Die Aktion zerstört die AirUnit.");
    }
}
