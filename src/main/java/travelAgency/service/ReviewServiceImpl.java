package travelAgency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelAgency.dao.ReviewRepo;
import travelAgency.entity.Review;
import java.util.List;

@Service
public class ReviewServiceImpl implements CommonService<Review> {

    private ReviewRepo reviewRepo;

    @Autowired
    public void setReviewRepo(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public Review getById(long id) {
        return reviewRepo.getOne(id);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    @Override
    public void add(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void update(long id, String... args) {
        Review review = reviewRepo.getOne(id);
        review.setDescription(args[0]);
        reviewRepo.save(review);
    }

    @Override
    public void delete(long id) {
        reviewRepo.deleteById(id);
    }
}
