package com.example.graphqltutorial

import com.example.graphqltutorial.model.TripDto
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TripRepository {
    
    private var trips: ArrayList<TripDto> = init()

    fun findTrip(id: String): TripDto? {
        return this.trips.find { it.id == id }
    }

    fun findTripParticipants(id: String, limit: Int = 10): List<String>? {
        return this.trips.find { it.id == id }?.participantsId?.take(limit)
    }

    fun findTrips(): List<TripDto> {
        return this.trips
    }

    private final fun init(): ArrayList<TripDto> {
        val trips = ArrayList<TripDto>()
        trips.add(TripDto("1", "Paris", "Paris", "Trip to Paris", 12, BigDecimal.valueOf(1782.20), "5", listOf("1","2")))
        trips.add(TripDto("2", "Maledives", "Maledives", "Trip to Maledives", 14,BigDecimal.valueOf(147700.99), "5", listOf("3","2")))
        trips.add(TripDto("3", "Russia", "Russia", "Trip to Russia", 43, BigDecimal.valueOf(23000.00), "5", listOf("4","1")))
        trips.add(TripDto("4", "USA", "USA", "Trip to USA", 44, BigDecimal.valueOf(10000.00), "5", listOf("3","4")))
        return trips
    }

    fun findTrips(createdTripsIds: List<String>): List<TripDto> {
        return this.trips.filter { createdTripsIds.contains(it.id) }
    }

    fun findTripsByOwner(ownerId: String, limit: Int): List<TripDto> {
        return this.trips.filter { it.ownerId == ownerId }.take(limit)
    }

    fun addTrip(trip: TripDto): String {
        val res = trips.add(trip)
        if (res) {
            return trip.id
        }
        else throw UnsupportedOperationException()
    }

}
