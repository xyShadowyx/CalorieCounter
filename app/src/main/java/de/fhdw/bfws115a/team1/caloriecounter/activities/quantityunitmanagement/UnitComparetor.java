package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

import java.util.Comparator;

/**
 * @author Florian Obladen.
 */
public class UnitComparetor implements Comparator<Unit> {
    /**
     * Compares two units
     *
     * @param unit
     * @param t1
     * @return
     */
    @Override
    public int compare(Unit unit, Unit t1) {
        return unit.getName().compareTo(t1.getName());
    }
}
