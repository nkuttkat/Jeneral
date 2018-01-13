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

/**
 * The Class GroundWeapon.
 *
 * @author Nils Kuttkat
 */
public class JeneralGroundWeapon extends JeneralWeapon {

    /**
     * Instantiates a new ground weapon.
     *
     * @param damage the damage
     */
    public JeneralGroundWeapon(int damage) {
        super(damage);
    }

    /**
     * Instantiates a new ground weapon.
     *
     * @param damage the damage
     * @param range the range
     */
    public JeneralGroundWeapon(int damage, int range) {
        super(damage, range);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see
	 * freemax.model.units.Weapon#canAttack(freemax.model.units.FreemaxUnit)
     */
    @Override
    public boolean canAttack(JeneralUnit unit) {
        return unit.isGroundUnit();
    }
}
