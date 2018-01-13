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
 * The Class WaterUnit.
 *
 * @author Nils Kuttkat
 */
public class JeneralWaterUnit extends JeneralGroundUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 4361050865041893200L;

    /**
     * Instantiates a new jeneral water unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     */
    public JeneralWaterUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int movementPoints) {
        this(game, mobilityRole, player, health, movementPoints, new JeneralDummyWeapon(),
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral water unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param carrierUnit the carrier unit
     */
    public JeneralWaterUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int movementPoints, JeneralCarrierUnit carrierUnit) {
        this(game, mobilityRole, player, health, movementPoints, new JeneralDummyWeapon(),
                carrierUnit);
    }

    /**
     * Instantiates a new jeneral water unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param weapon the weapon
     */
    public JeneralWaterUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int movementPoints, JeneralWeapon weapon) {
        this(game, mobilityRole, player, health, movementPoints, weapon,
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral water unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param weapon the weapon
     * @param carrierUnit the carrier unit
     */
    public JeneralWaterUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int movementPoints, JeneralWeapon weapon,
            JeneralCarrierUnit carrierUnit) {
        super(game, mobilityRole, player, health, movementPoints, weapon, carrierUnit);
        this.addTerrain(JeneralTerrain.WATER, 1);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see freemax.model.units.FreemaxUnit#isWaterUnit()
     */
    @Override
    public boolean isWaterUnit() {
        return true;
    }
}
