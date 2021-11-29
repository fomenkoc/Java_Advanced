package com.gmail.fomenkoc.homeworks.homework24.classes;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {
	private Set<Seance> seances;

	public Schedule() {
		super();
		this.seances = new TreeSet<Seance>();
	}
	
	public void addSeance(Seance seance) {
		this.seances.add(seance);
		
	}
	
	public void removeSeance(Seance seance) {
		Iterator<Seance> iter = this.seances.iterator();
		while (iter.hasNext()) {
			if (iter.equals(seance))
				iter.remove();
			iter.next();
		}
		
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seances);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(seances, other.seances);
	}

	@Override
	public String toString() {
		return "Schedule [seances=" + seances + "]";
	}
	
	
	

}
