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

import java.util.ArrayList;

import jeneral.model.map.JeneralGameField;
import jeneral.model.map.JeneralTerrain;
import jeneral.model.units.JeneralAirUnit;
import jeneral.model.units.JeneralGroundWeapon;
import jeneral.model.units.JeneralLandUnit;
import jeneral.view.units.BuggyView;
import jeneral.view.units.FighterView;
import jeneral.view.units.TruckView;

import nkutilities.graph.DijkstraPathfinder;
import nkutilities.graph.GraphNode;

import abstractgame.events.unitevents.UnitDirectionChangedEvent;
import abstractgame.events.unitevents.UnitMovedEvent;
import abstractgame.interfaces.UnitDirectionChangedListener;
import abstractgame.interfaces.UnitMovedListener;
import abstractgame.unit.MobileUnitRole;

/**
 * The Class TestLandUnitMovement.
 *
 * @author Nils Kuttkat
 */
public class TestUnitMovement extends MainTestClass implements
        UnitMovedListener, UnitDirectionChangedListener {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestUnitMovement testLandUnitMovement = new TestUnitMovement();
        testLandUnitMovement.printMap();
        testLandUnitMovement.test();
    }

    /**
     * The jet.
     */
    protected JeneralAirUnit jet;

    /**
     * The path.
     */
    protected ArrayList<GraphNode> path;

    /**
     * The pathfinder.
     */
    protected DijkstraPathfinder pathfinder = new DijkstraPathfinder();

    /**
     * The buggy.
     */
    protected JeneralLandUnit truck, buggy;

    /**
     * Instantiates a new test land unit movement.
     */
    public TestUnitMovement() {
        super();
        truck = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 50, 10,
                new JeneralGroundWeapon(25, 1));
        truck.setView(new TruckView());
        truck.addTerrain(JeneralTerrain.PLAIN, 2);
        truck.addTerrain(JeneralTerrain.DESERT, 6);
        buggy = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player1, 40, 10,
                new JeneralGroundWeapon(23, 1));
        buggy.setView(new BuggyView());
        buggy.addTerrain(JeneralTerrain.DESERT, 2);
        buggy.addTerrain(JeneralTerrain.FOREST, 2);
        buggy.addTerrain(JeneralTerrain.PLAIN, 1);
        jet = new JeneralAirUnit(game, MobileUnitRole.GetRole(), player, 20, 6);
        jet.setView(new FighterView());

        truck.addUnitMovedListener(this);
        truck.addUnitDirectionChangedListener(this);
        buggy.addUnitMovedListener(this);
        buggy.addUnitDirectionChangedListener(this);
        jet.addUnitMovedListener(this);
        jet.addUnitDirectionChangedListener(this);
    }

    /**
     * Test.
     */
    protected void test() {
        // Test 7 (finding paths for units)
        System.out.println();
        JeneralGameField start = (JeneralGameField) map.getField(5, 4), target = (JeneralGameField) map
                .getField(2, 0);

        System.out.println("Path for Truck from " + start + " to " + target);
        truck.setPosition(start);

        path = pathfinder.findPath(truck, start, target);

        for (GraphNode node : path) {
            System.out.println(node);
        }
        System.out
                .println("Distance: " + pathfinder.getDistanceForNode(target));

        ((JeneralGameField) map.getField(0, 4))
                .setTerrain(JeneralTerrain.WATER);

        System.out.println();
        System.out.println("Path for Truck from " + start + " to " + target
                + " after the graph was rebuild due to changes on the map");
        truck.setPosition(start);
        path = pathfinder.findPath(truck, start, target);

        for (GraphNode node : path) {
            System.out.println(node);
        }
        System.out
                .println("Distance: " + pathfinder.getDistanceForNode(target));

        ((JeneralGameField) map.getField(0, 4))
                .setTerrain(JeneralTerrain.PLAIN);

        System.out.println();
        System.out.println("Path for Truck from " + start + " to " + target
                + " after a FRIENDLY buggy was placed as an obstacle");
        buggy.setPlayer(player);
        buggy.setPosition(map.getField(0, 4));
        truck.setPosition(start);
        path = pathfinder.findPath(truck, start, target);
        for (GraphNode node : path) {
            System.out.println(node);
        }
        System.out
                .println("Distance: " + pathfinder.getDistanceForNode(target));

        System.out.println();
        System.out.println("Path for Truck from " + start + " to " + target
                + " after a HOSTILE buggy was placed as an obstacle");
        buggy.setPlayer(player1);
        buggy.setPosition(map.getField(0, 4));
        truck.setPosition(start);
        path = pathfinder.findPath(truck, start, target);

        for (GraphNode node : path) {
            System.out.println(node);
        }
        System.out
                .println("Distance: " + pathfinder.getDistanceForNode(target));
        // ////////////////////end
        // truck///////////////////////////////////////////

        start = (JeneralGameField) map.getField(7, 7);
        System.out.println();
        System.out.println("Path for Buggy from " + start + " to " + target);
        buggy.setPosition(start);
        path = pathfinder.findPath(buggy, start, target);

        for (GraphNode node : path) {
            System.out.println(node);
        }
        System.out
                .println("Distance: " + pathfinder.getDistanceForNode(target));
        // ///////////////////end
        // buggy////////////////////////////////////////////

        start = (JeneralGameField) map.getField(8, 9);
        System.out.println();
        System.out.println("Path for Jet from " + start + " to " + target);

        jet.setPosition(start);
        path = pathfinder.findPath(jet, start, target);

        for (GraphNode node : path) {
            System.out.println(node);
        }
        System.out
                .println("Distance: " + pathfinder.getDistanceForNode(target));
        // ///////////////////end
        // jet////////////////////////////////////////////
    }

    /* (non-Javadoc)
	 * @see abstractgame.interfaces.UnitDirectionChangedListener#unitDirectionChanged(abstractgame.events.unitevents.UnitDirectionChangedEvent)
     */
    @Override
    public void unitDirectionChanged(UnitDirectionChangedEvent event) {
        System.out.println();
        System.out.println("UnitDirectionChanged event fired: "
                + event.getSource().toString());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    /* (non-Javadoc)
	 * @see abstractgame.interfaces.UnitMovedListener#unitMoved(abstractgame.events.unitevents.UnitMovedEvent)
     */
    @Override
    public void unitMoved(UnitMovedEvent event) {
        System.out.println();
        System.out.println("UnitMoved event fired: "
                + event.getSource().toString());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}
