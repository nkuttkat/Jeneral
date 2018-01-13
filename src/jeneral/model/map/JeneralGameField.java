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
package jeneral.model.map;

import java.util.Iterator;

import jeneral.model.units.JeneralUnit;

import abstractgame.map.OctagonField;
import abstractgame.unit.AbstractUnit;

/**
 * The Class JeneralGameField.
 *
 * @author Nils Kuttkat
 */
public class JeneralGameField extends OctagonField {

    /**
     * The Constant MAX_UNITS.
     */
    protected static final int MAX_UNITS = 2;

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -3746245950597123136L;

    /**
     * Instantiates a new jeneral game field.
     */
    public JeneralGameField() {
        this(JeneralTerrain.PLAIN);
    }

    /**
     * Instantiates a new jeneral game field.
     *
     * @param terrain the terrain
     */
    public JeneralGameField(JeneralTerrain terrain) {
        super();
        this.setMaxUnits(MAX_UNITS);
        this.setTerrain(terrain);
    }

    /* (non-Javadoc)
	 * @see abstractgame.AbstractField#canCarry(abstractgame.AbstractUnit)
     */
    @Override
    public boolean canCarry(AbstractUnit abstractUnit) {
        boolean canCarry = false;

        if (this.containsUnit(abstractUnit)
                || (((JeneralUnit) abstractUnit).isAirUnit() && !this
                .containsAirUnit())
                || (((JeneralUnit) abstractUnit).isGroundUnit() && !this
                .containsGroundUnit())) {
            canCarry = super.canCarry(abstractUnit);
        }

        return canCarry;
    }

    /**
     * Contains air unit.
     *
     * @return true, if successful
     */
    public boolean containsAirUnit() {
        return this.getAirUnit() != null;
    }

    /**
     * Contains ground unit.
     *
     * @return true, if successful
     */
    public boolean containsGroundUnit() {
        return this.getGroundUnit() != null;
    }

    // Suche nach der AirUnit und gebe sie zurück...andernfalls null
    /**
     * Gets the air unit.
     *
     * @return the air unit
     */
    public JeneralUnit getAirUnit() {
        for (Iterator<AbstractUnit> i = this.getUnits().iterator(); i.hasNext();) {
            JeneralUnit u = (JeneralUnit) i.next();
            if (u.isAirUnit()) {
                return u;
            }
        }
        return null;
    }

    // Suche nach der GroundUnit und gebe sie zurück...andernfalls null
    /**
     * Gets the ground unit.
     *
     * @return the ground unit
     */
    public JeneralUnit getGroundUnit() {
        for (Iterator<AbstractUnit> i = this.getUnits().iterator(); i.hasNext();) {
            JeneralUnit u = (JeneralUnit) i.next();
            if (u.isGroundUnit()) {
                return u;
            }
        }
        return null;
    }

    /* (non-Javadoc)
	 * @see abstractgame.AbstractField#toString()
     */
    @Override
    public String toString() {
        return "[" + this.getTerrain() + "]" + this.getPosition();
    }
}
