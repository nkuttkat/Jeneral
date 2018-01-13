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
package jeneral.view.units;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import abstractgame.unit.AbstractUnit;

/**
 * The Class CruiserView.
 *
 * @author Nils Kuttkat
 */
public class CruiserView extends UnitView {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new cruiser view.
     */
    public CruiserView() {
        this(null);
    }

    /**
     * Instantiates a new cruiser view.
     *
     * @param model the model
     */
    public CruiserView(AbstractUnit model) {
        super(model);
    }

    /* (non-Javadoc)
	 * @see jeneral.view.units.UnitView#getImage()
     */
    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("pics/cruiser.png"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
