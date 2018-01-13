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

import jeneral.model.map.JeneralGameField;
import abstractgame.game.AbstractGame;
import abstractgame.game.AbstractPlayer;
import abstractgame.map.AbstractField;
import abstractgame.unit.AbstractMobilityRole;

/**
 * The Class GroundUnit.
 *
 * @author Nils Kuttkat
 */
public abstract class JeneralGroundUnit extends JeneralUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -2570944047163732101L;

    /**
     * Instantiates a new jeneral ground unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     */
    public JeneralGroundUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int movementPoints) {
        this(game, mobilityRole, player, health, movementPoints, new JeneralDummyWeapon(),
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral ground unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param carrierUnit the carrier unit
     */
    public JeneralGroundUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int movementPoints, JeneralCarrierUnit carrierUnit) {
        this(game, mobilityRole, player, health, movementPoints, new JeneralDummyWeapon(),
                carrierUnit);
    }

    /**
     * Instantiates a new jeneral ground unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param weapon the weapon
     */
    public JeneralGroundUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int movementPoints, JeneralWeapon weapon) {
        this(game, mobilityRole, player, health, movementPoints, weapon,
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral ground unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param weapon the weapon
     * @param carrierUnit the carrier unit
     */
    public JeneralGroundUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, int movementPoints, JeneralWeapon weapon,
            JeneralCarrierUnit carrierUnit) {
        super(game, mobilityRole, player, health, movementPoints, weapon, carrierUnit);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see util.game.AbstractUnit#canPass(util.game.AbstractField)
     */
    @Override
    public boolean canPass(AbstractField abstractField) {
        boolean canPass;

        if (canPass = this.canAccess(abstractField)) {

            if ((abstractField != null
                    // and the field already contains a GroundUnit
                    && ((JeneralGameField) abstractField).containsGroundUnit()
                    // and the contained GroundUnit is hostile
                    && ((JeneralGameField) abstractField).getGroundUnit()
                            .isHostileTo(this))
                    // or the GroundUnit is a Building (an obstruction)
                    || (((JeneralGameField) abstractField).getGroundUnit() instanceof JeneralBuilding)) {
                canPass = false;
            }
        }

        return canPass;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see freemax.model.units.FreemaxUnit#isGroundUnit()
     */
    @Override
    public boolean isGroundUnit() {
        return true;
    }
}
