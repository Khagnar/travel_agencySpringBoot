package travelAgency.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long tourId;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "review_id")
    private Review review;

    @OneToMany(mappedBy = "tour",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public Tour() {
    }

    public long getTourId() {
        return tourId;
    }

    public void setTourId(long tourId) {
        this.tourId = tourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return tourId == tour.tourId &&
                name.equals(tour.name) &&
                country.equals(tour.country) &&
                hotel.equals(tour.hotel) &&
                review.equals(tour.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, name, country, hotel, review);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", hotel=" + hotel +
                ", review=" + review +
                '}';
    }
}
