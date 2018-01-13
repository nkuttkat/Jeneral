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

import jeneral.model.JeneralGame;
import jeneral.model.JeneralPlayer;
import jeneral.model.map.JeneralGameMap;

/**
 * The Class TestPlayerGameRelation.
 *
 * @author Nils Kuttkat
 */
public class TestPlayerGameRelation {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        JeneralGameMap map = new JeneralGameMap(9, 10);
        JeneralGame game, game1;
        game = new JeneralGame(map);
        game1 = new JeneralGame(map);
        JeneralPlayer player, player1;
        player = new JeneralPlayer("nils", game);
        player1 = new JeneralPlayer("theo", game);
        System.out.println("nils:" + player.getGame());
        System.out.println("theo:" + player1.getGame());
        System.out.println("Game :" + game.getPlayers());
        System.out.println("Game1 :" + game1.getPlayers());

        // Test 1
        System.out.println();
        System.out
                .println("Setze das Game mittels 'setGame'-Methode aus AbstractPlayer:");
        player.setGame(game1);
        player1.setGame(null);
        System.out.println("nils:" + player.getGame());
        System.out.println("theo:" + player1.getGame());
        System.out.println("Game :" + game.getPlayers());
        System.out.println("Game1 :" + game1.getPlayers());

        // Test 2
        System.out.println();
        System.out
                .println("Setze das Game mittels 'addPlayer'-Methode aus AbstractGame:");
        player.setGame(game);
        player1.setGame(game);
        System.out.println("nils:" + player.getGame());
        System.out.println("theo:" + player1.getGame());
        System.out.println("Game :" + game.getPlayers());
        System.out.println("Game1 :" + game1.getPlayers());
    }

    /**
     * Instantiates a new test player game relation.
     */
    public TestPlayerGameRelation() {
        super();
    }

}
