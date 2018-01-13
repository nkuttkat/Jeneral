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
import abstractgame.map.AbstractField;
import abstractgame.unit.AbstractMobilityRole;

/**
 * The Class AirUnit.
 *
 * @author Nils Kuttkat
 */
public class JeneralAirUnit extends JeneralUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1866727001784505972L;

    /**
     * Instantiates a new air unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movementPoints
     */
    public JeneralAirUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health,
            int movementPoints) {
        this(game, mobilityRole, player, health, movementPoints, new JeneralDummyWeapon(),
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new air unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movementPoints
     * @param carrierUnit the carrier unit
     */
    public JeneralAirUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health,
            int movementPoints, JeneralCarrierUnit carrierUnit) {
        this(game, mobilityRole, player, health, movementPoints, new JeneralDummyWeapon(),
                carrierUnit);
    }

    /**
     * Instantiates a new air unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movementPoints
     * @param weapon the weapon
     */
    public JeneralAirUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health,
            int movementPoints, JeneralWeapon weapon) {
        this(game, mobilityRole, player, health, movementPoints, weapon,
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new air unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movementPoints
     * @param weapon the weapon
     * @param carrierUnit the carrier unit
     */
    public JeneralAirUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health,
            int movementPoints, JeneralWeapon weapon,
            JeneralCarrierUnit carrierUnit) {
        super(game, mobilityRole, player, health, movementPoints, weapon, carrierUnit);
        this.addTerrain(JeneralTerrain.PLAIN, 1);
        this.addTerrain(JeneralTerrain.FOREST, 1);
        this.addTerrain(JeneralTerrain.DESERT, 1);
        this.addTerrain(JeneralTerrain.MOUNTAIN, 1);
        this.addTerrain(JeneralTerrain.ROUGH, 1);
        this.addTerrain(JeneralTerrain.WATER, 1);
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

            if (abstractField != null
                    && ((JeneralGameField) abstractField).containsAirUnit()
                    && ((JeneralGameField) abstractField).getAirUnit()
                            .isHostileTo(this)) {
                canPass = false;
            }
        }

        return canPass;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see freemax.model.units.FreemaxUnit#isAirUnit()
     */
    @Override
    public boolean isAirUnit() {
        return true;
    }
}
