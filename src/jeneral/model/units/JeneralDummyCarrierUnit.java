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
 * The Class DummyCarrierUnit.
 *
 * @author Nils Kuttkat
 */
public class JeneralDummyCarrierUnit extends JeneralCarrierUnit {

    /**
     * Instantiates a new dummy carrier unit.
     */
    public JeneralDummyCarrierUnit() {
        super();
    }

    /**
     * Instantiates a new dummy carrier unit.
     *
     * @param capacity the capacity
     */
    public JeneralDummyCarrierUnit(int capacity) {
        super(capacity);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see
	 * freemax.model.units.CarrierUnit#canCarry(freemax.model.units.FreemaxUnit)
     */
    @Override
    public boolean canCarry(JeneralUnit unit) {
        return false;
    }
}
