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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import jeneral.model.map.JeneralGameField;
import jeneral.model.map.JeneralTerrain;

import abstractgame.view.SquareView;
import java.io.IOException;

/**
 * The Class GameFieldView.
 *
 * @author Nils Kuttkat
 */
public class GameFieldView extends SquareView {

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new game field view.
     *
     * @param model the model
     */
    public GameFieldView(JeneralGameField model) {
        super(model);
    }

    /**
     * Gets the terrain image.
     *
     * @return the terrain image
     */
    public BufferedImage getTerrainImage() {
        BufferedImage image = null;

        try {
            switch ((JeneralTerrain) ((JeneralGameField) this.getModel())
                    .getTerrain()) {
                case PLAIN:
                    image = ImageIO.read(new File("pics/plain.png"));
                    break;
                case DESERT:
                    image = ImageIO.read(new File("pics/desert.png"));
                    break;
                case WATER:
                    image = ImageIO.read(new File("pics/water.png"));
                    break;
                case MOUNTAIN:
                    image = ImageIO.read(new File("pics/mountain.png"));
                    break;
                case FOREST:
                    image = ImageIO.read(new File("pics/forest.png"));
                    break;
                case ROUGH:
                    image = ImageIO.read(new File("pics/rough.png"));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    /**
     * Initialize.
     *
     */
    @Override
    public void initialize(int sideLength) {
        super.initialize(sideLength);
        this.showBorder(true);
        BufferedImage image = new BufferedImage(this.getWidth(),
                this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(this.getForeground());
        g.fill(this.getShape());
        g.dispose();
    }

    /* (non-Javadoc)
	 * @see abstractgame.view.SquareView#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(this.getTerrainImage(), null, 0, 0);
    }
}
