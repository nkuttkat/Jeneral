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

import jeneral.model.units.JeneralAirWeapon;
import jeneral.model.units.JeneralGroundUnit;
import abstractgame.game.AbstractGame;
import abstractgame.game.AbstractPlayer;
import abstractgame.unit.MobileUnitRole;

/**
 * The Class AirDefense.
 *
 * @author Nils Kuttkat
 */
public class AirDefense extends JeneralGroundUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -1655116455938550472L;

    /**
     * Instantiates a new air defense.
     *
     * @param game the game
     * @param player the player
     */
    public AirDefense(AbstractGame game, AbstractPlayer player) {
        super(game, MobileUnitRole.GetRole(), player, 60, 14, new JeneralAirWeapon(25, 2));
    }
}
