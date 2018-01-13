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

/**
 * The Class TestUnitMoveInDirection.
 *
 * @author Nils Kuttkat
 */
public class TestUnitMoveInDirection extends TestUnitMovement {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestUnitMoveInDirection testUnitMoveInDirection = new TestUnitMoveInDirection();
        testUnitMoveInDirection.printMap();
        testUnitMoveInDirection.test();
    }

    /**
     * Instantiates a new test unit move in direction.
     */
    public TestUnitMoveInDirection() {
        super();
    }

    /* (non-Javadoc)
	 * @see jeneral.model.test.TestLandUnitMovement#test()
     */
    protected void test() {
        // Test 5 (bewege die Einheit mittels der moveForward-Methode über ein
        // paar Felder)
        System.out.println();
        truck.setPosition(map.getField(1, 2));

        System.out.println("Bewege die Einheit mittels der "
                + "moveForward-Methode über ein paar Felder");
        System.out.println("\t" + truck);
        truck.setDirection(0);
        truck.moveForward();

        System.out.println("\t" + truck);
        System.out.println("\tVersuche die Einheit in das Wasser zu bewegen:");
        truck.moveForward();

        System.out.println("\t" + truck);
        truck.setDirection(2);
        truck.moveForward();

        System.out.println("\t" + truck);

        // Test 6 (bewege die Einheit mit der moveForward-Methode auf ein
        // bereits besetztes Feld)
        buggy.setPosition(map.getField(4, 6));

        truck.setPosition(map.getField(3, 5));

        System.out.println();
        System.out.println("Bewege die Einheit mit der "
                + "moveForward-Method auf ein bereits besetztes Feld");
        truck.setDirection(1);
        truck.moveForward();
        System.out.println("\t" + truck);
        System.out.println("\t" + buggy);

        System.out.println("Bewege nun " + truck + " mit der "
                + "setPosition-Methode auf das besetzte Feld "
                + map.getField(4, 6));
        truck.setPosition(buggy.getPosition());
        System.out.println("\t" + truck);
        System.out.println("\t" + buggy);

        // Test 7 (bewege die Einheit mit der moveTo-Method auf ein zu weit entferntes Feld)
        System.out.println();
        System.out.println("Bewege die Einheit mit der "
                + "moveTo-Methode auf ein zu weit entferntes Feld");
        truck.setCurrentMovementPoints(20);
        truck.moveTo(map.getField(5, 7));
        System.out.println("\t" + truck);

        truck.setPosition(map.getField(3, 5));
        truck.setCurrentMovementPoints(20);
        buggy.setPlayer(player);
        truck.moveTo(map.getField(5, 7));
        System.out.println("\t" + truck);

        truck.setCurrentMovementPoints(30);
        buggy.setPlayer(player1);
        truck.moveTo(map.getField(3, 3));
        System.out.println("\t" + truck);

        truck.setPosition(map.getField(5, 7));
        truck.setCurrentMovementPoints(30);
        buggy.setPosition(map.getField(0, 4));
        truck.moveTo(map.getField(3, 3));
        System.out.println("\t" + truck);

        truck.setPosition(map.getField(5, 7));
        truck.setCurrentMovementPoints(30);
        buggy.setPlayer(player);
        truck.moveTo(map.getField(3, 3));
        System.out.println("\t" + truck);
    }

}
