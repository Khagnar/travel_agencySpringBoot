package travelAgency.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long reviewId;

    @Column
    private String description;

    @OneToMany(mappedBy = "review",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tour> tours;

    public Review() {
    }

    public Review(String description) {
        this.description = description;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Review review = (Review) o;
        return reviewId == review.reviewId &&
                Objects.equals(description, review.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, description);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", description='" + description + '\'' +
                '}';
    }
}
