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

import jeneral.model.map.JeneralGameField;
import abstractgame.events.fieldevents.UnitAddedToFieldEvent;
import abstractgame.events.fieldevents.UnitRemovedFromFieldEvent;
import abstractgame.game.AbstractGame;
import abstractgame.game.AbstractPlayer;
import abstractgame.interfaces.UnitAddedToFieldListener;
import abstractgame.interfaces.UnitRemovedFromFieldListener;
import abstractgame.unit.AbstractMobilityRole;
import abstractgame.unit.AbstractUnit;

/**
 * The Class Unit.
 *
 * @author Nils Kuttkat
 */
public abstract class JeneralUnit extends AbstractUnit implements
        UnitAddedToFieldListener, UnitRemovedFromFieldListener {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -9208203759188787259L;

    /**
     * The carrier unit.
     */
    private JeneralCarrierUnit carrierUnit;

    /**
     * The weapon.
     */
    private JeneralWeapon weapon;

    /**
     * Instantiates a new jeneral unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     */
    public JeneralUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health,
            int movementPoints) {
        this(game, mobilityRole, player, health, movementPoints, new JeneralDummyWeapon(),
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param carrierUnit the carrier unit
     */
    public JeneralUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health,
            int movementPoints, JeneralCarrierUnit carrierUnit) {
        this(game, mobilityRole, player, health, movementPoints, new JeneralDummyWeapon(),
                carrierUnit);
    }

    /**
     * Instantiates a new jeneral unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param weapon the weapon
     */
    public JeneralUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health,
            int movementPoints, JeneralWeapon weapon) {
        this(game, mobilityRole, player, health, movementPoints, weapon,
                new JeneralDummyCarrierUnit());
    }

    /**
     * Instantiates a new jeneral unit.
     *
     * @param game the game
     * @param player the player
     * @param health the health
     * @param movementPoints the movement points
     * @param weapon the weapon
     * @param carrierUnit the carrier unit
     */
    public JeneralUnit(AbstractGame game, AbstractMobilityRole mobilityRole, AbstractPlayer player, int health,
            int movementPoints, JeneralWeapon weapon,
            JeneralCarrierUnit carrierUnit) {
        super(game, mobilityRole, player);
        this.setMaxHealth(health);
        this.setCurrentHealth(this.getMaxHealth());
        this.setMaxMovementPoints(movementPoints);
        this.setCurrentMovementPoints(this.getMaxMovementPoints());
        this.weapon = weapon;
        this.carrierUnit = carrierUnit;
    }

    /**
     * Adds the unit.
     *
     * @param unit the unit
     * @return true, if successful
     */
    public boolean addUnit(JeneralUnit unit) {
        // kann die Einheit aufgenommen werden (der Träger kann sich nicht
        // selbst aufnehmen) ?
        if (!unit.equals(this) && this.carrierUnit.addUnit(unit)) {
            // dann setze die Position der Einheit anschließend auf null
            return unit.setPosition(null);
        }
        return false;
    }

    /**
     * Attack.
     *
     * @param unit the unit
     */
    public void attack(JeneralUnit unit) {
        this.weapon.attack((JeneralGameField) this.getPosition(), unit);
    }

    /**
     * Can carry.
     *
     * @param unit the unit
     * @return true, if successful
     */
    public boolean canCarry(JeneralUnit unit) {
        return this.carrierUnit.canCarry(unit);
    }

    /**
     * Contains unit.
     *
     * @param unit the unit
     * @return true, if successful
     */
    public boolean containsUnit(AbstractUnit unit) {
        return this.carrierUnit.containsUnit(unit);
    }

    /**
     * Enter carrier.
     *
     * @param carrier the carrier
     */
    public void enterCarrier(JeneralUnit carrier) {
        // Träger ungleich null ?
        if (carrier != null
                // und befindet sich die Einheit auf einem gültigen Spielfeld ?
                && this.hasPosition()
                // und befindet sich der Träger auf demselben oder einem
                // Nachbarfeld ?
                && (this.getPosition().isNeighbor(carrier.getPosition()) || this
                .getPosition().equals(carrier.getPosition()))
                // und kann der Träger die Einheit überhaupt aufnehmen ?
                && carrier.addUnit(this)) {
            this.setPosition(null);
        }
    }

    /**
     * Gets the carrier unit.
     *
     * @return the carrier unit
     */
    public JeneralCarrierUnit getCarrierUnit() {
        return this.carrierUnit;
    }

    /**
     * Gets the weapon.
     *
     * @return the weapon
     */
    public JeneralWeapon getWeapon() {
        return this.weapon;
    }

    /**
     * Checks if is air unit.
     *
     * @return true, if is air unit
     */
    public boolean isAirUnit() {
        return false;
    }

    /*
	 * Die abstrakte Unit gehört keiner Gattung an. Unterklassen können diese
	 * Methoden überschreiben, wenn sie eine der Fragen mit true beantworten
	 * sollen.
     */
    /**
     * Checks if is ground unit.
     *
     * @return true, if is ground unit
     */
    public boolean isGroundUnit() {
        return false;
    }

    /**
     * Checks if is hostile to.
     *
     * @param abstractUnit the abstract unit
     * @return true, if is hostile to
     */
    public boolean isHostileTo(AbstractUnit abstractUnit) {
        boolean isHostile = false;

        if (abstractUnit.getPlayer() != this.getPlayer()) {
            isHostile = true;
        }

        return isHostile;
    }

    /**
     * Checks if is land unit.
     *
     * @return true, if is land unit
     */
    public boolean isLandUnit() {
        return false;
    }

    /**
     * Checks if is water unit.
     *
     * @return true, if is water unit
     */
    public boolean isWaterUnit() {
        return false;
    }

    /**
     * Release unit.
     *
     * @param unit the unit
     * @param field the field
     * @return true, if successful
     */
    public boolean releaseUnit(AbstractUnit unit, JeneralGameField field) {
        // ist das Zielfeld ungleich null und befindet sich das Zielfeld in der
        // Nachbarschaft oder ist es sogar die Position des Trägers ?
        if ((field != null && field.isNeighbor(this.getPosition()))
                || field.equals(this.getPosition())) {
            // wenn dann die Einheit an diese Position gesetzt werden kann
            if (unit.setPosition(field)) // entferne die Einheit aus dem Träger
            {
                return this.carrierUnit.removeUnit(unit);
            }
        }
        return false;
    }

    /**
     * Sets the weapon.
     *
     * @param weapon the new weapon
     */
    public void setWeapon(JeneralWeapon weapon) {
        this.weapon = weapon;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see util.game.AbstractUnit#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getName() + "{" + this.getPosition() + ", "
                + this.getCurrentHealth() + "/" + this.getMaxHealth() + ", "
                + this.getCurrentMovementPoints() + "/"
                + this.getMaxMovementPoints() + "}";
    }

    /* (non-Javadoc)
	 * @see abstractgame.AbstractUnit#unitAddedToField(abstractgame.events.fieldevents.UnitAddedToFieldEvent)
     */
    @Override
    public void unitAddedToField(UnitAddedToFieldEvent event) {
        if (event.getUnit().getPlayer() != this.getPlayer()) {
            event.getSource().setNeighborEdges(this);
        }
    }

    /* (non-Javadoc)
	 * @see abstractgame.AbstractUnit#unitRemovedFromField(abstractgame.events.fieldevents.UnitRemovedFromFieldEvent)
     */
    @Override
    public void unitRemovedFromField(UnitRemovedFromFieldEvent event) {
        if (event.getUnit().getPlayer() != this.getPlayer()) {
            event.getSource().setNeighborEdges(this);
        }
    }
}
