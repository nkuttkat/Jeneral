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
package jeneral.view.map;

import java.awt.event.MouseListener;

import jeneral.model.map.JeneralGameField;
import jeneral.model.map.JeneralGameMap;

import abstractgame.map.AbstractField;
import abstractgame.view.SquareMapView;

/**
 * The Class GameMapView.
 *
 * @author Nils Kuttkat
 */
public class GameMapView extends SquareMapView {

    /**
     * The field size.
     */
    public static int FIELD_SIZE = 40;

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new game map view.
     *
     * @param model the model
     * @param listener the listener
     */
    public GameMapView(JeneralGameMap model, MouseListener listener) {
        super(model, GameMapView.FIELD_SIZE);

        for (AbstractField[] fieldArray : this.getModel().getFields()) {
            for (AbstractField field : fieldArray) {
                this.add(new GameFieldView((JeneralGameField) field,
                        GameMapView.FIELD_SIZE, listener));
            }
        }
    }
}
