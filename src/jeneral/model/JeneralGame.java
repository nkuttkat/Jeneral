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
package jeneral.model;

import abstractgame.game.AbstractGame;
import abstractgame.game.StandardArbiter;
import abstractgame.map.AbstractMap;

/**
 * The Class JeneralGame.
 *
 * @author Nils Kuttkat
 */
public class JeneralGame extends AbstractGame {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 525039225407299236L;

    /**
     * Instantiates a new jeneral game.
     *
     * @param map the map
     */
    public JeneralGame(AbstractMap map) {
        super(map);
        this.setArbiter(new StandardArbiter(this));
    }

}
