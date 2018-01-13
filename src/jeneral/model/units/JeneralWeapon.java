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

import jeneral.model.map.*;
import abstractgame.unit.AbstractUnit;

/**
 * The Class Weapon.
 *
 * @author Nils Kuttkat
 */
public abstract class JeneralWeapon {

    /**
     * The damage.
     */
    private int damage = 0;

    /**
     * The range.
     */
    private int range = 1;

    /**
     * Instantiates a new weapon.
     */
    public JeneralWeapon() {

    }

    /**
     * Instantiates a new weapon.
     *
     * @param damage the damage
     */
    public JeneralWeapon(int damage) {
        this.damage = damage;
    }

    /**
     * Instantiates a new weapon.
     *
     * @param damage the damage
     * @param range the range
     */
    public JeneralWeapon(int damage, int range) {
        this.damage = damage;
        this.range = range;
    }

    /**
     * Attack.
     *
     * @param position the position
     * @param unit the unit
     */
    public void attack(JeneralGameField position, JeneralUnit unit) {
        if (this.canAttack(unit) && this.targetInRange(position, unit)) {
            unit.damage(this.getDamage());
        }
    }

    /**
     * Can attack.
     *
     * @param unit the unit
     * @return true, if successful
     */
    public abstract boolean canAttack(JeneralUnit unit);

    /**
     * Gets the damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Gets the range.
     *
     * @return the range
     */
    public int getRange() {
        return this.range;
    }

    /**
     * Target in range.
     *
     * @param position the position
     * @param unit the unit
     * @return true, if successful
     */
    public boolean targetInRange(JeneralGameField position, AbstractUnit unit) {
        return position.getDistance(unit.getPosition()) <= this.getRange();
    }
}
