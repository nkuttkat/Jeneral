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
package jeneral.model.units;

import jeneral.model.map.*;
import abstractgame.game.AbstractGame;
import abstractgame.game.AbstractPlayer;
import abstractgame.unit.AbstractMobilityRole;

/**
 * The Class FreemaxLandUnit.
 *
 * @author Nils Kuttkat
 */
public class JeneralLandUnit extends JeneralGroundUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5178955748833487421L;

    /**
     * Instantiates a new jeneral land unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param mp the mp
     */
    public JeneralLandUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int mp) {
        this(game, mobilityRole, player, health, mp, new JeneralDummyWeapon(),
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral land unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param mp the mp
     * @param carrierUnit the carrier unit
     */
    public JeneralLandUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int mp, JeneralCarrierUnit carrierUnit) {
        this(game, mobilityRole, player, health, mp, new JeneralDummyWeapon(), carrierUnit);
    }

    /**
     * Instantiates a new jeneral land unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param mp the mp
     * @param weapon the weapon
     */
    public JeneralLandUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int mp, JeneralWeapon weapon) {
        this(game, mobilityRole, player, health, mp, weapon, new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral land unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param mp the mp
     * @param weapon the weapon
     * @param carrierUnit the carrier unit
     */
    public JeneralLandUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int mp, JeneralWeapon weapon,
            JeneralCarrierUnit carrierUnit) {
        super(game, mobilityRole, player, health, mp, weapon, carrierUnit);
        this.addTerrain(JeneralTerrain.PLAIN, 1);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see freemax.model.units.FreemaxUnit#isLandUnit()
     */
    @Override
    public boolean isLandUnit() {
        return true;
    }
}
