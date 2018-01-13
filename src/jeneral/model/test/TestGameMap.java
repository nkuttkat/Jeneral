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
import jeneral.model.units.*;

/**
 * The Class TestGameMap.
 *
 * @author Nils Kuttkat
 */
public class TestGameMap extends MainTestClass {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestGameMap testGameMap = new TestGameMap();
        testGameMap.printMap();
        testGameMap.test();
    }

    /**
     * The au1.
     */
    protected JeneralAirUnit au, au1;

    /**
     * The lu1.
     */
    protected JeneralLandUnit lu, lu1;

    /**
     * The wu.
     */
    protected JeneralWaterUnit wu;

    /**
     * Instantiates a new test game map.
     */
    public TestGameMap() {
        super();
        lu = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 20, 50, new JeneralGroundWeapon(
                25, 1));
        lu1 = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player1, 20, 35,
                new JeneralGroundWeapon(15, 2));
        wu = new JeneralWaterUnit(game, MobileUnitRole.GetRole(), player1, 20, 70,
                new JeneralGroundWeapon(25, 2));
        au = new JeneralAirUnit(game, MobileUnitRole.GetRole(), player, 20, 40, new JeneralAirWeapon(15,
                3));
        au1 = new JeneralAirUnit(game, MobileUnitRole.GetRole(), player, 20, 40, new JeneralAirWeapon(20,
                2));
    }

    /**
     * Test.
     */
    public void test() {
        // versuche die Einheiten trotz ungültiger Position(null) zu bewegen
        System.out
                .println("Versuche eine Einheit trotz ungültiger Position(null) zu bewegen:");
        System.out.println("\tAirUnit: " + au + " " + au.getDirection());
        au.moveForward();
        au.turnLeft();
        au.turnRight();
        System.out.println("\tAirUnit nach Versuch: " + au + " "
                + au.getDirection());

        // setze die Einheiten auf das Spielfeld (auf gültige Felder)
        lu.setPosition(map.getField(0, 0));
        lu1.setPosition(map.getField(5, 3));
        wu.setPosition(map.getField(5, 5));
        au.setPosition(map.getField(0, 0));
        au1.setPosition(map.getField(4, 3));

        System.out.println("Initiale Positionen:");
        System.out.println("\tWaterUnit: " + wu);
        System.out.println("\tLandUnit: " + lu);
        System.out.println("\tLandUnit1: " + lu1);
        System.out.println("\tAirUnit1: " + au);
        System.out.println("\tAirUnit2: " + au1);

        // teste WaterUnit
        System.out.println("Versuche die Wassereinheit auf ein Landfeld "
                + map.getField(4, 5) + " zu bewegen:");
        System.out.println("\tWaterUnit vor dem Versuch: " + wu);
        wu.turnLeft();
        wu.moveForward();
        System.out.println("\tWaterUnit nach dem Versuch: " + wu);

        // teste LandUnit
        System.out.println("Versuche die Landeinheit1 auf ein Gebirgsfeld "
                + map.getField(5, 4) + " zu bewegen:");
        System.out.println("\tLandUnit1 vor dem Versuch: " + lu1);
        lu1.moveForward();
        System.out.println("\tLandUnit1 nach dem Versuch: " + lu1);

        // teste AirUnit
        System.out
                .println("Versuche die Lufteinheit1 über ein Landfeld und ein Gebirgsfeld auf ein Wasserfeld "
                        + map.getField(6, 5) + " zu bewegen:");
        System.out.println("\tAirUnit2: " + au1);
        au1.turnRight();
        au1.turnRight();
        au1.moveForward();
        System.out.println("\tAirUnit2: " + au1);
        au1.turnLeft();
        au1.turnLeft();
        au1.moveForward();
        System.out.println("\tAirUnit2: " + au1);
        au1.turnRight();
        au1.moveForward();
        System.out.println("\tAirUnit2: " + au1);
    }
}
