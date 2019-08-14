package travelAgency.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long hotelId;

    @Column
    private String name;

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tour> tours;

    public Hotel() {
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId &&
                Objects.equals(name, hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, name);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                '}';
    }
}
