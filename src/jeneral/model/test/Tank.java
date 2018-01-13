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

import jeneral.model.units.JeneralGroundUnit;
import jeneral.model.units.JeneralGroundWeapon;
import jeneral.view.units.TankView;
import abstractgame.game.AbstractGame;
import abstractgame.game.AbstractPlayer;
import abstractgame.unit.MobileUnitRole;

/**
 * The Class Tank.
 *
 * @author Nils Kuttkat
 */
public class Tank extends JeneralGroundUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 2119563620987172067L;

    /**
     * Instantiates a new tank.
     *
     * @param game the game
     * @param player the player
     */
    public Tank(AbstractGame game, AbstractPlayer player) {
        super(game, MobileUnitRole.GetRole(), player, 85, 5, new JeneralGroundWeapon(30, 1));
        this.setView(new TankView());
    }
}
