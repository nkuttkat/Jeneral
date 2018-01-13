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

import jeneral.model.map.JeneralGameField;
import jeneral.model.map.JeneralTerrain;

/**
 * The Class TestFieldMapRelation.
 *
 * @author Nils Kuttkat
 */
public class TestFieldMapRelation extends MainTestClass {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestFieldMapRelation testFieldMapRelation = new TestFieldMapRelation();
        testFieldMapRelation.printMap();
        testFieldMapRelation.test();
    }

    /**
     * The predecessor.
     */
    JeneralGameField f1, f2, f3, predecessor;

    /**
     * Instantiates a new test field map relation.
     */
    public TestFieldMapRelation() {
        super();
        f1 = new JeneralGameField(JeneralTerrain.WATER);
        f2 = new JeneralGameField(JeneralTerrain.MOUNTAIN);
        f3 = new JeneralGameField(JeneralTerrain.DESERT);
    }

    /**
     * Test.
     */
    public void test() {
        System.out.println("Test der bidirektionalen Beziehung zwischen "
                + "AbstractField und AbstractMap");
        System.out.println();
        // Test 1 (setPosition)
        System.out.println("Test 1 (setPosition):");
        predecessor = (JeneralGameField) map.getField(7, 5);
        System.out.println("\tZustand von " + f1 + " : " + f1 + "->"
                + f1.getMap());
        System.out.println("\tVorgänger an der Stelle (7,5): " + predecessor
                + "->" + predecessor.getMap());
        System.out.println("\tZustand der Karte an der Stelle (7,5):"
                + map.getField(7, 5));
        System.out.println("\tSetze Feld " + f1
                + " mit der setPosition-Methode"
                + " aus AbstractField an die Position (7,5):");
        f1.setPosition(7, 5, map);
        System.out.println("\tZustand von " + f1 + " : " + f1 + "->"
                + f1.getMap());
        System.out.println("\tZustand der Karte an der Stelle (7,5):"
                + map.getField(7, 5));
        System.out.println("\tVorgänger an der Stelle (7,5): " + predecessor
                + "->" + predecessor.getMap());
        System.out.println();

        // Test 2 (setField)
        System.out.println("Test 2 (setField):");
        predecessor = (JeneralGameField) map.getField(6, 2);
        System.out.println("\tZustand von " + f2 + " : " + f2 + "->"
                + f2.getMap());
        System.out.println("\tVorgänger an der Stelle (6,2): " + predecessor
                + "->" + predecessor.getMap());
        System.out.println("\tZustand der Karte an der Stelle (6,2):"
                + map.getField(6, 2));
        System.out.println("\tSetze Feld " + f2 + " mit der setField-Methode"
                + " aus AbstractMap an die Position (6,2):");
        map.setField(6, 2, f2);
        System.out.println("\tZustand von " + f2 + " : " + f2 + "->"
                + f2.getMap());
        System.out.println("\tZustand der Karte an der Stelle (6,2):"
                + map.getField(6, 2));
        System.out.println("\tVorgänger an der Stelle (6,2): " + predecessor
                + "->" + predecessor.getMap());
        System.out.println();

        // Test 3 (setzten eines neuen Feldes an eine illegale Position)
        System.out.println("Test 3 (setzten eines neuen Feldes an "
                + "eine illegale Position):");
        System.out.println("\tZustand von " + f3 + " : " + f3 + "->"
                + f3.getMap());
        System.out.println("\tSetze Feld " + f3
                + " mit der setPosition-Methode"
                + " aus AbstractField an die illegale Position (20,20):");
        f3.setPosition(20, 20, map);
        System.out.println("\tZustand von " + f3 + " : " + f3 + "->"
                + f3.getMap());
        System.out.println();

        // Test 4 (umsetzen eines platzierten Feldes an eine illegale Position)
        System.out.println("Test 4 (umsetzen eines platzierten Feldes an "
                + "eine illegale Position):");
        System.out.println("\tZustand von " + f1 + " : " + f1 + "->"
                + f1.getMap());
        System.out.println("\tZustand der Karte an der Stelle (7,5):"
                + map.getField(7, 5));
        System.out.println("\tSetze Feld " + f1
                + " mit der setPosition-Methode"
                + " aus AbstractField an die illegale Position (20,5):");
        f1.setPosition(20, 5, map);
        System.out.println("\tZustand von " + f1 + " : " + f1 + "->"
                + f1.getMap());
        System.out.println("\tZustand der Karte an der Stelle (7,5):"
                + map.getField(7, 5));
        System.out.println();

        // Test 5 (umsetzen eines platzierten Feldes an eine legale Position)
        predecessor = (JeneralGameField) map.getField(9, 6);
        System.out.println("Test 5 (umsetzen eines platzierten Feldes an "
                + "eine legale Position):");
        System.out.println("\tZustand von " + f1 + " : " + f1 + "->"
                + f1.getMap());
        System.out.println("\tVorgänger an der Stelle (9,6): " + predecessor
                + "->" + predecessor.getMap());
        System.out.println("\tZustand der Karte an der Stelle (7,5):"
                + map.getField(7, 5));
        System.out.println("\tZustand der Karte an der Stelle (9,6):"
                + map.getField(9, 6));
        System.out.println("\tSetze Feld " + f1
                + " mit der setPosition-Methode"
                + " aus AbstractField an die legale Position (9,6):");
        f1.setPosition(9, 6, map);
        System.out.println("\tZustand von " + f1 + " : " + f1 + "->"
                + f1.getMap());
        System.out.println("\tVorgänger nach der Aktion: " + predecessor + "->"
                + predecessor.getMap());
        System.out.println("\tZustand der Karte an der Stelle (9,6):"
                + map.getField(9, 6));
        System.out.println("\tZustand der Karte an der Stelle (7,5):"
                + map.getField(7, 5));
        System.out.println();
    }

}
