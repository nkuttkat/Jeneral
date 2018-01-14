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

import jeneral.model.JeneralPlayer;
import jeneral.model.map.JeneralTerrain;
import jeneral.model.units.JeneralAirUnit;
import jeneral.model.units.JeneralGroundWeapon;
import jeneral.model.units.JeneralLandUnit;
import jeneral.view.units.BuggyView;
import jeneral.view.units.FighterView;
import jeneral.view.units.TruckView;
import abstractgame.events.unitevents.UnitDirectionChangedEvent;
import abstractgame.events.unitevents.UnitMovedEvent;
import abstractgame.interfaces.UnitDirectionChangedListener;
import abstractgame.interfaces.UnitMovedListener;
import abstractgame.unit.MobileUnitRole;

/**
 * The Class TestTurns.
 *
 * @author Nils Kuttkat
 */
public class TestTurns extends MainTestClass implements UnitMovedListener,
        UnitDirectionChangedListener {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestTurns testTurns = new TestTurns();
        testTurns.printMap();
        testTurns.test();
    }

    /**
     * The buggy.
     */
    private final JeneralLandUnit buggy;

    /**
     * The jet.
     */
    private final JeneralAirUnit jet;

    /**
     * The truck.
     */
    private final JeneralLandUnit truck;

    /**
     * Instantiates a new test turns.
     */
    public TestTurns() {
        super();
        truck = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player, 50, 10, new JeneralGroundWeapon(25, 1));
        truck.setView(new TruckView());
        truck.addTerrain(JeneralTerrain.PLAIN, 2);
        truck.addTerrain(JeneralTerrain.DESERT, 6);
        buggy = new JeneralLandUnit(game, MobileUnitRole.GetRole(), player1, 40, 10, new JeneralGroundWeapon(23, 1));
        buggy.setView(new BuggyView());
        buggy.addTerrain(JeneralTerrain.DESERT, 2);
        buggy.addTerrain(JeneralTerrain.FOREST, 2);
        buggy.addTerrain(JeneralTerrain.PLAIN, 1);
        jet = new JeneralAirUnit(game, MobileUnitRole.GetRole(), player1, 20, 6);
        jet.setView(new FighterView());

        truck.addUnitMovedListener(this);
        truck.addUnitDirectionChangedListener(this);
        buggy.addUnitMovedListener(this);
        buggy.addUnitDirectionChangedListener(this);
        jet.addUnitMovedListener(this);
        jet.addUnitDirectionChangedListener(this);

        this.game.getArbiter().initPlayerQueue();
    }

    /**
     * Test.
     */
    private void test() {
        JeneralPlayer currentPlayer = (JeneralPlayer) this.game.getArbiter().getCurrentPlayer();
        System.out.println(currentPlayer.getName() + "'s turn");
        System.out.println();
        System.out.println(currentPlayer.getName() + " puts truck on field " + map.getField(5, 4));
        currentPlayer.putUnit(truck, map.getField(5, 4));
        System.out.println(currentPlayer.getName() + " puts truck on field " + map.getField(6, 4));
        currentPlayer.putUnit(truck, map.getField(6, 4));
        System.out.println(player1.getName() + " try to put buggy on field and fails" + map.getField(7, 4));
        player1.putUnit(buggy, map.getField(7, 4));
        System.out.println(currentPlayer.getName() + " ends his turn ");
        currentPlayer.endTurn();

        currentPlayer = (JeneralPlayer) this.game.getArbiter().getCurrentPlayer();
        System.out.println(currentPlayer.getName() + "'s turn");
        System.out.println();
        System.out.println(currentPlayer.getName() + " puts buggy on field " + map.getField(7, 4));
        player1.putUnit(buggy, map.getField(7, 4));
        System.out.println(currentPlayer.getName() + " puts buggy on field " + map.getField(9, 4));
        player1.putUnit(buggy, map.getField(9, 4));
    }

    /* (non-Javadoc)
	 * @see abstractgame.interfaces.UnitDirectionChangedListener#unitDirectionChanged(abstractgame.events.unitevents.UnitDirectionChangedEvent)
     */
    @Override
    public void unitDirectionChanged(UnitDirectionChangedEvent event) {
        System.out.println();
        System.out.println("UnitDirectionChanged event fired: "
                + event.getSource().toString());
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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}
