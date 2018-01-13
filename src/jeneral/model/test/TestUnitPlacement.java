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
 * The Class TestUnitPlacement.
 *
 * @author Nils Kuttkat
 */
public class TestUnitPlacement extends TestUnitMovement {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestUnitPlacement testUnitPlacement = new TestUnitPlacement();
        testUnitPlacement.printMap();
        testUnitPlacement.test();
    }

    /**
     * Instantiates a new test unit placement.
     */
    public TestUnitPlacement() {
        super();
    }

    /* (non-Javadoc)
	 * @see jeneral.model.test.TestLandUnitMovement#test()
     */
    protected void test() {
        // Test 1 (Versuch die Einheit an eine illegale Position zu setzen)
        System.out.println();
        System.out.println("Test 1 (Versuch die Einheit an eine illegale "
                + "Position zu setzen):");
        System.out.println("\tInitialer Zustand: " + truck);
        System.out.println("\tSetze die Einheit " + truck
                + " mit der setPosition-Methode aus Unit auf das Feld "
                + map.getField(4, 4));
        truck.setPosition(map.getField(4, 4));
        System.out.println("\tZustand nach dem Versuch: " + truck);
        if (map.getField(7, 7).equals(truck.getPosition())) {
            System.out.println("FEHLER !!!!!!!!!");
        }

        // Test 2 (Versuch die Einheit an eine legale Position zu setzen)
        System.out.println();
        System.out.println("Test 2 (Versuch die Einheit an eine legale "
                + "Position zu setzen):");
        System.out.println("\tInitialer Zustand: " + truck);
        System.out.println("\tSetze die Einheit " + truck
                + " mit der setPosition-Methode aus Unit auf das Feld "
                + map.getField(7, 3));
        truck.setPosition(map.getField(7, 3));
        System.out.println("\tZustand nach dem Versuch: " + truck);
        if (!map.getField(7, 3).equals(truck.getPosition())) {
            System.out.println("FEHLER !!!!!!!!!");
        }
    }
}
