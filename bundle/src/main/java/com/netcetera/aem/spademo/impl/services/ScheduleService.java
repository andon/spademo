package com.netcetera.aem.spademo.impl.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.stereotype.Service;

import com.netcetera.aem.spademo.impl.domain.ConferenceDay;
import com.netcetera.aem.spademo.impl.domain.Slot;
import com.netcetera.aem.spademo.impl.domain.Sort;

@Service
public class ScheduleService {

	private static final Set<Slot> FIRST_DAY_SLOTS;
	private static final Set<Slot> SECOND_DAY_SLOTS;
	private static final Set<Slot> THIRD_DAY_SLOTS;
	
	public ConferenceDay getConferenceDayFor(int day, Sort sort) {
		switch (day) {
		case 1:
			List<Slot> orderedFirstDaySlots = new ArrayList<Slot>(FIRST_DAY_SLOTS);
			Collections.sort(orderedFirstDaySlots, sort.getComparator());
			return new ConferenceDay(new LocalDate(22, 9, 2014), orderedFirstDaySlots);
		case 2:
			List<Slot> orderedSecondDaySlots = new ArrayList<Slot>(SECOND_DAY_SLOTS);
			Collections.sort(orderedSecondDaySlots, sort.getComparator());
			return new ConferenceDay(new LocalDate(23, 9, 2014), orderedSecondDaySlots);
		case 3:
			List<Slot> orderedThirdDaySlots = new ArrayList<Slot>(THIRD_DAY_SLOTS);
			Collections.sort(orderedThirdDaySlots, sort.getComparator());
			return new ConferenceDay(new LocalDate(24, 9, 2014), orderedThirdDaySlots);
		case 4:
			throw new ConferenceException("Day 4 still in preparation");
		default:
			throw new IllegalStateException("Conference day " + day + " does not exist");
		}
	}
	
	static {
		// Day 1
		Set<Slot> firstDaySlots = new HashSet<Slot>();
		firstDaySlots.add(new Slot(new LocalTime(8,  30), new LocalTime(10, 30), "Rookie Session / AEM Certification", "Sebastian Schlick"));
		firstDaySlots.add(new Slot(new LocalTime(10, 30), new LocalTime(10, 45), "Opening Words", "Dominik Süß"));
		firstDaySlots.add(new Slot(new LocalTime(10, 45), new LocalTime(11, 30), "Keynote: Apache Sling - Crystal Ball", "Mike Müller, Carsten Ziegeler"));
		firstDaySlots.add(new Slot(new LocalTime(11, 30), new LocalTime(11, 45), "Break", ""));
		firstDaySlots.add(new Slot(new LocalTime(11, 45), new LocalTime(12, 15), "Data replication in Sling", "Tommaso Teofili"));
		firstDaySlots.add(new Slot(new LocalTime(12, 15), new LocalTime(13, 15), "Lunch", ""));
		firstDaySlots.add(new Slot(new LocalTime(13, 15), new LocalTime(13, 45), "Integrating Open Source Search with CQ/AEM", "Gaston Gonzalez"));
		firstDaySlots.add(new Slot(new LocalTime(13, 45), new LocalTime(14,  0), "Break", ""));
		firstDaySlots.add(new Slot(new LocalTime(14,  0), new LocalTime(14, 30), "Using OSGi Subsystems with Apache Felix", "David Bosschaert"));
		firstDaySlots.add(new Slot(new LocalTime(14, 30), new LocalTime(14, 45), "Break", ""));
		firstDaySlots.add(new Slot(new LocalTime(14, 45), new LocalTime(15, 30), "Oak, the architecture of the new repository", "Michael Dürig"));
		firstDaySlots.add(new Slot(new LocalTime(15, 30), new LocalTime(15, 45), "Break", ""));
		firstDaySlots.add(new Slot(new LocalTime(15, 45), new LocalTime(16, 15), "The proper use of ResourceAccessSecurity", "Mike Müller"));
		firstDaySlots.add(new Slot(new LocalTime(16, 15), new LocalTime(16, 30), "Break", ""));
		firstDaySlots.add(new Slot(new LocalTime(16, 30), new LocalTime(17,  0), "New features of the sling health check", "Georg Henzler"));
		firstDaySlots.add(new Slot(new LocalTime(17,  0), new LocalTime(17, 15), "Break", ""));
		firstDaySlots.add(new Slot(new LocalTime(17, 15), new LocalTime(17, 45), "Apache Sling Generic Validation Framework", "Radu Cotescu"));
		FIRST_DAY_SLOTS = Collections.unmodifiableSet(firstDaySlots);
		
		// Day 2
		Set<Slot> secondDaySlots = new HashSet<Slot>();
		secondDaySlots.add(new Slot(new LocalTime(10,  0), new LocalTime(10, 45), "Apache Sling and devops - the next frontier?", "Bertrand Delacretaz"));
		secondDaySlots.add(new Slot(new LocalTime(10, 45), new LocalTime(11,  0), "Break", ""));
		secondDaySlots.add(new Slot(new LocalTime(11,  0), new LocalTime(11, 45), "The lazy AEM-developer (Sling Models+Sightly in Action, speaker)", "Feike Visser"));
		secondDaySlots.add(new Slot(new LocalTime(11, 45), new LocalTime(12,  0), "Break", ""));
		secondDaySlots.add(new Slot(new LocalTime(12,  0), new LocalTime(12, 30), "Mobile app development with Apache Cordova and AEM", "Bruce Lefebvre"));
		secondDaySlots.add(new Slot(new LocalTime(12, 30), new LocalTime(13, 30), "Lunch", ""));
		secondDaySlots.add(new Slot(new LocalTime(13, 30), new LocalTime(14, 15), "Sling IDE tooling", "Robert Munteanu"));
		secondDaySlots.add(new Slot(new LocalTime(14, 15), new LocalTime(14, 30), "Break", ""));
		secondDaySlots.add(new Slot(new LocalTime(14, 30), new LocalTime(15, 00), "Sling Resource Merger", "Carsten Ziegeler"));
		secondDaySlots.add(new Slot(new LocalTime(15,  0), new LocalTime(15, 15), "Break", ""));
		secondDaySlots.add(new Slot(new LocalTime(15, 15), new LocalTime(15, 45), "Integrating ElasticSearch with CQ5", "Vivek Sachdeva"));
		secondDaySlots.add(new Slot(new LocalTime(15, 45), new LocalTime(18,  0), "Playground Session (Hacking & Testing, speaker)", ""));
		secondDaySlots.add(new Slot(new LocalTime(18,  0), new LocalTime(23,  0), "Evening Event - Buffet, Hacking and Socialzing", ""));
		SECOND_DAY_SLOTS = Collections.unmodifiableSet(secondDaySlots);
		
		// Day 3
		Set<Slot> thirdDaySlots = new HashSet<Slot>();
		thirdDaySlots.add(new Slot(new LocalTime(10,  0), new LocalTime(10, 30), "Dynamic Components using Single-Page-Application Concepts", "Andon Sikavica, Bojana Popovska"));
		thirdDaySlots.add(new Slot(new LocalTime(10, 30), new LocalTime(10, 45), "Break", ""));
		thirdDaySlots.add(new Slot(new LocalTime(10, 45), new LocalTime(11, 45), "Getting Started with iBeacons and AEM", "Bartłomiej Soin"));
		thirdDaySlots.add(new Slot(new LocalTime(11, 15), new LocalTime(11, 30), "Break", ""));
		thirdDaySlots.add(new Slot(new LocalTime(11, 30), new LocalTime(12,  0), "The Sling JCRBrowser", "Sandro Böhme"));
		thirdDaySlots.add(new Slot(new LocalTime(12,  0), new LocalTime(13,  0), "Lunch", ""));
		thirdDaySlots.add(new Slot(new LocalTime(13,  0), new LocalTime(13, 30), "OSGi Asynchronous Services: not just another RCP", "Michael Dürig"));
		thirdDaySlots.add(new Slot(new LocalTime(13, 30), new LocalTime(13, 45), "Break", ""));
		thirdDaySlots.add(new Slot(new LocalTime(13, 45), new LocalTime(14, 15), "Sling application architecture with Sling Models", "Stefan Seifert"));
		thirdDaySlots.add(new Slot(new LocalTime(14, 15), new LocalTime(14, 30), "Break", ""));
		thirdDaySlots.add(new Slot(new LocalTime(14, 30), new LocalTime(15,  0), "", ""));
		thirdDaySlots.add(new Slot(new LocalTime(15,  0), new LocalTime(16, 0), "Lightning Talks", ""));
		thirdDaySlots.add(new Slot(new LocalTime(16,  0), new LocalTime(16, 15), "Closing Words", ""));
		THIRD_DAY_SLOTS = Collections.unmodifiableSet(thirdDaySlots);
	}
}
