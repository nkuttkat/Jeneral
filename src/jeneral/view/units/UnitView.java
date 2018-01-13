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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import abstractgame.unit.AbstractUnit;
import abstractgame.view.AbstractUnitView;

/**
 * The Class UnitView.
 *
 * @author Nils Kuttkat
 */
public abstract class UnitView extends AbstractUnitView {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new unit view.
     */
    public UnitView() {
        this(null);
    }

    /**
     * Instantiates a new unit view.
     *
     * @param model the model
     */
    public UnitView(AbstractUnit model) {
        super(model);
        this.setSize(40, 40);
        this.setMinimumSize(this.getSize());
        this.setMaximumSize(this.getSize());
        this.setPreferredSize(this.getSize());
        this.setModel(model);
    }

    /* (non-Javadoc)
	 * @see abstractgame.view.AbstractUnitView#getImage()
     */
    public abstract BufferedImage getImage();

    /* (non-Javadoc)
	 * @see abstractgame.view.AbstractUnitView#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gCopy = (Graphics2D) g;
        gCopy.drawImage(this.getImage(), 0, 0, null);
    }
}
