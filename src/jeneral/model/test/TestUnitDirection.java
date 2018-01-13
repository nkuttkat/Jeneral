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
 * The Class TestUnitDirection.
 *
 * @author Nils Kuttkat
 */
public class TestUnitDirection extends TestUnitMovement {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestUnitDirection testUnitDirection = new TestUnitDirection();
        testUnitDirection.printMap();
        testUnitDirection.test();
    }

    /**
     * Instantiates a new test unit direction.
     */
    public TestUnitDirection() {
        super();
    }

    /* (non-Javadoc)
	 * @see jeneral.model.test.TestLandUnitMovement#test()
     */
    protected void test() {
        truck.setPosition(map.getField(7, 3));

        // Test 3 (drehe die Einheit einmal rechts herum um die eigene Achse)
        System.out.println();
        System.out
                .println("Test 3 (drehe die Einheit mittels der turnRight-Methode "
                        + "aus AbstractUnit einmal rechts herum um die eigene "
                        + "Achse)");
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnRight();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnRight();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnRight();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnRight();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnRight();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnRight();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnRight();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnRight();
        System.out.println("\t" + truck + "->" + truck.getDirection());

        // Test 4 (drehe die Einheit einmal links herum um die eigene Achse)
        System.out.println();
        System.out
                .println("Test 4 (drehe die Einheit mittels der turnLeft-Methode "
                        + "aus AbstractUnit einmal links herum um die eigene "
                        + "Achse)");
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnLeft();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnLeft();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnLeft();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnLeft();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnLeft();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnLeft();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnLeft();
        System.out.println("\t" + truck + "->" + truck.getDirection());
        truck.turnLeft();
        System.out.println("\t" + truck + "->" + truck.getDirection());
    }

}
