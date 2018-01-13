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

import jeneral.model.units.JeneralAirUnit;
import jeneral.model.units.JeneralGroundWeapon;
import jeneral.view.units.FighterView;
import abstractgame.game.AbstractGame;
import abstractgame.game.AbstractPlayer;
import abstractgame.unit.MobileUnitRole;

/**
 * The Class Fighter.
 *
 * @author Nils Kuttkat
 */
public class Fighter extends JeneralAirUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1830994980625932639L;

    /**
     * Instantiates a new fighter.
     *
     * @param game the game
     * @param player the player
     */
    public Fighter(AbstractGame game, AbstractPlayer player) {
        super(game, MobileUnitRole.GetRole(), player, 40, 10, new JeneralGroundWeapon(25, 3));
        this.setView(new FighterView());
    }
}
