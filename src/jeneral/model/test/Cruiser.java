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

import jeneral.model.units.JeneralGroundWeapon;
import jeneral.model.units.JeneralWaterUnit;
import jeneral.view.units.CruiserView;
import abstractgame.game.AbstractGame;
import abstractgame.game.AbstractPlayer;
import abstractgame.unit.MobileUnitRole;

/**
 * The Class Cruiser.
 *
 * @author Nils Kuttkat
 */
public class Cruiser extends JeneralWaterUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -2859239590862474538L;

    /**
     * Instantiates a new cruiser.
     *
     * @param game the game
     * @param player the player
     */
    public Cruiser(AbstractGame game, AbstractPlayer player) {
        super(game, MobileUnitRole.GetRole(), player, 125, 5, new JeneralGroundWeapon(50, 3));
        this.setView(new CruiserView());
    }
}
