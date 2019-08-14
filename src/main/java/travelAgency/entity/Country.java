package travelAgency.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long countryId;

    @Column
    private String name;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tour> tours;

    public Country() {
    }

    public String getName() {
        return name;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
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
        Country country = (Country) o;
        return countryId == country.countryId &&
                Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                '}';
    }
}
