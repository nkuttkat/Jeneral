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

import abstractgame.unit.AbstractUnit;

/**
 * The Class CarrierUnit.
 *
 * @author Nils Kuttkat
 */
public abstract class JeneralCarrierUnit {

    /**
     * The capacity.
     */
    private int capacity;

    /**
     * The units.
     */
    private HashSet<JeneralUnit> units;

    /**
     * Instantiates a new carrier unit.
     */
    public JeneralCarrierUnit() {
        this(Integer.MAX_VALUE);
    }

    /**
     * Instantiates a new carrier unit.
     *
     * @param capacity the capacity
     */
    public JeneralCarrierUnit(int capacity) {
        this.units = new HashSet<>();
        this.capacity = capacity;
    }

    /**
     * Adds the unit.
     *
     * @param unit the unit
     * @return true, if successful
     */
    public boolean addUnit(JeneralUnit unit) {
        // kann die Einheit aufgenommen werden ?
        if (this.canCarry(unit)) {
            return this.units.add(unit);
        }
        return false;
    }

    /**
     * Can carry.
     *
     * @param unit the unit
     * @return true, if successful
     */
    public boolean canCarry(JeneralUnit unit) {
        // wenn die Einheit bereits im Container ist ODER die Anzahl enthaltener
        // Einheiten kleiner der Kapazität ist, gebe 'true' zurück
        if (this.getUnits().contains(unit)
                || this.getUnits().size() < this.getCapacity()) {
            return true;
        }
        return false;
    }

    /**
     * Contains unit.
     *
     * @param unit the unit
     * @return true, if successful
     */
    public boolean containsUnit(AbstractUnit unit) {
        return this.units.contains(unit);
    }

    /**
     * Gets the capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Gets the units.
     *
     * @return the units
     */
    public HashSet<JeneralUnit> getUnits() {
        return this.units;
    }

    /**
     * Removes the unit.
     *
     * @param unit the unit
     * @return true, if successful
     */
    public boolean removeUnit(AbstractUnit unit) {
        return this.units.remove(unit);
    }
}
