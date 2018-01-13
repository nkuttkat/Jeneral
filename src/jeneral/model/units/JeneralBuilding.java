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
package jeneral.model.units;

import java.util.HashSet;

import jeneral.model.map.JeneralTerrain;

import abstractgame.game.AbstractGame;
import abstractgame.game.AbstractPlayer;
import abstractgame.unit.AbstractMobilityRole;

/**
 * The Class Building.
 *
 * @author Nils Kuttkat
 */
public class JeneralBuilding extends JeneralGroundUnit {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -3455314490777114624L;

    /**
     * The parent.
     */
    private JeneralBuilding parent;

    /**
     * The parts.
     */
    private HashSet<JeneralBuilding> parts;

    /**
     * Instantiates a new jeneral building.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     */
    public JeneralBuilding(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health) {
        this(game, mobilityRole, player, health, new JeneralDummyWeapon());
    }

    /**
     * Instantiates a new jeneral building.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param weapon the weapon
     */
    public JeneralBuilding(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, JeneralWeapon weapon) {
        this(game, mobilityRole, player, health, weapon, new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral building.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param weapon the weapon
     * @param cu the cu
     */
    public JeneralBuilding(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player,
            int health, JeneralWeapon weapon, JeneralCarrierUnit cu) {
        super(game, mobilityRole, player, health, 0, weapon, cu);
        this.parts = new HashSet<JeneralBuilding>();
    }

    /**
     * Adds the part.
     *
     * @param building the building
     */
    public void addPart(JeneralBuilding building) {
        if (!this.equals(building) && !this.isPart()) {
            this.parts.add(building);
            if (building != null && !this.equals(building.getParent())) {
                building.setParent(this);
            }
        }
    }

    /**
     * Adds the terrain.
     *
     * @param terrain the terrain
     */
    public void addTerrain(JeneralTerrain terrain) {
        super.addTerrain(terrain, Integer.MAX_VALUE);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see
	 * freemax.model.units.FreemaxUnit#addTerrain(freemax.model.map.Terrain,
	 * int)
     */
    /**
     * Adds the terrain.
     *
     * @param terrain the terrain
     * @param mp the mp
     */
    public void addTerrain(JeneralTerrain terrain, int mp) {
        this.addTerrain(terrain);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see util.game.AbstractUnit#destroy()
     */
    @Override
    public void destroy() {
        if (this.isPart()) {
            this.parent.destroy();
        } else {
            for (JeneralBuilding part : this.parts) {
                try {
                    part.finalize();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            try {
                this.finalize();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    public JeneralBuilding getParent() {
        return parent;
    }

    /**
     * Gets the parts.
     *
     * @return the parts
     */
    public HashSet<JeneralBuilding> getParts() {
        return parts;
    }

    /**
     * Checks for part.
     *
     * @return true, if successful
     */
    public boolean hasPart() {
        return !this.parts.isEmpty();
    }

    /**
     * Checks if is part.
     *
     * @return true, if is part
     */
    public boolean isPart() {
        return this.parent != null;
    }

    /**
     * Removes the part.
     *
     * @param building the building
     */
    public void removePart(JeneralBuilding building) {
        this.parts.remove(building);
        if (building != null && this.equals(building.getParent())) {
            building.setParent(null);
        }
    }

    /**
     * Sets the parent.
     *
     * @param parent the new parent
     */
    public void setParent(JeneralBuilding parent) {
        JeneralBuilding previousParent = this.parent;
        if (!this.equals(parent)) {
            this.parent = parent;
        }
        if (parent != null && !parent.getParts().contains(this)) {
            parent.addPart(this);
        }
        if (previousParent != null) {
            previousParent.removePart(this);
        }
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see freemax.model.units.FreemaxUnit#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getName() + "{" + this.getPosition() + ", "
                + this.getCurrentHealth() + "/" + this.getMaxHealth() + ", "
                + this.getCurrentMovementPoints() + "/"
                + this.getMaxMovementPoints() + "}";
    }
}
